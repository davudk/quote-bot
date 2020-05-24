package end2end;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RangedStockQuoteRequestTests extends RequestTestsBase {
    private static final Logger logger = LoggerFactory.getLogger(RangedStockQuoteRequestTests.class);

    @Test
    public void prudential() throws Exception {
        perform("prudential between Jan 1st and march 31st", "PRU", 94.84, 52.14);
    }

    @Test
    public void microsoft() throws Exception {
        perform("microsoft between Jan 1st 1970 and dec 31st 1999", "MSFT", 0.09, 58.38);
    }

    @Test
    public void google() throws Exception {
        perform("how much was google between Jan 1st 2018 and jan 1st 2019", "GOOG", 1065, 1045.85);
    }

    @Test
    public void fuelCell() throws Exception {
        perform("what was the price of fuelcell between Dec 1st 2019 and jan 31st 2020", "FCEL", 0.59, 1.59);
    }

    @Test
    public void homeDepot() throws Exception {
        perform("what was \"home depot\" between 2000-01-01 and 2009-12-31", "HD", 65.19, 28.93);
    }

    private void perform(String text, String expectedTicker, double expectedFirstValue, double expectedLastValue) throws Exception {
        req(text, result -> {
            Assert.assertEquals(expectedTicker, result.get(0).get("ticker").textValue());
            Assert.assertEquals(expectedFirstValue, result.get(0).get("value").doubleValue(), 0.01);
            Assert.assertEquals(expectedTicker, result.get(result.size() - 1).get("ticker").textValue());
            Assert.assertEquals(expectedLastValue, result.get(result.size() - 1).get("value").doubleValue(), 0.01);
            logger.info("Successfully evaluated: {}", text);
            logger.info("Evaluation: {} as range between {} and {}", expectedTicker, expectedFirstValue, expectedLastValue);
        });
    }
}
