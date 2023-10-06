package pl.allegro.finance.tradukisto.internal.languages.spanish;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class SpanishThousandToWordsConverter implements IntegerToStringConverter {

    private static final String MIL = "%s mil";
    private static final String MIL_UN = "mil %s";
    private static final String S_MIL_S = "%s mil %s";
    private static final String IUN_MIL = "%siún mil";
    private static final String IUN_MIL_WITH_HUNDRED = "%siún mil %s";
    private static final String Y_UN_MIL = "%s y un mil";
    private static final String Y_UN_MIL_WITH_HUNDRED = "%s y un mil %s";

    private static final boolean HAS_NEXT_VALUE = true;
    private static final boolean HAS_NOT_NEXT_VALUE = false;
    private static final int HUNDRED = 100;
    private static final GenderType genderType = GenderType.NEUTER;

    private final Map<Integer, GenderForms> baseValues;
    private final Map<Integer, MultiFormNumber> exceptions;

    public SpanishThousandToWordsConverter(Map<Integer, GenderForms> baseValues, Map<Integer, MultiFormNumber> exceptions) {
        this.baseValues = baseValues;
        this.exceptions = exceptions;
    }

    @Override
    public String asWords(Integer value) {
        return asWords(value, HAS_NEXT_VALUE);
    }

    private String asWords(Integer value, boolean hasNextNumber) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(genderType);
        }
        if (exceptions.containsKey(value)) {
            if (hasNextNumber) {
                return exceptions.get(value).getRegularForm();
            } else {
                return exceptions.get(value).getAloneForm();
            }
        }
        if (Range.closed(31, 99).contains(value)) {
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
        if (isEndsWithOne(thousands)) {
            return getEndWithOneAsWords(thousands, other);
        } else {
            return getThousandsAsWords(thousands, other);
        }
    }

    private String getThousandsAsWords(Integer thousands, Integer other) {
        if (nothingComesAfter(other)) {
            return format(MIL, asWords(thousands));
        }
        if (other == HUNDRED) {
            return format(S_MIL_S, asWords(thousands, HAS_NOT_NEXT_VALUE), asWords(other, HAS_NOT_NEXT_VALUE));
        }
        return format(S_MIL_S, asWords(thousands), asWords(other, HAS_NEXT_VALUE));
    }

    private String getOneThousandAsWords(Integer other) {
        if (nothingComesAfter(other)) {
            return "mil";
        }
        if (other == HUNDRED) {
            return format(MIL_UN, asWords(other, HAS_NOT_NEXT_VALUE));
        }
        return format(MIL_UN, asWords(other, HAS_NEXT_VALUE));
    }

    private String getEndWithOneAsWords(Integer thousands, Integer other) {
        Integer units = thousands % 10;
        Integer tens = thousands - units;
        if (thousands == 21) {
            if (nothingComesAfter(other)) {
                return format(IUN_MIL, asWords(tens).substring(0, 5));
            }
            if (other == HUNDRED) {
                return format(IUN_MIL_WITH_HUNDRED, asWords(tens, HAS_NOT_NEXT_VALUE).substring(0, 5), asWords(other, HAS_NOT_NEXT_VALUE));
            }
            return format(IUN_MIL_WITH_HUNDRED, asWords(tens).substring(0, 5), asWords(other, HAS_NEXT_VALUE));

        } else {
            if (nothingComesAfter(other)) {
                return format(Y_UN_MIL, asWords(tens));
            }
            if (other == HUNDRED) {
                return format(Y_UN_MIL_WITH_HUNDRED, asWords(tens, HAS_NOT_NEXT_VALUE), asWords(other, HAS_NOT_NEXT_VALUE));
            }
            return format(Y_UN_MIL_WITH_HUNDRED, asWords(tens), asWords(other, HAS_NEXT_VALUE));
        }
    }

    private boolean nothingComesAfter(Integer other) {
        return other == 0;
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }

    private boolean isEndsWithOne(Integer number) {
        if (number > 20 && number < 100) {
            return (Math.abs(number) % 10) == 1;
        }
        return false;
    }
}