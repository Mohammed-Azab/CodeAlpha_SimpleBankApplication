package Internal;

import java.time.LocalDate;

public enum currency {
    USD("United States Dollar", "$"),
    EUR("Euro", "€"),
    GBP("British Pound Sterling", "£"),
    JPY("Japanese Yen", "¥"),
    AUD("Australian Dollar", "A$"),
    CAD("Canadian Dollar", "C$"),
    CHF("Swiss Franc", "Fr"),
    CNY("Chinese Yuan", "¥"),
    SEK("Swedish Krona", "kr"),
    NZD("New Zealand Dollar", "NZ$");

    private final String fullName;
    private final String symbol;

    currency(String fullName, String symbol) {
        this.fullName = fullName;
        this.symbol = symbol;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSymbol() {
        return symbol;
    }
}
