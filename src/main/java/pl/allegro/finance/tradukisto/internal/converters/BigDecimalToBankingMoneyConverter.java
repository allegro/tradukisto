package pl.allegro.finance.tradukisto.internal.converters;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.support.Assert;

import java.math.BigDecimal;

import static java.lang.String.format;

public class BigDecimalToBankingMoneyConverter implements BigDecimalToStringConverter {

    private static final String FORMAT = "%s %s %02d/100";
    private static final int MAXIMAL_DECIMAL_PLACES_COUNT = 2;

    private final IntegerToStringConverter converter;
    private final String currencySymbol;

    public BigDecimalToBankingMoneyConverter(IntegerToStringConverter converter, String currencySymbol) {
        this.converter = converter;
        this.currencySymbol = currencySymbol;
    }

    @Override
    public String asWords(BigDecimal value) {
        return asWords(value, currencySymbol);
    }

    @Override
    public String asWords(BigDecimal value, String currencySymbol) {
        validate(value);

        Integer units = value.intValue();
        Integer subunits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        return format(FORMAT, converter.asWords(units), currencySymbol, subunits);
    }

    private void validate(BigDecimal value) {
        Assert.isTrue(value.scale() <= MAXIMAL_DECIMAL_PLACES_COUNT,
            () -> String.format("can't transform more than %s decimal places for value %s", MAXIMAL_DECIMAL_PLACES_COUNT, value));

        Assert.isTrue(valueLessThatIntMax(value),
            () -> String.format("can't transform numbers greater than Integer.MAX_VALUE for value %s", value));

        Assert.isTrue(valueGreaterThanOrEqualToZero(value),
            () -> String.format("can't transform negative numbers for value %s", value));
    }

    private boolean valueLessThatIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) < 0;
    }

    private boolean valueGreaterThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }
}
