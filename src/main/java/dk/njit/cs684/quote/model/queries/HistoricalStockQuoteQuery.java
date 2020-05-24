package dk.njit.cs684.quote.model.queries;

import java.time.LocalDate;

public class HistoricalStockQuoteQuery extends QueryBase {
    public String ticker;
    public LocalDate date;

    public HistoricalStockQuoteQuery() { }
    public HistoricalStockQuoteQuery(String input, String ticker, LocalDate date) {
        super(input);
        this.ticker = ticker;
        this.date = date;
    }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
