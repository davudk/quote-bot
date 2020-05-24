package dk.njit.cs684.quote.model.queries;

import java.time.LocalDate;

public class RangedStockQuoteQuery extends QueryBase {
    public String ticker;
    public LocalDate startDate, endDate;

    public RangedStockQuoteQuery() { }
    public RangedStockQuoteQuery(String input, String ticker, LocalDate startDate, LocalDate endDate) {
        super(input);
        this.ticker = ticker;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
