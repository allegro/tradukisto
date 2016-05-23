package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import static java.lang.String.format;

import java.util.Map;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

import com.google.common.collect.Range;

public class PortugueseThousandToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;
    private static final int HUNDRED = 100;

    public PortugueseThousandToWordsConverter(Map<Integer, GenderForms> baseValues) {
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
        return format("%s e %s", asWords(tens, genderType), asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return format("%s e %s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }

    private String thousandsAsString(Integer value, GenderType genderType) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (isOneThousand(thousands)) {
            return getOneThousandFormatted(other, genderType);
        }

        return getThousandsFormatted(thousands, other, genderType);
    }

    private String getThousandsFormatted(Integer thousands, Integer other, GenderType genderType) {
        if (anythingComesAfter(other)) {
             return format("%s mil", asWords(thousands, GenderType.NEUTER));
        }
        if (other == HUNDRED) {
            return format("%s mil e %s", asWords(thousands, genderType), asWords(other, GenderType.NEUTER));
        }
        return format("%s mil %s", asWords(thousands, genderType), asWords(other, genderType));
    }

    private String getOneThousandFormatted(Integer other, GenderType genderType) {
        if (anythingComesAfter(other)) {
            return "mil";
        }
        if (other == HUNDRED) {
            return format("mil e %s", asWords(other, GenderType.NEUTER));
        }
        return format("mil %s", asWords(other, genderType));
    }

    private boolean anythingComesAfter(Integer other) {
        return other == 0;
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }
}