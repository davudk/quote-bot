package quotes;

import dk.njit.cs684.quote.model.Quote;
import dk.njit.cs684.quote.services.YahooQuoteService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class HistoricalQuotesTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(HistoricalQuotesTest.class);

    @Autowired
    private YahooQuoteService yahooQuoteService;

    @Test
    public void AAPL() throws IOException {
        verify("AAPL", "2018-04-04", 171.61);
    }

    @Test
    public void MSFT() throws IOException {
        verify("MSFT", "2015-04-04", 41.55);
    }

    @Test
    public void TSLA() throws IOException {
        verify("TSLA", "2011-04-04", 25.83);
    }

    @Test
    public void GOOG() throws IOException {
        verify("GOOG", "2004-08-29", 50.81);
    }

    @Test
    public void PRU() throws IOException {
        verify("PRU", "2009-03-02", 14.76);
    }

    private void verify(String ticker, String date, double price) throws IOException {
        final Map<LocalDate, Quote> quotes = yahooQuoteService.fetchHistoricalData(ticker);
        final Quote q = quotes.get(LocalDate.parse(date));
        Assert.assertNotNull(q);
        Assert.assertEquals(q.getValue().doubleValue(), price, 0.0125);
        logger.info("Ticker {} on {} was successfully validated as {}", ticker, date, price);
    }
}
