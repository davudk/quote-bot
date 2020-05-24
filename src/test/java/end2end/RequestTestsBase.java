package end2end;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.njit.cs684.quote.controllers.QueryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;

import java.util.function.Consumer;

public abstract class RequestTestsBase extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(RequestTestsBase.class);
    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private QueryController queryController;

    protected void req(String input, Consumer<JsonNode> validator) throws Exception {
        final Object output = queryController.query(input);
        JsonNode result = om.valueToTree(output);
        logger.info("Received A: " + result.toPrettyString());
        validator.accept(result);
    }
}
