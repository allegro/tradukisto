package pl.allegro.finance.tradukisto.internal.languages.hindi;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.support.Assert;

import java.math.BigDecimal;

import static java.lang.String.format;

/**
 * @author Sourabh Girdhar
 */
public class HindiBigDecimalToBankingMoneyConverter implements BigDecimalToStringConverter {
    private static final String SUBUNIT_SEPARATOR = ",";
    private static final String FORMAT = "%s %s%s %s";
    private static final int MAXIMAL_DECIMAL_PLACES_COUNT = 2;

    private final IntegerToStringConverter converter;
    private final HindiValues hindiValues;

    public HindiBigDecimalToBankingMoneyConverter(IntegerToStringConverter converter, HindiValues hindiValues) {
        this.converter = converter;
        this.hindiValues = hindiValues;
    }

    @Override
    public String asWords(BigDecimal value) {
        return asWords(value, hindiValues.currency());
    }

    @Override
    public String asWords(BigDecimal value, String currencySymbol) {
        validate(value);

        Integer units = value.intValue();
        int subunits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        String tempSubunitSymbol = hindiValues.paiseSymbol();
        String tempSubUnitWords = SUBUNIT_SEPARATOR + converter.asWords(subunits);
        if (subunits <= 0) {
            tempSubunitSymbol = "";
            tempSubUnitWords = "";
        }

        String formattedValue = format(FORMAT, converter.asWords(units), currencySymbol, tempSubUnitWords, tempSubunitSymbol);
        return formattedValue.replace(Character.toString(hindiValues.twoDigitsNumberSeparator()), "");
    }

    private void validate(BigDecimal value) {
        Assert.isTrue(value.scale() <= MAXIMAL_DECIMAL_PLACES_COUNT,
                () -> String.format("can't transform more than %s decimal places for value %s", MAXIMAL_DECIMAL_PLACES_COUNT, value));

        Assert.isTrue(valueLessThanIntMax(value),
                () -> String.format("can't transform numbers greater than Integer.MAX_VALUE for value %s", value));

        Assert.isTrue(valueGreaterThanOrEqualToZero(value),
                () -> String.format("can't transform negative numbers for value %s", value));
    }

    private boolean valueLessThanIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) < 0;
    }

    private boolean valueGreaterThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }
}
