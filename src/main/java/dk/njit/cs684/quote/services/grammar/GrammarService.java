package dk.njit.cs684.quote.services.grammar;

import dk.njit.cs684.quote.grammar.QuoteBotLexer;
import dk.njit.cs684.quote.grammar.QuoteBotParser;
import dk.njit.cs684.quote.model.queries.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Service
public class GrammarService {
    private final List<Function<String, QueryBase>> parsers = Arrays.asList(
            this::parseStockQuoteQuery,
            this::parseHistoricalStockQuoteQuery,
            this::parseRangedStockQuoteQuery,
            this::parseStockStatisticsQuery,
            this::parseStockSearchQuery,
            this::parseStockSpreadsheetQuery
    );

    @Autowired
    private GrammarDateService dateService;

    @Autowired
    private RelativeDateService relativeDateService;

    public GrammarDateService getDateService() { return dateService; }
    public void setDateService(GrammarDateService dateService) { this.dateService = dateService; }
    public RelativeDateService getRelativeDateService() { return relativeDateService; }
    public void setRelativeDateService(RelativeDateService relativeDateService) { this.relativeDateService = relativeDateService; }

    public QueryBase parse(String input) {
        Objects.requireNonNull(input);
        input = input.toLowerCase();

        final RuntimeException ee = new RuntimeException("Unable to parse query.");
        for (Function<String, QueryBase> p : parsers) {
            try {
                return p.apply(input);
            } catch (Exception e) {
                ee.addSuppressed(e);
            }
        }

        final QuoteBotLexer lexer = new QuoteBotLexer(CharStreams.fromString(input));
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final QuoteBotParser parser = new QuoteBotParser(tokenStream);
        final QuoteBotParser.StockQuoteQueryContext q = parser.stockQuoteQuery();

        throw ee;
    }

    public StockQuoteQuery parseStockQuoteQuery(String input) {
        final QuoteBotParser parser = createParser(input);
        final QuoteBotParser.StockQuoteQueryContext query = parser.stockQuoteQuery();
        if (query.exception != null) throw query.exception;

        final String ticker = idText(query.IDENTIFIER());

        return new StockQuoteQuery(input, ticker);
    }

    public HistoricalStockQuoteQuery parseHistoricalStockQuoteQuery(String input) {
        final QuoteBotParser parser = createParser(input);
        final QuoteBotParser.HistoricalStockQuoteQueryContext query = parser.historicalStockQuoteQuery();
        if (query.exception != null) throw query.exception;

        final String ticker = idText(query.IDENTIFIER());
        final LocalDate date = dateService.parseAnyDate(query.onAnyDate().anyDate());

        return new HistoricalStockQuoteQuery(input, ticker, date);
    }

    public RangedStockQuoteQuery parseRangedStockQuoteQuery(String input) {
        final QuoteBotParser parser = createParser(input);
        final QuoteBotParser.RangedStockQuoteQueryContext query = parser.rangedStockQuoteQuery();
        if (query.exception != null) throw query.exception;

        final String ticker = idText(query.IDENTIFIER());
        final LocalDate startDate = dateService.parseAnyDate(query.anyDate(0));
        final LocalDate endDate = dateService.parseAnyDate(query.anyDate(1));

        return new RangedStockQuoteQuery(input, ticker, startDate, endDate);
    }

    public StockStatisticsQuery parseStockStatisticsQuery(String input) {
        final QuoteBotParser parser = createParser(input);
        final QuoteBotParser.StockStatisticsQueryContext query = parser.stockStatisticsQuery();
        if (query.exception != null) throw query.exception;

        final String ticker = idText(query.IDENTIFIER());

        return new StockStatisticsQuery(input, ticker);
    }

    public StockSearchQuery parseStockSearchQuery(String input) {
        final QuoteBotParser parser = createParser(input);
        final QuoteBotParser.StockSearchQueryContext query = parser.stockSearchQuery();
        if (query.exception != null) throw query.exception;

        final String ticker = idText(query.IDENTIFIER());

        return new StockSearchQuery(input, ticker);
    }

    public StockSpreadsheetQuery parseStockSpreadsheetQuery(String input) {
        final QuoteBotParser parser = createParser(input);
        final QuoteBotParser.StockSpreadsheetQueryContext query = parser.stockSpreadsheetQuery();
        if (query.exception != null) throw query.exception;

        final String ticker = idText(query.IDENTIFIER());

        return new StockSpreadsheetQuery(input, ticker);
    }

    private QuoteBotParser createParser(String input) {
        Objects.requireNonNull(input);
        input = input.toLowerCase().trim();
        final QuoteBotLexer lexer = new QuoteBotLexer(CharStreams.fromString(input));
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new QuoteBotParser(tokenStream);
    }

    private String idText(TerminalNode t) {
        Objects.requireNonNull(t);
        final String text = t.getText();
        if (text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1);
        } else return text;
    }
}
