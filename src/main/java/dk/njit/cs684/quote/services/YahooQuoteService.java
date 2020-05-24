package dk.njit.cs684.quote.services;

import dk.njit.cs684.quote.model.Quote;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class YahooQuoteService {
    private static final Logger logger = LoggerFactory.getLogger(YahooQuoteService.class);
    private static final Pattern CURRENCY_PATTERN = Pattern.compile("^.*Currency in (.*)$");
    private String cookie, crumb;
    private Instant lastUpdatedCookieCrumbs = Instant.MIN;

    @Autowired
    private LoggerService loggerService;

//    public void updateSession() throws IOException {
//        updateSession(5);
//    }
//
//    public void updateSession(int maxTries) throws IOException {
//        if (maxTries < 1) {
//            throw new IllegalArgumentException("maxTries must be positive.");
//        }
//        for (int i = 0; i < maxTries; i++) {
//            try {
//                updateCookieCrumbs("AAPL");
//                break;
//            } catch (IOException ex) {
//                if (i + 1 == maxTries) {
//                    throw ex;
//                }
//            }
//        }
//    }

    private void updateCookieCrumbs(String ticker) throws IOException {
        // This URL maps to the "history" tab on the quote page of a ticker.
        final String encodedTicker = URLEncoder.encode(ticker, Charset.defaultCharset().name());
        final String historyurl = "https://finance.yahoo.com/quote/" + encodedTicker +
                "/history?period1=0&period2=2000000000&interval=1d&filter=history&frequency=1d";

        final Connection.Response res = Jsoup.connect(historyurl).timeout(5000).execute();

        String cookie = res.header("set-cookie").split(";")[0];
        if (cookie == null) {
            throw new RuntimeException("Cookie is missing.");
        }

        final Document doc = Jsoup.parse(res.body());

        final String SEARCH_PREFIX = "\"CrumbStore\":{\"crumb\":\"";
        String html = doc.html();
        int startIndex = html.indexOf(SEARCH_PREFIX) + SEARCH_PREFIX.length();
        int endIndex = html.indexOf('"', startIndex);
        String crumb = html.substring(startIndex, endIndex)
                .replace("\\u00", "%");

        if (crumb.length() == 0) {
            throw new IOException("Failed to update cookie crumbs");
        }

        this.cookie = cookie;
        this.crumb = crumb;

        lastUpdatedCookieCrumbs = Instant.now();
    }

    private void updateCookieCrumbsIfExpired() throws IOException {
        if (Instant.now().isAfter(lastUpdatedCookieCrumbs.plusSeconds(3600))) {
            updateCookieCrumbs("AAPL");
        }
    }

    public Quote fetch(String ticker) throws IOException {
        try {
            loggerService.info("Fetching current quote for: " + ticker);
            final String encodedTicker = URLEncoder.encode(ticker, Charset.defaultCharset().name());
            final String url = "https://finance.yahoo.com/quote/" + encodedTicker;

            final Connection.Response res = Jsoup.connect(url).timeout(5000).execute();

            final Document doc = Jsoup.parse(res.body());

            final Quote quote = new Quote();
            quote.setTicker(ticker);
            quote.setDate(LocalDate.now());
            quote.setCurrency(getQuoteCurrency(doc));
            quote.setValue(getQuoteValue(doc));
            loggerService.info("Fetched quote: " + quote);
            return quote;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch quote.");
        }
    }

    private String getQuoteCurrency(Document doc) {
        final Element currencyElement = doc.body().selectFirst("[data-reactid=5] > [data-reactid=8] > [data-reactid=9]");
        final String text = currencyElement.text();
        final Matcher matcher = CURRENCY_PATTERN.matcher(text);
        return matcher.find() ? matcher.group(1) : null;
    }

    private BigDecimal getQuoteValue(Document doc) {
//        final Element quoteElement = doc.body().selectFirst(".Trsdu(0.3s).Fw(b).Fz(36px).Mb(-4px).D(ib)");
        return doc.getAllElements().stream()
                .filter(e -> e.hasClass("Trsdu(0.3s)"))
                .filter(e -> e.hasClass("Fw(b)"))
                .filter(e -> e.hasClass("Fz(36px)"))
                .filter(e -> e.hasClass("Mb(-4px)"))
                .filter(e -> e.hasClass("D(ib)"))
                .findFirst()
                .map(Element::text)
                .map(s -> s.replaceAll(",", ""))
                .map(BigDecimal::new)
                .orElse(null);
    }

    public String getHistoricalDataURL(String ticker) {
        // NOTE: even though Yahoo doesn't show you the history of certain tickers (e.g. INR=X) the historical data
        // of those can still be taken by this method!
        try {
            final String encodedTicker = URLEncoder.encode(ticker, Charset.defaultCharset().name());
            return "https://query1.finance.yahoo.com/v7/finance/download/" + encodedTicker +
                    "?period1=0&period2=2000000000&interval=1d&events=history&crumb=" + crumb;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get historical data url.");
        }
    }

    public Map<LocalDate, Quote> fetchHistoricalData(String ticker) throws IOException {
        updateCookieCrumbsIfExpired();

        final Quote currentQuote = fetch(ticker);
        loggerService.info("Fetching historical quotes for: " + ticker);

        final String dataurl = getHistoricalDataURL(ticker);
        final Connection.Response res = Jsoup.connect(dataurl).header("cookie", cookie).timeout(30000).execute();

        final CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(res.bodyStream()));
        final Iterator<CSVRecord> it = parser.iterator();

        final TreeMap<LocalDate, Quote> quotes = new TreeMap<>();
        while (it.hasNext()) {
            final CSVRecord record = it.next();
            final Quote q = parseRecord(record);
            if (q == null) continue;
            q.setTicker(ticker);
            q.setCurrency(currentQuote.getCurrency());
            quotes.put(q.getDate(), q);
        }

        loggerService.info("Loaded " + quotes + " historical quotes.");

        performCarryOver(quotes);


        loggerService.info("There are " + quotes + " historical quotes.");
        return quotes;
    }

    private Quote parseRecord(CSVRecord record) {
        final String dateString = record.get("Date");
        final String closeString = record.get("Close");
        try {
            final LocalDate date = LocalDate.parse(dateString);
            final BigDecimal value = new BigDecimal(closeString);

            final Quote q = new Quote();
            q.setDate(date);
            q.setValue(value);

            return q;
        } catch (Exception e) {
            logger.error("Failed to parse record. Date={}; Close={}", dateString, closeString, e);
            return null;
        }
    }

    private void performCarryOver(TreeMap<LocalDate, Quote> quotes) {
        loggerService.info("Performing carry-over for days when the market was closed.");
        final LocalDate first = quotes.firstKey();
        final LocalDate last = quotes.lastKey();

        for (LocalDate date = first; date.isBefore(last); date = date.plusDays(1)) {
            if (quotes.containsKey(date)) continue;

            final LocalDate copyDate = quotes.higherKey(date);
            if (copyDate == null) continue;

            final Quote copyQuote = quotes.get(copyDate);
            if (copyQuote == null) continue;

            final Quote quote = new Quote();
            quote.setTicker(copyQuote.getTicker());
            quote.setDate(date);
            quote.setCurrency(copyQuote.getCurrency());
            quote.setValue(copyQuote.getValue());
            quote.setCarryOver(true);
            quotes.put(date, quote);
        }
    }
}
