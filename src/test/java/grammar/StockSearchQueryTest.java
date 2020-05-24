package grammar;

import dk.njit.cs684.quote.model.queries.StockSearchQuery;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;
import util.TextCombinationGenerator;

import java.util.List;

import static util.TextCombinationGenerator.many;

public class StockSearchQueryTest extends TestBase {

    @Autowired
    private GrammarService grammarService;

    @Test
    public void perform() {
        final List<TextCombinationGenerator.Combination> c = TextCombinationGenerator.generate(many(
                many("search", "list", "dir"),
                many("AAPL", "TSLA", "MSFT", "google", "cisco", "chase", "walmart"),
                many("", "?", " ?")
        ));
        c.forEach(this::performParseTest);
        System.out.println("Count: " + c.size());
    }

    public void performParseTest(TextCombinationGenerator.Combination c) {
        String t = c.getText().trim();
        System.out.println(t);

        final StockSearchQuery q = grammarService.parseStockSearchQuery(t);
        Assert.assertEquals(c.getArgs().get(1).toLowerCase(), q.getTicker());
    }
}
