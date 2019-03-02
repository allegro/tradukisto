package pl.allegro.finance.tradukisto.internal.languages.turkish;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;

/**
 * @author Dilaver Demirel
 */
public class TurkishBigDecimalToBankingMoneyConverter implements BigDecimalToStringConverter {
    private static final String SUBUNIT_SEPARATOR = ",";
    private static final String WORD_SEPARATOR = " ";
    private static final String FORMAT = "%s%s%s%s";
    private static final int MAXIMAL_DECIMAL_PLACES_COUNT = 2;

    private final IntegerToStringConverter converter;
    private final String currencySymbol;
    private final String subunitSymbol;

    public TurkishBigDecimalToBankingMoneyConverter(IntegerToStringConverter converter, String currencySymbol, String subunitSymbol) {
        this.converter = converter;
        this.currencySymbol = currencySymbol;
        this.subunitSymbol = subunitSymbol;
    }

    @Override
    public String asWords(BigDecimal value) {
        validate(value);

        Integer units = value.intValue();
        int subunits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        String tempSubunitSymbol = subunitSymbol;
        String tempSubUnitWords = SUBUNIT_SEPARATOR + converter.asWords(subunits);
        if (subunits <= 0) {
            tempSubunitSymbol = "";
            tempSubUnitWords = "";
        }

        String formattedValue = format(FORMAT, converter.asWords(units), currencySymbol, tempSubUnitWords, tempSubunitSymbol);
        String convertedToMoneyTypeValue = formattedValue.replaceAll(WORD_SEPARATOR, "");
        return convertedToMoneyTypeValue;
    }

    private void validate(BigDecimal value) {
        checkArgument(value.scale() <= MAXIMAL_DECIMAL_PLACES_COUNT,
                "can't transform more than %s decimal places for value %s", MAXIMAL_DECIMAL_PLACES_COUNT, value);

        checkArgument(valueLessThanIntMax(value),
                "can't transform numbers greater than Integer.MAX_VALUE for value %s", value);

        checkArgument(valueGreaterThanOrEqualToZero(value),
                "can't transform negative numbers for value %s", value);
    }

    private boolean valueLessThanIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) == -1;
    }

    private boolean valueGreaterThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }
}
