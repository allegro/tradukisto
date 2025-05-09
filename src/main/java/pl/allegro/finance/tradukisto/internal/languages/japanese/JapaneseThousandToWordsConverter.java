package pl.allegro.finance.tradukisto.internal.languages.japanese;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class JapaneseThousandToWordsConverter implements IntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;

    public JapaneseThousandToWordsConverter(Map<Integer, GenderForms> baseValues) {
        this.baseValues = baseValues;
    }

    @Override
    public String asWords(Integer value) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(GenderType.NON_APPLICABLE);
        }
        if (Range.closed(11, 99).contains(value)) {
            return twoDigitsNumberAsString(value);
        }
        if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value);
        }
        if (Range.closed(1001, 9999).contains(value)) {
            return fourDigitsNumberAsString(value);
        }
        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s%s", asWords(tens), asWords(units));
    }   

    private String threeDigitsNumberAsString(Integer value) {
        Integer units = value % 100;
        Integer hundreds = value - units;
        return format("%s%s", asWords(hundreds), asWords(units));
    }

    private String fourDigitsNumberAsString(Integer value) {
        Integer units = value % 1000;
        Integer thousands = value - units;
        return format("%s%s", asWords(thousands), asWords(units));
    }
}
