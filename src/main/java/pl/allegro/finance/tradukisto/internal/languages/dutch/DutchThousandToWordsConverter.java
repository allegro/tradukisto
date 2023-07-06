package pl.allegro.finance.tradukisto.internal.languages.dutch;

import pl.allegro.finance.tradukisto.internal.support.Range;
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

import java.util.Map;

import static java.lang.String.format;
public class DutchThousandToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;

    public DutchThousandToWordsConverter(Map<Integer, GenderForms> baseValues) {
        this.baseValues = baseValues;
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(genderType);
        } else if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        } else if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        } else if (Range.closed(1000, 999999).contains(value)) {
            return thousandsAsString(value, genderType);
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;

        // When units are 2 or 3, between the tens and the units
        if (units == 2 || units == 3) {
            return format("%sën%s", asWords(units, genderType), asWords(tens, genderType));
        } else {
            return format("%sen%s", asWords(units, genderType), asWords(tens, genderType));
        }
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;

        return format("%s%s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }

    private String thousandsAsString(Integer value, GenderType genderType) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (isOneThousand(thousands)) {
            return getOneThousandAsWords(other, genderType);
        }

        return getThousandsAsWords(thousands, other, genderType);
    }

    private String getThousandsAsWords(Integer thousands, Integer other, GenderType genderType) {
        if (other == 0) {
            return format("%sduizend", asWords(thousands, genderType));
        }
        return format("%sduizend%s", asWords(thousands, genderType), asWords(other, genderType));
    }

    private String getOneThousandAsWords(Integer other, GenderType genderType) {
        return format("duizend%s", asWords(other, genderType));
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }
}
