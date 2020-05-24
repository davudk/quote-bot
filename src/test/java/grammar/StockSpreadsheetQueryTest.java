package grammar;

import dk.njit.cs684.quote.model.queries.StockSpreadsheetQuery;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;
import util.TextCombinationGenerator;

import java.util.List;

import static util.TextCombinationGenerator.many;

public class StockSpreadsheetQueryTest extends TestBase {

    @Autowired
    private GrammarService grammarService;

    @Test
    public void perform() {
        final List<TextCombinationGenerator.Combination> c = TextCombinationGenerator.generate(many(
                many("export", "spreadsheet", "excel", "csv", "history", "historical"),
                many("AAPL", "TSLA", "MSFT", "google", "cisco", "chase", "walmart"),
                many("", "?", " ?")
        ));
        c.forEach(this::performParseTest);
        System.out.println("Count: " + c.size());
    }

    public void performParseTest(TextCombinationGenerator.Combination c) {
        String t = c.getText().trim();
        System.out.println(t);

        final StockSpreadsheetQuery q = grammarService.parseStockSpreadsheetQuery(t);
        Assert.assertEquals(c.getArgs().get(1).toLowerCase(), q.getTicker());
    }
}
