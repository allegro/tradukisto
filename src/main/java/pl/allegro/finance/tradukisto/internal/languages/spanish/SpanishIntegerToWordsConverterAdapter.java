package pl.allegro.finance.tradukisto.internal.languages.spanish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class SpanishIntegerToWordsConverterAdapter extends IntegerToWordsConverter {

    public SpanishIntegerToWordsConverterAdapter(IntegerToStringConverter hundredsToWordsConverter,
                                                 List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue, GenderType.NON_APPLICABLE));
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

}
