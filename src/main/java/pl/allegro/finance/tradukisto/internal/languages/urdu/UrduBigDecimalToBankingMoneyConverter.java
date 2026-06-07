package pl.allegro.finance.tradukisto.internal.languages.urdu;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.support.Assert;

import java.math.BigDecimal;

import static java.lang.String.format;

public class UrduBigDecimalToBankingMoneyConverter implements BigDecimalToStringConverter {
    private static final String SUBUNIT_SEPARATOR = ",";
    private static final String FORMAT = "%s %s%s %s";
    private static final int MAXIMAL_DECIMAL_PLACES_COUNT = 2;

    private final IntegerToStringConverter converter;
    private final UrduValues urduValues;

    public UrduBigDecimalToBankingMoneyConverter(IntegerToStringConverter converter, UrduValues urduValues) {
        this.converter = converter;
        this.urduValues = urduValues;
    }


    @Override
    public String asWords(BigDecimal value) {
        return asWords(value, urduValues.currency());
    }

    @Override
    public String asWords(BigDecimal value, String currencySymbol) {
        validate(value);

        Integer units = value.intValue();
        int subUnits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        String tempSubUnitSymbol = urduValues.paiseSymbol();
        String tempSubUnitWords = SUBUNIT_SEPARATOR + converter.asWords(subUnits);

        if (subUnits <= 0) {
            tempSubUnitSymbol = "";
            tempSubUnitWords = "";
        }

        String formattedValue = format(FORMAT, converter.asWords(units), currencySymbol, tempSubUnitWords,  tempSubUnitSymbol);
        return formattedValue.replace(Character.toString(urduValues.twoDigitsNumberSeparator()), "");

    }


    private void validate(BigDecimal value) {
        Assert.isTrue(value.scale() <= MAXIMAL_DECIMAL_PLACES_COUNT,
            () -> format("can't transform more than %s decimal places for value %s", MAXIMAL_DECIMAL_PLACES_COUNT, value));

        Assert.isTrue(valueLessThanIntMax(value),
            () -> format("can't transform numbers greater than Integer.MAX_VALUE for value %s", value));

        Assert.isTrue(valueGreaterThanOrEqualToZero(value),
            () -> format("can't transform negative numbers for value %s", value));
    }

    private boolean valueLessThanIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) < 0;
    }

    private boolean valueGreaterThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }
}
