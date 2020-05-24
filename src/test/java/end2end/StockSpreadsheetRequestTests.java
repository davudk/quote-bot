package end2end;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockSpreadsheetRequestTests extends RequestTestsBase {
    private static final Logger logger = LoggerFactory.getLogger(StockSpreadsheetRequestTests.class);

    @Test
    public void cereal() throws Exception {
        perform("export cereal", "600127.SS");
    }

    @Test
    public void micro() throws Exception {
        perform("excel micro", "MSFT");
    }

    @Test
    public void tech() throws Exception {
        perform("csv tech", "TECH");
    }

    @Test
    public void shampoo() {
        try {
            req("export shampoo", result -> {
                Assert.assertEquals(0, result.size());
            });
            throw new IllegalStateException("Should not have succeeded");
        } catch (IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            logger.info("Evaluation: failed as expected");
        }
    }

    @Test
    public void icecream() {
        try {
            req("spreadsheet icecream", result -> {
                Assert.assertEquals(0, result.size());
            });
            throw new IllegalStateException("Should not have succeeded");
        } catch (IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            logger.info("Evaluation: failed as expected");
        }
    }

    private void perform(String text, String expectedTicker) throws Exception {
        req(text, result -> {
            Assert.assertEquals(expectedTicker, result.get("ticker").textValue());
            Assert.assertNotNull(result.get("downloadLink").textValue());
            logger.info("Successfully evaluated: {}", text);
            logger.info("Evaluation: {} as {}", expectedTicker, result.get("downloadLink").textValue());
        });
    }
}
