package end2end;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockSearchRequestTests extends RequestTestsBase {
    private static final Logger logger = LoggerFactory.getLogger(StockSearchRequestTests.class);

    @Test
    public void cereal() throws Exception {
        perform("search cereal", "600127.SS");
    }

    @Test
    public void micro() throws Exception {
        perform("dir micro", "MSFT");
    }

    @Test
    public void tech() throws Exception {
        perform("list tech", "TECH");
    }

    @Test
    public void shampoo() {
        try {
            req("search shampoo", result -> {
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
            req("search icecream", result -> {
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
            Assert.assertEquals(expectedTicker, result.get(0).get("symbol").textValue());
            logger.info("Successfully evaluated: {}", text);
            logger.info("Evaluation: first result is {}", expectedTicker);
        });
    }
}
