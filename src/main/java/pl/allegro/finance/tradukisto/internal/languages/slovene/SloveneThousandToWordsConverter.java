package pl.allegro.finance.tradukisto.internal.languages.slovene;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class SloveneThousandToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;

    public SloveneThousandToWordsConverter(Map<Integer, GenderForms> baseValues) {
        this.baseValues = baseValues;
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(genderType);
        }
        if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        }
        if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        }
        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%sin%s", asWords(units, genderType), asWords(tens, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return format("%s %s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }
}
