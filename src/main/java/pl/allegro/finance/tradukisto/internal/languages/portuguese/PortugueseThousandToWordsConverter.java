package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import static java.lang.String.format;

import java.util.Map;

import com.google.common.collect.Range;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

public class PortugueseThousandToWordsConverter implements IntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;
    private static final int HUNDRED = 100;
    private Map<Integer, String[]> exceptions;
    private GenderType genderType = GenderType.NON_APPLICABLE;

    public PortugueseThousandToWordsConverter(Map<Integer, GenderForms> baseValues,
            Map<Integer, String[]> exceptions) {
        this.baseValues = baseValues;
        this.exceptions = exceptions;
    }

    @Override
    public String asWords(Integer value) {
        return asWords(value, false);
    }

    private String asWords(Integer value, boolean hasNextNumber) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(genderType);
        } else if (exceptions.containsKey(value)) {
            if (hasNextNumber) {
                return exceptions.get(value)[1];
            }
            return exceptions.get(value)[0];
        } else if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value);
        } else if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value);
        } else if (Range.closed(1000, 999999).contains(value)) {
            return thousandsAsString(value);
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s e %s", asWords(tens), asWords(units));
    }

    private String threeDigitsNumberAsString(Integer value) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        boolean hasNextNumber = tensWithUnits != 0;
        return format("%s e %s", asWords(hundreds, hasNextNumber), asWords(tensWithUnits));
    }

    private String thousandsAsString(Integer value) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (isOneThousand(thousands)) {
            return getOneThousandFormatted(other);
        }

        return getThousandsFormatted(thousands, other);
    }

    private String getThousandsFormatted(Integer thousands, Integer other) {
        if (anythingComesAfter(other)) {
             return format("%s mil", asWords(thousands));
        }
        if (other == HUNDRED) {
            return format("%s mil e cem", asWords(thousands, false));
        }
        return format("%s mil %s", asWords(thousands), asWords(other, true));
    }

    private String getOneThousandFormatted(Integer other) {
        if (anythingComesAfter(other)) {
            return "mil";
        }
        if (other == HUNDRED) {
            return format("mil e %s", asWords(other, false));
        }
        return format("mil %s", asWords(other, true));
    }

    private boolean anythingComesAfter(Integer other) {
        return other == 0;
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }
}