package pl.allegro.finance.tradukisto.internal.languages.turkish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import static java.lang.String.format;

/**
 * @author Dilaver Demirel
 * <p>
 * Small numbers are between 0 and 999.999
 * Big numbers are greater than 999.999
 */
public class TurkishSmallNumbersToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final TurkishValues turkishValues;
    private final char separator;

    public TurkishSmallNumbersToWordsConverter(TurkishValues turkishValues) {
        this.turkishValues = turkishValues;
        separator = turkishValues.twoDigitsNumberSeparator();
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        if (turkishValues.baseNumbers().containsKey(value)) {
            return turkishValues.baseNumbers().get(value).formFor(genderType);
        }
        if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        }
        if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        }
        if (value == 1000) {
            return "Bin";
        }
        if (Range.closed(1001, 1999).contains(value)) {
            return oneThousandsAsString(value, genderType);
        }
        if (Range.closed(2000, 999999).contains(value)) {
            return greaterThanOneThousandsAsString(value, genderType);
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s" + separator + "%s", asWords(tens, genderType), asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return format("%s" + separator + "%s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }

    private String greaterThanOneThousandsAsString(Integer value, GenderType genderType) {
        Integer thousands = value / 1000;
        Integer other = value % 1000;

        if (other == 0) {
            return format("%s" + separator + "Bin", asWords(thousands, genderType));
        }
        return format("%s" + separator + "Bin" + separator + "%s", asWords(thousands, genderType),
                asWords(other, genderType));
    }

    private String oneThousandsAsString(Integer value, GenderType genderType) {
        Integer other = value % 1000;
        return format("Bin" + separator + "%s", asWords(other, genderType));
    }
}