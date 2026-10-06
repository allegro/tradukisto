package pl.allegro.finance.tradukisto.internal.languages.finnish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.Map;

import static java.lang.String.format;

public class FinnishThousandToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;

    public FinnishThousandToWordsConverter(Map<Integer, GenderForms> baseValues) {
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
                return "kaksikymmentä";
            case 30:
                return "kolmekymmentä";
            case 40:
                return "neljäkymmentä";
            case 50:
                return "viisikymmentä";
            case 60:
                return "kuusikymmentä";
            case 70:
                return "seitsemänkymmentä";
            case 80:
                return "kahdeksankymmentä";
            case 90:
                return "yhdeksänkymmentä";
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
        return format("%s %s", thousandsWord, asWords(other, genderType));
    }

    private String getThousandsPrefix(Integer thousands, GenderType genderType) {
        if (thousands == 1) {
            return "tuhat";
        }

        return asWords(thousands, genderType) + "tuhatta";
    }
}
