package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class PortugueseThousandToWordsConverter implements IntegerToStringConverter {

    private static final boolean HAS_NEXT_VALUE = true;
    private static final boolean HAS_NOT_NEXT_VALUE = false;
    private static final int HUNDRED = 100;

    private final Map<Integer, GenderForms> baseValues;
    private final Map<Integer, MultiFormNumber> exceptions;
    private final GenderType genderType = GenderType.NON_APPLICABLE;

    public PortugueseThousandToWordsConverter(
        Map<Integer, GenderForms> baseValues,
        Map<Integer, MultiFormNumber> exceptions
    ) {
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
        }
        if (exceptions.containsKey(value)) {
            return hasNextNumber
                    ? exceptions.get(value).getRegularForm()
                    : exceptions.get(value).getAloneForm();
        }
        if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value);
        }
        if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value);
        }
        if (Range.closed(1000, 999999).contains(value)) {
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
        return format("%s e %s", asWords(hundreds, true), asWords(tensWithUnits));
    }

    private String thousandsAsString(Integer value) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (isOneThousand(thousands)) {
            return getOneThousandAsWords(other);
        }

        return getThousandsAsWords(thousands, other);
    }

    private String getThousandsAsWords(Integer thousands, Integer other) {
        if (nothingComesAfter(other)) {
            return format("%s mil", asWords(thousands));
        }
        if (other == HUNDRED) {
            return format("%s mil e %s", asWords(thousands, HAS_NOT_NEXT_VALUE), asWords(other, HAS_NOT_NEXT_VALUE));
        }
        return format("%s mil %s", asWords(thousands), asWords(other, HAS_NEXT_VALUE));
    }

    private String getOneThousandAsWords(Integer other) {
        if (nothingComesAfter(other)) {
            return "mil";
        }
        if (other == HUNDRED) {
            return format("mil e %s", asWords(other, HAS_NOT_NEXT_VALUE));
        }
        return format("mil %s", asWords(other, HAS_NEXT_VALUE));
    }

    private boolean nothingComesAfter(Integer other) {
        return other == 0;
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }
}
