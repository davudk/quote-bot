package dk.njit.cs684.quote.model.responses;

import dk.njit.cs684.quote.model.Quote;

public class StockStatisticsResponse {
    private String ticker;
    private Quote oldest, latest, min, max;

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public Quote getOldest() { return oldest; }
    public void setOldest(Quote oldest) { this.oldest = oldest; }
    public Quote getLatest() { return latest; }
    public void setLatest(Quote latest) { this.latest = latest; }
    public Quote getMin() { return min; }
    public void setMin(Quote min) { this.min = min; }
    public Quote getMax() { return max; }
    public void setMax(Quote max) { this.max = max; }

//    @Override
//    public String toString() {
//        return String.format("%s oldest[%s] latest[%s] min[%s] max[%s]",
//                ticker,
//                oldest.toShortDatedString(),
//                latest.toShortDatedString(),
//                min.toShortDatedString(),
//                max.toShortDatedString());
//    }
}
