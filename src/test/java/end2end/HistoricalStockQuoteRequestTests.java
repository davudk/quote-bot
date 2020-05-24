package end2end;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoricalStockQuoteRequestTests extends RequestTestsBase {
    private static final Logger logger = LoggerFactory.getLogger(HistoricalStockQuoteRequestTests.class);

    @Test
    public void microsoft() throws Exception {
        perform("microsoft on Jan 1st", "MSFT", 160.62);
    }

    @Test
    public void google() throws Exception {
        perform("how much was google on july 4th 2008", "GOOG", 270.94);
    }

    @Test
    public void life() throws Exception {
        perform("what was life on march 3rd 2018", "LIFE", 42);
    }

    @Test
    public void moderna() throws Exception {
        perform("what was the price of moderna on April 1st 2020", "MRNA", 29.67);
    }

    @Test
    public void spy() throws Exception {
        perform("how much was the price of spy on dec 25th 2019", "SPY", 322.94);
    }

    private void perform(String text, String expectedTicker, double expectedValue) throws Exception {
        req(text, result -> {
            Assert.assertEquals(expectedTicker, result.get("ticker").textValue());
            Assert.assertEquals(expectedValue, result.get("value").doubleValue(), 0.01);
            logger.info("Successfully evaluated: {}", text);
            logger.info("Evaluation: {} as {}", expectedTicker, expectedValue);
        });
    }
}
