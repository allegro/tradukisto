package pl.allegro.finance.tradukisto.internal;

import java.math.BigDecimal;

public interface BigDecimalToStringConverter {
    String asWords(BigDecimal value);
    String asWords(BigDecimal value, String currencySymbol);
}
