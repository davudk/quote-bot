package dk.njit.cs684.quote.services;

import dk.njit.cs684.quote.model.Quote;
import dk.njit.cs684.quote.model.YahooSearchResult;
import dk.njit.cs684.quote.model.queries.*;
import dk.njit.cs684.quote.model.responses.StockSpreadsheetResponse;
import dk.njit.cs684.quote.model.responses.StockStatisticsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class QueryHandlerService {
    private static final Logger logger = LoggerFactory.getLogger(QueryHandlerService.class);

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private YahooQuoteService yahooQuoteService;

    @Autowired
    private LoggerService loggerService;

    public Optional<Quote> handle(StockQuoteQuery query) {
        Objects.requireNonNull(query);
        return quoteService.searchAndFetch(query.getTicker());
    }

    public Optional<Quote> handle(HistoricalStockQuoteQuery query) {
        Objects.requireNonNull(query);
        return quoteService.searchAndFetch(query.getTicker(), query.getDate());
    }

    public Optional<List<Quote>> handle(RangedStockQuoteQuery query) {
        Objects.requireNonNull(query);

        LocalDate startDate = query.getStartDate();
        LocalDate endDate = query.getEndDate();

        if (endDate.isBefore(startDate)) {
            throw new RuntimeException("End date cannot be before start date.");
        } else if (endDate.isAfter(LocalDate.now())) {
            throw new RuntimeException("End date cannot be in the future.");
        }

        final Optional<Map<LocalDate, Quote>> quotes = quoteService.searchAndFetchAll(query.getTicker());
        if (!quotes.isPresent()) return Optional.empty();
        else if (quotes.get().size() <= 0) return Optional.empty();

        final TreeMap<LocalDate, Quote> map = new TreeMap<>(quotes.get());
        final LocalDate firstDate = map.firstKey();
        final LocalDate lastDate = map.lastKey();
        loggerService.info("The first date of available data is:" + firstDate);

        if (startDate.isBefore(firstDate)) {
            loggerService.warn("The chosen start date is before the first date of available data.");
            startDate = firstDate;
        }
        if (endDate.isAfter(lastDate)) {
            loggerService.warn("The chosen end date is after the last date of available data.");
            endDate = lastDate;
        }

        final long daysDiff = endDate.toEpochDay() - startDate.toEpochDay() + 1;
        loggerService.info("Difference between start and end dates: " + daysDiff);

        final long QUOTES_LIMIT = 21;
        loggerService.info("Limit number of quotes to: " + QUOTES_LIMIT);

        if (daysDiff <= QUOTES_LIMIT) {
            loggerService.info("The date diff is less than the limit. Returning all quotes within range.");

            final ArrayList<Quote> selected = new ArrayList<>();
            for (Quote q : map.values()) {
                if (q.getDate().isEqual(startDate) || q.getDate().isEqual(endDate) ||
                        (q.getDate().isAfter(startDate) && q.getDate().isBefore(endDate))) {
                    selected.add(q);
                }
            }
            return Optional.of(selected);
        }

        loggerService.info("The date diff is greater than the limit. Picking quotes at equal intervals.");
        final ArrayList<Quote> selected = new ArrayList<>();
        selected.add(map.get(startDate));
        for (long i = 0; i < QUOTES_LIMIT - 2; i++) {
            final double piece = (double) daysDiff / (QUOTES_LIMIT - 1);
            final double target = piece * (i + 1);
            final int j = (int) target;
            final LocalDate targetDate = startDate.plusDays(j);
            selected.add(map.floorEntry(targetDate).getValue());
        }
        selected.add(map.get(endDate));

        final String concat = selected.stream()
                .map(Quote::toShortDatedString)
                .collect(Collectors.joining("; "));
        loggerService.info("Returning: " + concat);

        return Optional.of(selected);
    }

    public Optional<StockStatisticsResponse> handle(StockStatisticsQuery query) {
        Objects.requireNonNull(query);
        final Optional<Map<LocalDate, Quote>> quotes = quoteService.searchAndFetchAll(query.getTicker());
        if (!quotes.isPresent()) return Optional.empty();
        else if (quotes.get().size() <= 0) return Optional.empty();

        final TreeMap<LocalDate, Quote> map = new TreeMap<>(quotes.get());

        loggerService.info("Calculating statistics.");
        final StockStatisticsResponse response = new StockStatisticsResponse();
        response.setTicker(map.firstEntry().getValue().getTicker());
        response.setOldest(map.firstEntry().getValue());
        response.setLatest(map.lastEntry().getValue());
        response.setMax(map.values().stream()
                .max(Comparator.comparing(Quote::getValue))
                .orElse(null));
        response.setMin(map.values().stream()
                .min(Comparator.comparing(Quote::getValue))
                .orElse(null));

        return Optional.of(response);
    }

    public Optional<List<YahooSearchResult>> handle(StockSearchQuery query) {
        Objects.requireNonNull(query);
        return quoteService.search(query.getTicker());
    }

    public Optional<StockSpreadsheetResponse> handle(StockSpreadsheetQuery query) {
        Objects.requireNonNull(query);
        return quoteService.search(query.getTicker())
                .map(results -> results.get(0).getSymbol())
                .map(ticker -> {
                    final StockSpreadsheetResponse response = new StockSpreadsheetResponse();
                    response.setTicker(ticker);
                    response.setDownloadLink(yahooQuoteService.getHistoricalDataURL(ticker));
                    return response;
                });
    }
}
