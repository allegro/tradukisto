package pl.allegro.finance.tradukisto.internal.languages.japanese;

import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.Assert;
import pl.allegro.finance.tradukisto.internal.support.JapaneseNumberChunking;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;

import java.util.List;

public class JapaneseNumberToWordsConverter extends NumberToWordsConverter {
    
    private final NumberChunking numberChunking = new JapaneseNumberChunking();

    private final List<PluralForms> pluralForms;

    public JapaneseNumberToWordsConverter(JapaneseThousandToWordsConverter japaneseThousandToWordsConverter, List<PluralForms> pluralForms) {
        super(japaneseThousandToWordsConverter, pluralForms);
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Long value) {
        Assert.isTrue(value >= 0, () -> String.format("can't convert negative numbers for value %d", value));

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = getRequiredFormsInReversedOrder(valueChunks.size());

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    @Override
    protected String joinParts(List<String> result) {
        return result.isEmpty()
                ? hundredsToWordsConverter.asWords(0, pluralForms.get(0).genderType())
                : String.join("", result).trim();
    }
}
