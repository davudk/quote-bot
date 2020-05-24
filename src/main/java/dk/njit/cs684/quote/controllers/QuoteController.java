//package dk.njit.cs684.quote.controllers;
//
//import dk.njit.cs684.quote.dao.QuoteRepository;
//import dk.njit.cs684.quote.model.Quote;
//import dk.njit.cs684.quote.services.YahooQuoteService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.Map;
//
//@RestController
//public class QuoteController {
//    private static final Logger logger = LoggerFactory.getLogger(QuoteController.class);
//
//    @Autowired
//    private YahooQuoteService yahooQuoteService;
//
//    @Autowired
//    private QuoteRepository quoteRepository;
//
//    @GetMapping("/quote")
//    public Quote quote(@RequestParam("ticker") String ticker,
//                       @RequestParam(value = "date", required = false)
//                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws IOException {
//        if (date == null || date.equals(LocalDate.now())) {
//            logger.info("Quote: {} (today)", ticker);
//            final Quote savedQuote = quoteRepository.find(ticker);
//            if (savedQuote != null) {
//                return savedQuote;
//            }
//        } else {
//            logger.info("Quote: {} on {} (historical)", ticker, date);
//            final Quote savedQuote = quoteRepository.find(ticker, date);
//            if (savedQuote != null) return savedQuote;
//
//            final Map<LocalDate, Quote> historicalQuotes = yahooQuoteService.fetchHistoricalData(ticker);
//            quoteRepository.removeAllByTicker(ticker);
//            quoteRepository.insertAll(historicalQuotes.values());
//            return historicalQuotes.get(date);
//        }
//
//        final Quote fetchedQuote = yahooQuoteService.fetch(ticker);
//        quoteRepository.update(fetchedQuote);
//        return fetchedQuote;
//    }
//
//    @GetMapping("/quotes")
//    public Object quote(@RequestParam("ticker") String ticker) throws IOException {
//        final Map<LocalDate, Quote> quotes = yahooQuoteService.fetchHistoricalData(ticker);
//        quoteRepository.removeAllByTicker(ticker);
//        quoteRepository.insertAll(quotes.values());
//
//        return quotes.values();
//    }
//}
