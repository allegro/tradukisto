package pl.allegro.finance.tradukisto.internal.languages.hungarian;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class HungarianThousandToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;

    public HungarianThousandToWordsConverter(Map<Integer, GenderForms> baseValues) {
        this.baseValues = baseValues;
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(genderType);
        }
        if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        }
        if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        }
        if (Range.closed(1000, 999999).contains(value)) {
            return thousandsAsString(value, genderType);
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;

        String tensWord = getTensPrefix(tens);
        String unitsWord = asWords(units, genderType);

        return tensWord + unitsWord;
    }

    private String getTensPrefix(Integer tens) {
        switch (tens) {
            case 20:
                return "huszon";
            case 30:
                return "harminc";
            case 40:
                return "negyven";
            case 50:
                return "ötven";
            case 60:
                return "hatvan";
            case 70:
                return "hetven";
            case 80:
                return "nyolcvan";
            case 90:
                return "kilencven";
            default:
                throw new IllegalArgumentException("Invalid tens value: " + tens);
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

        String thousandsWord = getThousandsPrefix(thousands, genderType);

        if (other == 0) {
            return thousandsWord;
        }
        return format("%s%s", thousandsWord, asWords(other, genderType));
    }

    private String getThousandsPrefix(Integer thousands, GenderType genderType) {
        if (thousands == 1) {
            return "ezer";
        }
        if (thousands == 2) {
            return "kétezer";
        }
        return asWords(thousands, genderType) + "ezer";
    }
}
