package pl.allegro.utils.tradukisto.internal.languages.polish;

import pl.allegro.utils.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.utils.tradukisto.internal.IntegerToStringConverter;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

class BigDecimalToPolishBankingMoneyValueConverter implements BigDecimalToStringConverter {

    private static final String FORMAT = "%s PLN %02d/100";
    private static final int MAXIMAL_DECIMAL_PLACES_COUNT = 2;

    private final IntegerToStringConverter converter;

    public BigDecimalToPolishBankingMoneyValueConverter(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    @Override
    public String asWords(BigDecimal value) {
        validateValue(value);

        Integer units = value.intValue();
        Integer subunits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        return String.format(FORMAT, converter.asWords(units), subunits);
    }

    private void validateValue(BigDecimal value) {
        checkArgument(value.scale() <= MAXIMAL_DECIMAL_PLACES_COUNT,
                "can't transform more than {} decimal places for value {}", MAXIMAL_DECIMAL_PLACES_COUNT, value);

        checkArgument(valueLessThatIntMax(value),
                "can't transform numbers greater than Integer.MAX_VALUE for value {}", value);
    }

    private boolean valueLessThatIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) == -1;
    }
}
