package dk.njit.cs684.quote.services;

import dk.njit.cs684.quote.dao.QuoteRepository;
import dk.njit.cs684.quote.model.Quote;
import dk.njit.cs684.quote.model.YahooSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuoteService {
    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private YahooQuoteService yahooQuoteService;

    @Autowired
    private YahooTickerService yahooTickerService;

    @Autowired
    private LoggerService loggerService;

    public Optional<YahooSearchResult> searchAndGetFirst(String text) {
        try {
            final Optional<List<YahooSearchResult>> results = search(text);
            if (!results.isPresent()) return Optional.empty();

            final YahooSearchResult first = results.get().get(0);
            loggerService.info("Taking first search result: " + first.getSymbol());
            return Optional.of(first);
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform search and get first.");
        }
    }

    public Optional<List<YahooSearchResult>> search(String text) {
        try {
            loggerService.info("Searching for: " + text);
            final List<YahooSearchResult> results = yahooTickerService.search(text);
            if (results.size() == 0) {
                loggerService.warn("No results were found.");
                return Optional.empty();
            }

            final String concat = results.stream()
                    .map(YahooSearchResult::getSymbol)
                    .collect(Collectors.joining(", "));
            loggerService.info(results.size() + " results were found: " + concat);

            return Optional.of(results);
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform search.");
        }
    }

    public Optional<Quote> searchAndFetch(String text) {
        try {
            final Optional<YahooSearchResult> result = searchAndGetFirst(text);
            if (!result.isPresent()) return Optional.empty();

            final String ticker = result.get().getSymbol();
            final Quote quote = yahooQuoteService.fetch(ticker);
            if (quote == null) return Optional.empty();

            loggerService.info("Updating quote in database: " + quote);
            quoteRepository.update(quote);
            return Optional.of(quote);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get quote.");
        }
    }

    public Optional<Quote> searchAndFetch(String text, LocalDate date) {
        if (date.isEqual(LocalDate.now())) return searchAndFetch(text);
        else if (date.isAfter(LocalDate.now())) return Optional.empty();

        try {
            final Optional<YahooSearchResult> result = searchAndGetFirst(text);
            if (!result.isPresent()) return Optional.empty();

            final String ticker = result.get().getSymbol();
            loggerService.info("Searching in database for: " + ticker + " on date: " + date);
            final Quote savedQuote = quoteRepository.find(ticker, date);
            if (savedQuote != null) {
                loggerService.info("No quote was found for that date.");
                return Optional.of(savedQuote);
            }

            return fetchAll(ticker)
                    .map(quotes -> quotes.get(date));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get quote.");
        }
    }

    public Optional<Map<LocalDate, Quote>> searchAndFetchAll(String text) {
        try {
            final Optional<YahooSearchResult> result = searchAndGetFirst(text);
            if (!result.isPresent()) return Optional.empty();

            final String ticker = result.get().getSymbol();
            return fetchAll(ticker);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get historical quotes.");
        }
    }

    public Optional<Map<LocalDate, Quote>> fetchAll(String ticker) {
        try {
            final Map<LocalDate, Quote> historicalQuotes = yahooQuoteService.fetchHistoricalData(ticker);
            loggerService.info("Replacing historical quotes in DB with newly loaded data: " + ticker);
            quoteRepository.removeAllByTicker(ticker);
            quoteRepository.insertAll(historicalQuotes.values());
            return Optional.of(historicalQuotes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get historical quotes.");
        }
    }
}
