package pl.allegro.finance.tradukisto.internal.languages.spanish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class SpanishIntegerToWordsConverterAdapter extends NumberToWordsConverter {

    public SpanishIntegerToWordsConverterAdapter(IntegerToStringConverter hundredsToWordsConverter,
                                                 List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        AtomicReference<List<String>> result = new AtomicReference<>(new ArrayList<>());

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.get().add(hundredsToWordsConverter.asWords(currentChunkValue, GenderType.NEUTER));
                result.get().add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result.get());
    }

}