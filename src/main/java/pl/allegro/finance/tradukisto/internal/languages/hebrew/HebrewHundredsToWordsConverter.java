package pl.allegro.finance.tradukisto.internal.languages.hebrew;

import com.google.common.collect.Range;
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

import java.util.Map;

import static java.lang.String.format;

/**
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.11.0
 * @since 1.11.0
 */
public class HebrewHundredsToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseNumbers;
    private final char twoDigitsNumberSeparator;
    private final Integer ten = 10;
    private final Integer hundred = 100;

    public HebrewHundredsToWordsConverter(HebrewValues hebrewValues) {
        this.baseNumbers = hebrewValues.baseNumbers();
        this.twoDigitsNumberSeparator = hebrewValues.twoDigitsNumberSeparator();
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        if (baseNumbers.containsKey(value)) {
            return baseNumbers.get(value).formFor(genderType);
        } else if (Range.closed(10, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        } else if (Range.closed(100, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        }
        throw new IllegalArgumentException(format("Can't convert %s", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % ten;
        Integer tens = value - units;
        return format("%s %s%s", asWords(tens, genderType), twoDigitsNumberSeparator, asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % hundred;
        Integer hundreds = value - tensWithUnits;
        if (tensWithUnits % ten == 0 || Range.closed(1, 19).contains(tensWithUnits)) {
            return String
                    .format("%s %s%s", asWords(hundreds, genderType), twoDigitsNumberSeparator, asWords(tensWithUnits, genderType));
        }
        return String.format("%s %s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }

    protected Map<Integer, GenderForms> baseNumbers() {
        return baseNumbers;
    }
}
