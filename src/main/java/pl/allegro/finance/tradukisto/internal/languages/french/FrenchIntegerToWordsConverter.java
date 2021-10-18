package pl.allegro.finance.tradukisto.internal.languages.french;

import com.google.common.collect.Range;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class FrenchIntegerToWordsConverter extends IntegerToWordsConverter {

    private final Map<Integer, String> exceptions; 
    
    private boolean baseNumbers = false;

    public FrenchIntegerToWordsConverter(
            IntegerToStringConverter integerToStringConverter,
            Map<Integer, String> exceptions,
            List<PluralForms> pluralForms
    ) {

        super(integerToStringConverter, pluralForms);
        this.exceptions = exceptions;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value) && !baseNumbers) {
            return exceptions.get(value);
        }
        if (Range.closed(1000, 999999).contains(value)) {
            return thousandsAsString(value);
        }
        if (Range.closed(1000000, 999999999).contains(value)) {
            return millionsAsString(value);
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
        	baseNumbers = true;
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
    
    private String millionsAsString(Integer value) {
        Integer millions = value / 1000000;
        Integer other = value % 1000000;

        if (isOneMillion(millions)) {
            return getOneMillionAsWords(millions);
        }

        return getMillionsAsWords(millions, other);
    }
    
    private String getMillionsAsWords(Integer millions, Integer other) {
        if (nothingComesAfter(other)) {
        	baseNumbers = true;
            return format("%s millions", asWords(millions));
        }
        return format("%s millions %s", asWords(millions), asWords(other));
    }
    
    private boolean isOneMillion(Integer millions) {
        return millions == 1;
    }
    
    private String getOneMillionAsWords(Integer millions) {
        return format("%s million", asWords(millions));
    }
}
