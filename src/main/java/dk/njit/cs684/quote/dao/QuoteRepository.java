package dk.njit.cs684.quote.dao;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import dk.njit.cs684.quote.model.Quote;
import org.mongojack.JacksonMongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class QuoteRepository {
    @Autowired(required = false)
    private JacksonMongoCollection<Quote> stockQuoteCollection;

    public Quote find(String ticker, LocalDate date) {
        if (stockQuoteCollection == null) return null;
        return stockQuoteCollection.findOne(Filters.and(
                Filters.eq("ticker", ticker),
                Filters.eq("date", date)
        ));
    }

    public void update(Quote quote) {
        if (stockQuoteCollection != null) {
            stockQuoteCollection.replaceOne(
                    Filters.and(
                            Filters.eq("ticker", quote.getTicker()),
                            Filters.eq("date", quote.getDate())),
                    quote,
                    new ReplaceOptions()
                            .upsert(true));
        }
    }

    public void removeAllByTicker(String ticker) {
        if (stockQuoteCollection != null) {
            stockQuoteCollection.deleteMany(
                    Filters.eq("ticker", ticker)
            );
        }
    }

    public void insertAll(Collection<Quote> quotes) {
        if (stockQuoteCollection != null) {
            stockQuoteCollection.insertMany(new ArrayList<>(quotes));
        }
    }
}
