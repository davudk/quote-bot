package grammar;

import dk.njit.cs684.quote.model.queries.HistoricalStockQuoteQuery;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import grammar.misc.TestDateConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;
import util.TextCombinationGenerator;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static util.TextCombinationGenerator.many;

public class HistoricalStockQuoteQueryTest extends TestBase {
    private static Map<String, LocalDate> dates = new LinkedHashMap<>();

    @Autowired
    private GrammarService grammarService;

    @Autowired
    private TestDateConfiguration testDateConfiguration;

    static {
        dates.put("2020-03-20", LocalDate.parse("2020-03-20"));
        dates.put("2020-02-29", LocalDate.parse("2020-02-29"));
        dates.put("2019-12-31", LocalDate.parse("2019-12-31"));
        dates.put("1900-01-01", LocalDate.parse("1900-01-01"));
        dates.put("03/20/2020", LocalDate.parse("2020-03-20"));
        dates.put("02/29/2020", LocalDate.parse("2020-02-29"));
        dates.put("12/31/2019", LocalDate.parse("2019-12-31"));
        dates.put("1/1/1900", LocalDate.parse("1900-01-01"));
        dates.put("03/20", LocalDate.parse("2020-03-20"));
        dates.put("02/29", LocalDate.parse("2020-02-29"));
        dates.put("12/31", LocalDate.parse("2020-12-31"));
        dates.put("1/1", LocalDate.parse("2020-01-01"));
        dates.put("jan 1st", LocalDate.parse("2020-01-01"));
        dates.put("feb 2nd", LocalDate.parse("2020-02-02"));
        dates.put("mar 3rd", LocalDate.parse("2020-03-03"));
        dates.put("april 4th", LocalDate.parse("2020-04-04"));
        dates.put("december 31st", LocalDate.parse("2020-12-31"));
        dates.put("yesterday", LocalDate.parse("2020-03-19"));
        dates.put("tuesday", LocalDate.parse("2020-03-17"));
        dates.put("friday", LocalDate.parse("2020-03-13"));
        dates.put("last month", LocalDate.parse("2020-02-20"));
        dates.put("last year", LocalDate.parse("2019-03-20"));
        dates.put("3 days ago", LocalDate.parse("2020-03-17"));
        dates.put("14 days ago", LocalDate.parse("2020-03-06"));
        dates.put("1 month ago", LocalDate.parse("2020-02-20"));
        dates.put("18 months ago", LocalDate.parse("2018-09-20"));
        dates.put("1 year ago", LocalDate.parse("2019-03-20"));
        dates.put("2 years ago", LocalDate.parse("2018-03-20"));
    }

    public static List<TextCombinationGenerator.Combination> getCombinations() {
        return TextCombinationGenerator.generate(many(
                many("", "how much was", "how much", "what was", "what's", "whats"),
                many("", "the price of", "the price", "price of"),
                many("AAPL", "TSLA", "MSFT", "google", "cisco", "chase", "walmart"),
                many("", "on"),
                many(dates.keySet()),
                many("", "?")
        ));
    }

    @Test
    public void perform() {
        final List<TextCombinationGenerator.Combination> c = getCombinations();
        c.forEach(this::performParseTest);
        System.out.println("Count: " + c.size());
    }

    public void performParseTest(TextCombinationGenerator.Combination c) {
        final String expectedTicker = c.getArgs().get(2).toLowerCase();
        final LocalDate expectedDate = dates.get(c.getArgs().get(4));

        final String t = c.getText().trim();
        System.out.println(t);

        final HistoricalStockQuoteQuery q = grammarService.parseHistoricalStockQuoteQuery(t);
        Assert.assertEquals(expectedTicker, q.getTicker());
        Assert.assertEquals(expectedDate, q.getDate());
    }
}
