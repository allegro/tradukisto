package pl.allegro.finance.tradukisto.internal.languages.polish;

import com.google.common.collect.Range;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import java.util.Map;

class HundredsToPolishConverter implements IntegerToStringConverter {

    private final Map<Integer, String> baseValues = PolishBaseValues.getNumbers();

    @Override
    public String asWords(Integer value) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value);
        } else if (Range.closed(21, 99).contains(value)) {
            return twoDigitNumberAsString(value);
        } else if (Range.closed(101, 999).contains(value)) {
            return threeDigitNumberAsString(value);
        }

        throw new IllegalArgumentException(String.format("Can't convert %d using %s", value, getClass()));
    }

    private String twoDigitNumberAsString(Integer value) {
        Integer units = value % 10;
        Integer tens = value - units;
        return String.format("%s %s", asWords(tens), asWords(units));
    }

    private String threeDigitNumberAsString(Integer value) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return String.format("%s %s", asWords(hundreds), asWords(tensWithUnits));
    }
}
