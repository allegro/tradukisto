package pl.allegro.finance.tradukisto.internal.converters;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
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
        validate(value);

        Integer units = value.intValue();
        Integer subunits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        return format(FORMAT, converter.asWords(units), currencySymbol, subunits);
    }

    private void validate(BigDecimal value) {
        checkArgument(value.scale() <= MAXIMAL_DECIMAL_PLACES_COUNT,
                "can't transform more than %s decimal places for value %f", MAXIMAL_DECIMAL_PLACES_COUNT, value);

        checkArgument(valueLessThatIntMax(value),
                "can't transform numbers greater than Integer.MAX_VALUE for value %f", value);

        checkArgument(valueGreatThanOrEqualToZero(value),
                "can't transform numbers less than zero for value %f", value);
    }

    private boolean valueLessThatIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) == -1;
    }

    private boolean valueGreatThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }
}
