package pl.allegro.finance.tradukisto.internal.languages.greek;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class GreekBigNumberToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;

    public GreekBigNumberToWordsConverter(Map<Integer, GenderForms> baseValues) {
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
        if (Range.closed(1000, 999999).contains(value)) {
            return thousandsAsString(value, genderType);
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s %s", asWords(tens, genderType), asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        GenderType thousandsGenderType = genderType;
        if (hundreds / 100 == 1 && tensWithUnits > 0)
            thousandsGenderType = GenderType.FEMININE;
        return format("%s %s", asWords(hundreds, thousandsGenderType), asWords(tensWithUnits, genderType));
    }

    private String thousandsAsString(Integer value, GenderType genderType) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (other == 0) {
            return format("%s", asWords(thousands, genderType));
        }
        return format("%s %s", asWords(thousands, genderType), asWords(other, genderType));
    }
}
