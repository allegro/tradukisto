package pl.allegro.finance.tradukisto.internal.converters;

import com.google.common.collect.Range;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import java.util.Map;

public class HundredsToWordsConverter implements IntegerToStringConverter {

    private final Map<Integer, String> baseValues;

    public HundredsToWordsConverter(Map<Integer, String> baseValues) {
        this.baseValues = baseValues;
    }

    @Override
    public String asWords(Integer value) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value);
        } else if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value);
        } else if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value);
        }

        throw new IllegalArgumentException(String.format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value) {
        Integer units = value % 10;
        Integer tens = value - units;
        return String.format("%s %s", asWords(tens), asWords(units));
    }

    private String threeDigitsNumberAsString(Integer value) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return String.format("%s %s", asWords(hundreds), asWords(tensWithUnits));
    }
}
