package dk.njit.cs684.quote.model.queries;

public class StockStatisticsQuery extends QueryBase {
    public String ticker;

    public StockStatisticsQuery() { }
    public StockStatisticsQuery(String input, String ticker) {
        super(input);
        this.ticker = ticker;
    }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
}
