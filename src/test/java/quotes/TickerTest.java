package quotes;

import dk.njit.cs684.quote.model.YahooSearchResult;
import dk.njit.cs684.quote.services.YahooTickerService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;

import java.io.IOException;
import java.util.List;

public class TickerTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TickerTest.class);

    @Autowired
    private YahooTickerService yahooTickerService;

    @Test
    public void AAPL() throws IOException {
        search("apple", "AAPL");
    }

    @Test
    public void MSFT() throws IOException {
        search("MSFT", "MSFT");
    }

    @Test
    public void TSLA() throws IOException {
        search("teSLa", "TSLA");
    }

    @Test
    public void WMT() throws IOException {
        search("walmart", "WMT");
    }

    @Test
    public void BAC() throws IOException {
        search("bank of am", "BAC");
    }

    private void search(String text, String firstTicker) throws IOException {
        final List<YahooSearchResult> results = yahooTickerService.search(text);
        Assert.assertNotEquals(results.size(), 0);

        for (YahooSearchResult result : results) {
            System.out.println(result.getSymbol() + "\t" + result.getScore());
        }

        final YahooSearchResult first = results.get(0);
        Assert.assertNotNull(first);

        final String symbol = first.getSymbol();
        Assert.assertEquals(symbol, firstTicker);
    }
}
