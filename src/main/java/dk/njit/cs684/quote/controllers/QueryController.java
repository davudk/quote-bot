package dk.njit.cs684.quote.controllers;

import dk.njit.cs684.quote.dao.QueryRepository;
import dk.njit.cs684.quote.model.UsageLog;
import dk.njit.cs684.quote.model.UserQuery;
import dk.njit.cs684.quote.model.queries.*;
import dk.njit.cs684.quote.services.LoggerService;
import dk.njit.cs684.quote.services.QueryHandlerService;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QueryController {
    private static final Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private GrammarService grammarService;

    @Autowired
    private QueryHandlerService queryHandlerService;

    @GetMapping("/queries")
    public List<UserQuery> queries() {
        return queryRepository.getRecent();
    }

    @GetMapping("/queries/{queryId}/logs")
    public List<UsageLog> queryLogs(@PathVariable("queryId") String queryId) {
        return loggerService.getLogs(queryId);
    }

    @PostMapping("/query")
    public Object query(@RequestParam("q") String input) {
        final UserQuery userQuery = new UserQuery();
        userQuery.setUsername("SYSTEM");
        userQuery.setMessage(input);
        userQuery.setTimestamp(new Date());
        queryRepository.create(userQuery);
        userQuery.setSuccess(true);

        loggerService.setThreadLocalContext(userQuery.getId().toString());
        loggerService.info("Received an http message: " + input);

        try {
            final QueryBase query = grammarService.parse(input);
            if (query instanceof StockQuoteQuery) {
                return queryHandlerService.handle((StockQuoteQuery) query).orElseThrow(
                        () -> new RuntimeException("Failed to handle quote."));
            } else if (query instanceof HistoricalStockQuoteQuery) {
                return queryHandlerService.handle((HistoricalStockQuoteQuery) query).orElseThrow(
                        () -> new RuntimeException("Failed to handle quote."));
            } else if (query instanceof RangedStockQuoteQuery) {
                return queryHandlerService.handle((RangedStockQuoteQuery) query).orElseThrow(
                        () -> new RuntimeException("Failed to handle quote."));
            } else if (query instanceof StockStatisticsQuery) {
                return queryHandlerService.handle((StockStatisticsQuery) query).orElseThrow(
                        () -> new RuntimeException("Failed to handle quote."));
            } else if (query instanceof StockSearchQuery) {
                return queryHandlerService.handle((StockSearchQuery) query).orElseThrow(
                        () -> new RuntimeException("Failed to handle quote."));
            } else if (query instanceof StockSpreadsheetQuery) {
                return queryHandlerService.handle((StockSpreadsheetQuery) query).orElseThrow(
                        () -> new RuntimeException("Failed to handle quote."));
            } else {
                throw new RuntimeException("Unknown query grammar.");
            }
        } catch (Exception e) {
            userQuery.setSuccess(false);
            throw new RuntimeException("Failed to process query.", e);
        } finally {
            userQuery.setComplete(true);
            queryRepository.replace(userQuery);
        }
    }
}
