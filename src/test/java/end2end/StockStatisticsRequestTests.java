package end2end;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockStatisticsRequestTests extends RequestTestsBase {
    private static final Logger logger = LoggerFactory.getLogger(StockStatisticsRequestTests.class);

    @Test
    public void apple() throws Exception {
        perform("stats apple", "AAPL", 0.51);
    }

    @Test
    public void prudential() throws Exception {
        perform("stats pru", "PRU", 29.30);
    }

    @Test
    public void spy() throws Exception {
        perform("statistics spy", "SPY", 43.94);
    }

    @Test
    public void tesla() throws Exception {
        perform("stats tesla", "TSLA", 23.89);
    }

    @Test
    public void homeDepot() throws Exception {
        perform("stats HD", "HD", 0.03);
    }

    private void perform(String text, String expectedTicker, double oldestValue) throws Exception {
        req(text, result -> {
            Assert.assertEquals(expectedTicker, result.get("ticker").textValue());
            Assert.assertEquals(oldestValue, result.get("oldest").get("value").doubleValue(), 0.01);
            logger.info("Successfully evaluated: {}", text);
            logger.info("Evaluation: {} with oldest value of {}", expectedTicker, oldestValue);
        });
    }
}
