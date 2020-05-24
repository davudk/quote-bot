package grammar;

import dk.njit.cs684.quote.model.queries.RangedStockQuoteQuery;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import grammar.misc.TestDateConfiguration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;
import util.TextCombinationGenerator;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static util.TextCombinationGenerator.many;

public class RangedStockQuoteQueryTest extends TestBase {
    private static Map<String, LocalDate> dates = new LinkedHashMap<>();

    @Autowired
    private GrammarService grammarService;

    @Autowired
    private TestDateConfiguration testDateConfiguration;

    @BeforeClass
    public static void init() {
        dates.put("2020-03-20", LocalDate.parse("2020-03-20"));
        dates.put("12/31/2019", LocalDate.parse("2019-12-31"));
        dates.put("02/29", LocalDate.parse("2020-02-29"));
        dates.put("april 4th", LocalDate.parse("2020-04-04"));
        dates.put("yesterday", LocalDate.parse("2020-03-19"));
        dates.put("tuesday", LocalDate.parse("2020-03-17"));
        dates.put("last month", LocalDate.parse("2020-02-20"));
        dates.put("last year", LocalDate.parse("2019-03-20"));
        dates.put("3 days ago", LocalDate.parse("2020-03-17"));
        dates.put("1 month ago", LocalDate.parse("2020-02-20"));
        dates.put("1 year ago", LocalDate.parse("2019-03-20"));
    }

    @Test
    public void perform() {
        final List<TextCombinationGenerator.Combination> c = TextCombinationGenerator.generate(many(
                many("", "how much was", "how much", "what was", "what's", "whats"),
                many("", "the price of", "the price", "price of"),
                many("TSLA", "MSFT", "cisco", "walmart"),
                many("", "between"),
                many(dates.keySet()),
                many("and", "-"),
                many(dates.keySet()),
                many("", "?")
        ));
        c.forEach(this::performParseTest);
        System.out.println("Count: " + c.size());
    }

    public void performParseTest(TextCombinationGenerator.Combination c) {
        final String expectedTicker = c.getArgs().get(2).toLowerCase();
        final LocalDate expectedStartDate = dates.get(c.getArgs().get(4));
        final LocalDate expectedEndDate = dates.get(c.getArgs().get(6));

        if (expectedEndDate.isBefore(expectedStartDate)) {
            return;
        }

        final String t = c.getText().trim();
        System.out.println(t);

        final RangedStockQuoteQuery q = grammarService.parseRangedStockQuoteQuery(t);
        Assert.assertEquals(expectedTicker, q.getTicker());
        Assert.assertEquals(expectedStartDate, q.getStartDate());
        Assert.assertEquals(expectedEndDate, q.getEndDate());
    }
}
