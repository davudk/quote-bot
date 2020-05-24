package grammar.misc;

import dk.njit.cs684.quote.model.queries.HistoricalStockQuoteQuery;
import dk.njit.cs684.quote.model.queries.QueryBase;
import dk.njit.cs684.quote.model.queries.RangedStockQuoteQuery;
import dk.njit.cs684.quote.model.queries.StockQuoteQuery;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;
import util.TestUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.function.BiConsumer;

public class GrammarTest extends TestBase {
    @Autowired
    private GrammarService grammarService;

    @Before
    public void initialize() {
        grammarService.getRelativeDateService().setTestDate(LocalDate.parse("2020-03-20"));
    }


    @Test
    public void stockQuoteQueriesTest() throws IOException {
        performTest("queries/stock-quote-queries.txt", StockQuoteQuery.class,
                (parts, query) -> {
                    Assert.assertEquals(parts[1], query.getTicker());
                });
    }

    @Test
    public void historicalStockQuoteQueriesTest() throws IOException {
        performTest("queries/historical-stock-quote-queries.txt", HistoricalStockQuoteQuery.class,
                (parts, query) -> {
                    Assert.assertEquals(parts[1], query.getTicker());
                    Assert.assertEquals(parts[2], query.getDate().toString());
                });
    }

    @Test
    public void rangedStockQuoteQueriesTest() throws IOException {
        performTest("queries/ranged-stock-quote-queries.txt", RangedStockQuoteQuery.class,
                (parts, query) -> {
                    Assert.assertEquals(parts[1], query.getTicker());
                    Assert.assertEquals(parts[2], query.getStartDate().toString());
                    Assert.assertEquals(parts[3], query.getEndDate().toString());
                });
    }

    private <T extends QueryBase> void performTest(String filename,
                                                   Class<T> expectedQueryClass,
                                                   BiConsumer<String[], T> consumer) throws IOException {
        TestUtil.performTest(filename, parts -> {
            final QueryBase query = grammarService.parse(parts[0]);
            Assert.assertNotNull(query);
            Assert.assertEquals(expectedQueryClass, query.getClass());
            consumer.accept(parts, (T) query);
        });
    }
}
