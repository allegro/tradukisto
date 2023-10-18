package pl.allegro.finance.tradukisto.internal.languages.japanese;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;

import java.util.List;

public class JapaneseNumberToWordsConverter extends NumberToWordsConverter {

    private final NumberChunking numberChunking = new NumberChunking();
    List<PluralForms> pluralForms;
    public JapaneseNumberToWordsConverter(JapaneseHundredsToWordsConverter hundredsToWordsConverter, List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Long value) {
        if(value == 1000 || value == 10000 || value == 100000000) return hundredsToWordsConverter.asWords(value.intValue(), GenderType.NON_APPLICABLE);
        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = getRequiredFormsInReversedOrder(valueChunks.size());


        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    @Override
    protected String joinParts(List<String> result) {
        return result.isEmpty()
                ? hundredsToWordsConverter.asWords(0, pluralForms.get(0).genderType())
                : result.toString();
    }
}
