package pl.allegro.finance.tradukisto.internal.languages.french;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

public class FrenchIntegerToWordsConverter extends IntegerToWordsConverter {

    private final Map<Integer, String> exceptions;

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
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }
        return super.asWords(value);
    }
}
