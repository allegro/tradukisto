package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class PortugueseIntegerToWordsConverterAdapter extends IntegerToWordsConverter {

    public PortugueseIntegerToWordsConverterAdapter(IntegerToStringConverter hundredsToWordsConverter,
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
                Integer tensWithUnits = currentChunkValue % 100;
                Integer hundreds = currentChunkValue - tensWithUnits;

                if (hundreds == 100 && tensWithUnits == 0) {
                    result.add(hundredsToWordsConverter.asWords(currentChunkValue, GenderType.NON_APPLICABLE));
                } else {
                    result.add(hundredsToWordsConverter.asWords(currentChunkValue, GenderType.NON_APPLICABLE));
                }
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

}