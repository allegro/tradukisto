package pl.allegro.finance.tradukisto.internal.languages.finnish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FinnishNumberToWordsConverter extends NumberToWordsConverter {

    public FinnishNumberToWordsConverter(
            GenderAwareIntegerToStringConverter hundredsToWordsConverter,
            List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            int chunk = chunks.next();
            PluralForms forms = formsToUse.next();

            if (chunk > 0) {
                if (chunk != 1) {
                    result.add(hundredsToWordsConverter.asWords(chunk, forms.genderType()));
                }

                result.add(forms.formFor(chunk));
            }
        }

        return joinParts(result);
    }
}
