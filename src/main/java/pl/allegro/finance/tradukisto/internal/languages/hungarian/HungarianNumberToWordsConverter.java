package pl.allegro.finance.tradukisto.internal.languages.hungarian;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Iterator;
import java.util.List;

public class HungarianNumberToWordsConverter extends NumberToWordsConverter {

    public HungarianNumberToWordsConverter(
        GenderAwareIntegerToStringConverter hundredsToWordsConverter,
        List<PluralForms> pluralForms
    ) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        String result = super.joinValueChunksWithForms(chunks, formsToUse);
        return applyHungarianTransformations(result);
    }

    private String applyHungarianTransformations(String result) {
        return result
            .replace("kettő millió", "két millió")
            .replace("kettő milliárd", "két milliárd");
    }
}
