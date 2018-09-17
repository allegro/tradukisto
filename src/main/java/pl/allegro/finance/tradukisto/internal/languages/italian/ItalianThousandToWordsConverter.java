package pl.allegro.finance.tradukisto.internal.languages.italian;

import com.google.common.collect.Range;
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

import java.util.Map;

import static java.lang.String.format;

public class ItalianThousandToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;

    public ItalianThousandToWordsConverter(Map<Integer, GenderForms> baseValues) {
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

        return format("%s%s", asWords(tens, genderType), asWords(units, genderType));
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
            return format("%smila", asWords(thousands, genderType));
        }
        return format("%smila%s", asWords(thousands, genderType), asWords(other, genderType));
    }

    private String getOneThousandAsWords(Integer other, GenderType genderType) {
        return format("mille%s", asWords(other, genderType));
    }

    private boolean nothingComesAfter(Integer other) {
        return other == 0;
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }

}
