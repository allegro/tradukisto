package pl.allegro.finance.tradukisto.internal.languages.french;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.Range;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class FrenchNumberToWordsConverter extends NumberToWordsConverter {

    private final Map<Integer, String> exceptions;

    public FrenchNumberToWordsConverter(
            IntegerToStringConverter integerToStringConverter,
            Map<Integer, String> exceptions,
            List<PluralForms> pluralForms
    ) {

        super(integerToStringConverter, pluralForms);
        this.exceptions = exceptions;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }
        if (Range.closed(1000, 999999).contains(value)) {
            return thousandsAsString(value);
        }
        return super.asWords(value);
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
            return format("%s mille", asWords(thousands));
        }
        return format("%s mille %s", asWords(thousands), asWords(other));
    }

    private String getOneThousandAsWords(Integer other) {
        return format("mille %s", asWords(other));
    }

    private boolean nothingComesAfter(Integer other) {
        return other == 0;
    }

    private boolean isOneThousand(Integer thousands) {
        return thousands == 1;
    }
}
