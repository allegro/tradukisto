package pl.allegro.finance.tradukisto.internal.languages.spanish;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Range;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

public class SpanishThousandToWordsConverter implements IntegerToStringConverter {

    private static final boolean HAS_NEXT_VALUE = true;
    private static final boolean HAS_NOT_NEXT_VALUE = false;
    private static final int HUNDRED = 100;

    private final Map<Integer, GenderForms> baseValues;
    private final Map<Integer, MultiFormNumber> exceptions;
    private final GenderType genderType = GenderType.NON_APPLICABLE;

    public SpanishThousandToWordsConverter(Map<Integer, GenderForms> baseValues,
                                           Map<Integer, MultiFormNumber> exceptions) {
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
                return exceptions.get(value).getRegularForm();
            }
            return exceptions.get(value).getAloneForm();
        } else if (Range.closed(31, 99).contains(value)) {
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
        return format("%s y %s", asWords(tens), asWords(units));
    }

    private String threeDigitsNumberAsString(Integer value) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        boolean hasNextNumber = tensWithUnits != 0;
        return format("%s %s", asWords(hundreds, hasNextNumber), asWords(tensWithUnits));
    }

    private String thousandsAsString(Integer value) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (isOneThousand(thousands)) {
            return getOneThousandAsWords(other);
        }
        if (isThousandEndsWithOne(thousands)) {
            return getThousandEndWithOneAsWords(thousands, other);
        } else {
            return getThousandsAsWords(thousands, other);
        }
    }

    private String getThousandsAsWords(Integer thousands, Integer other) {
        if (nothingComesAfter(other)) {
            return format("%s mil", asWords(thousands));
        }
        if (other == HUNDRED) {
            return format("%s mil %s", asWords(thousands, HAS_NOT_NEXT_VALUE), asWords(other, HAS_NOT_NEXT_VALUE));
        }
        return format("%s mil %s", asWords(thousands), asWords(other, HAS_NEXT_VALUE));
    }

    private String getOneThousandAsWords(Integer other) {
        if (nothingComesAfter(other)) {
            return "mil";
        }
        if (other == HUNDRED) {
            return format("mil %s", asWords(other, HAS_NOT_NEXT_VALUE));
        }
        return format("mil %s", asWords(other, HAS_NEXT_VALUE));
    }

    private String getThousandEndWithOneAsWords(Integer thousands, Integer other) {
        Integer units = thousands % 10;
        Integer tens = thousands - units;
        if (thousands.intValue() == 21) {
            if (nothingComesAfter(other)) {
                return format("%siún mil", asWords(tens).substring(0, 5));
            }
            if (other == HUNDRED) {
                return format("%siún mil %s", asWords(tens, HAS_NOT_NEXT_VALUE).substring(0, 5), asWords(other, HAS_NOT_NEXT_VALUE));
            }
            return format("%siún mil %s", asWords(tens).substring(0, 5), asWords(other, HAS_NEXT_VALUE));

        } else {
            if (nothingComesAfter(other)) {
                return format("%s y un mil", asWords(tens));
            }
            if (other == HUNDRED) {
                return format("%s y un mil %s", asWords(tens, HAS_NOT_NEXT_VALUE), asWords(other, HAS_NOT_NEXT_VALUE));
            }
            return format("%s y un mil %s", asWords(tens), asWords(other, HAS_NEXT_VALUE));
        }
    }

    private boolean nothingComesAfter(Integer other) {
        return other == 0;
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }

    private boolean isThousandEndsWithOne(Integer thousands) {
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(31);
        list.add(41);
        list.add(51);
        list.add(61);
        list.add(71);
        list.add(81);
        list.add(91);
        return list.contains(thousands);
    }
}
