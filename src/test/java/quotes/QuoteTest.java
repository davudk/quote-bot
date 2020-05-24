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

public class QuoteTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(QuoteTest.class);

    @Autowired
    private YahooQuoteService yahooQuoteService;

    @Test
    public void AAPL() throws IOException {
        quoteRange("AAPL", "USD", 280, 30);
    }

    @Test
    public void MSFT() throws IOException {
        quoteRange("MSFT", "USD", 170, 30);
    }

    @Test
    public void TSLA() throws IOException {
        quoteRange("TSLA", "USD", 730, 200);
    }

    @Test
    public void INR_X() throws IOException {
        quoteRange("INR=X", "INR", 70, 15);
    }

    @Test
    public void TRY_X() throws IOException {
        quoteRange("TRY=X", "TRY", 6.5, 0.5);
    }

    private void quoteRange(String ticker, String currency, double value, double valueDelta) throws IOException {
        final Quote quote = yahooQuoteService.fetch(ticker);
        logger.info("{}: {} {}", quote.getTicker(), quote.getValue(), quote.getCurrency());

        Assert.assertEquals(quote.getTicker(), ticker);
        Assert.assertEquals(quote.getDate(), LocalDate.now());
        Assert.assertEquals(quote.getCurrency(), currency);
        Assert.assertEquals(value, quote.getValue().doubleValue(), valueDelta);
    }
}
