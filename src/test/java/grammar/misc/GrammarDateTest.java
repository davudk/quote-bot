package grammar.misc;

import dk.njit.cs684.quote.services.grammar.GrammarDateService;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestBase;
import util.TestUtil;

import java.io.IOException;
import java.time.LocalDate;

public class GrammarDateTest extends TestBase {
    @Autowired
    private GrammarDateService dateService;

    @Before
    public void initialize() {
        dateService.getRelativeDateService().setTestDate(LocalDate.parse("2020-03-20"));
    }

    @Test
    public void anyDateTests() throws IOException {
        TestUtil.performTest("queries/date-tests.txt", parts -> {
            final QuoteBotLexer lexer = new QuoteBotLexer(CharStreams.fromString(parts[0]));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final QuoteBotParser parser = new QuoteBotParser(tokenStream);

            final QuoteBotParser.AnyDateContext c = parser.anyDate();
            final LocalDate expected = LocalDate.parse(parts[1]);
            final LocalDate actual = dateService.parseAnyDate(c);
            Assert.assertEquals(expected, actual);
        });
    }

    @Test
    public void testOne() throws IOException {
        final QuoteBotLexer lexer = new QuoteBotLexer(CharStreams.fromString("5 days ago"));
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final QuoteBotParser parser = new QuoteBotParser(tokenStream);

        final QuoteBotParser.RelativeDayContext c = parser.relativeDay();
        final LocalDate expected = LocalDate.parse("2020-03-15");
        final LocalDate actual = dateService.parseRelativeDay(c);
        Assert.assertEquals(expected, actual);
    }
}
