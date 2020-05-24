package dk.njit.cs684.quote.model.responses;

public class StockSpreadsheetResponse {
    private String ticker;
    private String downloadLink;

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public String getDownloadLink() { return downloadLink; }
    public void setDownloadLink(String downloadLink) { this.downloadLink = downloadLink; }
}
