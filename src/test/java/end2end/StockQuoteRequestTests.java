package end2end;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockQuoteRequestTests extends RequestTestsBase {
    private static final Logger logger = LoggerFactory.getLogger(StockQuoteRequestTests.class);

    @Test
    public void amazon() throws Exception {
        perform("How much is Amazon?", "AMZN");
    }

    @Test
    public void bankOfAmerica() throws Exception {
        perform("How much is the price of \"bank of america\"?", "BAC");
    }

    @Test
    public void costco() throws Exception {
        perform("what is costco right now?", "COST");
    }

    @Test
    public void apple() throws Exception {
        perform("what is apple", "AAPL");
    }

    @Test
    public void microsoft() throws Exception {
        perform("microsoft", "MSFT");
    }

    private void perform(String text, String expectedTicker) throws Exception {
        req(text, result -> {
            Assert.assertEquals(expectedTicker, result.get("ticker").textValue());
            logger.info("Successfully evaluated: {}", text);
            logger.info("Evaluation: {} as {}", expectedTicker, result.get("value"));
        });
    }
}
