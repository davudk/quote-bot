package dk.njit.cs684.quote.model.queries;

public class StockQuoteQuery extends QueryBase {
    public String ticker;

    public StockQuoteQuery() { }
    public StockQuoteQuery(String input, String ticker) {
        super(input);
        this.ticker = ticker;
    }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
}
