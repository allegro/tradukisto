package pl.allegro.finance.tradukisto.internal.languages.hebrew;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;

import java.math.BigDecimal;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

/**
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.11.0
 * @since 1.11.0
 */
public class HebrewBigDecimalToBankingMoneyConverter implements BigDecimalToStringConverter {
    private final String prefix, suffix, currency;

    private final HebrewIntegerToWordsConverter converter;

    public HebrewBigDecimalToBankingMoneyConverter(HebrewIntegerToWordsConverter converter, HebrewValues values) {
        this.converter = converter;
        values.setPluralForms(GenderType.MASCULINE);
        prefix = values.decimalPrefix();
        suffix = values.decimalSuffix();
        currency = values.currency();
    }

    @Override
    public String asWords(BigDecimal value) {
        validate(value);
        Integer units = value.intValue();
        int decimal = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();
        if (decimal <= 0) {
            return format("%s %s", currency, asWord(units, GenderType.MASCULINE));
        }
        return format("%s %s %s%s %s", asWord(units, GenderType.MASCULINE), currency, prefix, asWord(decimal, GenderType.FEMININE), suffix);
    }

    private void validate(BigDecimal value) {
        checkArgument(value.scale() <= 2, "can't transform more than %s decimal places for value %s", 2, value);
        checkArgument(valueLessThanIntMax(value), "can't transform numbers greater than Integer.MAX_VALUE for value %s", value);
        checkArgument(valueGreaterThanOrEqualToZero(value), "can't transform negative numbers for value %s", value);
    }

    private boolean valueLessThanIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) == -1;
    }

    private boolean valueGreaterThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }

    private String asWord(Integer value, GenderType genderType) {
        converter.hebrewValues().setPluralForms(genderType);
        String word = converter.asWords(value);
        converter.hebrewValues().setPluralForms(GenderType.FEMININE);
        return word;
    }
}
