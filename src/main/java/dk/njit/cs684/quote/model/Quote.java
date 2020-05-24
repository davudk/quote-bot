package dk.njit.cs684.quote.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String ticker;
    private LocalDate date;
    private String currency;
    private BigDecimal value;
    private boolean carryOver;

    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }
    public boolean isCarryOver() { return carryOver; }
    public void setCarryOver(boolean carryOver) { this.carryOver = carryOver; }

    public String toShortString() {
        final String price = value
                .setScale(2, RoundingMode.HALF_EVEN)
                .toString();

        if ("USD".equalsIgnoreCase(currency)) {
            return "$" + price;
        } else {
            return String.format("%s %s", price, currency);
        }
    }

    public String toShortDatedString() {
        final String price = value
                .setScale(2, RoundingMode.HALF_EVEN)
                .toString();

        if ("USD".equalsIgnoreCase(currency)) {
            return "$" + price + " " + date;
        } else {
            return String.format("%s %s %s", price, currency, date);
        }
    }

    @Override
    public String toString() {
        final String price = value
                .setScale(2, RoundingMode.HALF_EVEN)
                .toString();

        if ("USD".equalsIgnoreCase(currency)) {
            return String.format("%s $%s", ticker.toUpperCase(), price);
        } else {
            return String.format("%s %s %s", ticker.toUpperCase(), price, currency);
        }
    }
}
