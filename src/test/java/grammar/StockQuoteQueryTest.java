package grammar;

import dk.njit.cs684.quote.model.queries.StockQuoteQuery;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;
import util.TextCombinationGenerator;

import java.util.List;

import static util.TextCombinationGenerator.many;

public class StockQuoteQueryTest extends TestBase {

    @Autowired
    private GrammarService grammarService;

    @Test
    public void perform() {
        final List<TextCombinationGenerator.Combination> c = TextCombinationGenerator.generate(many(
                many("", "how much is", "how much", "what is", "what's", "whats"),
                many("", "the price of", "the price", "price of"),
                many("AAPL", "TSLA", "MSFT", "google", "cisco", "chase", "walmart"),
                many("", "right now", "now"),
                many("", "?", " ?")
        ));
        c.forEach(this::performParseTest);
        System.out.println("Count: " + c.size());
    }

    public void performParseTest(TextCombinationGenerator.Combination c) {
        String t = c.getText().trim();
        System.out.println(t);

        final StockQuoteQuery q = grammarService.parseStockQuoteQuery(t);
        Assert.assertEquals(c.getArgs().get(2).toLowerCase(), q.getTicker());
    }
}
