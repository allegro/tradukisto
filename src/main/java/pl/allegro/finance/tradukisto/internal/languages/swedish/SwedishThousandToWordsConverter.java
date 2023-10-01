package pl.allegro.finance.tradukisto.internal.languages.swedish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class SwedishThousandToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> swedishBaseValues;

    public SwedishThousandToWordsConverter(Map<Integer, GenderForms> swedishBaseValues) {
        this.swedishBaseValues = swedishBaseValues;
    }

    @Override
    public String asWords(Integer value, GenderType swedishGenderType) {
        if (this.swedishBaseValues.containsKey(value)) {
            return this.swedishBaseValues.get(value).formFor(swedishGenderType);
        } else if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value, swedishGenderType);
        } else if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value, swedishGenderType);
        } else if (Range.closed(1000, 999999).contains(value)) {
            return thousandsAsString(value, swedishGenderType);
        }
        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s%s", asWords(tens, genderType), asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return format("%s och %s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }

    private String thousandsAsString(Integer value, GenderType genderType) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (other == 0)
            return format("%s tusen", asWords(thousands, genderType));
        return format("%s tusen %s", asWords(thousands, genderType), asWords(other, genderType));
    }
}
