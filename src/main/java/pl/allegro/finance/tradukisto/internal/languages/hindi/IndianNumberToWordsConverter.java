package pl.allegro.finance.tradukisto.internal.languages.hindi;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.Assert;
import pl.allegro.finance.tradukisto.internal.support.IndianNumberChunking;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;

import java.util.List;

public class IndianNumberToWordsConverter extends NumberToWordsConverter {

    private final NumberChunking numberChunking = new IndianNumberChunking();

    public IndianNumberToWordsConverter(GenderAwareIntegerToStringConverter hundredsToWordsConverter, List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    public String asWords(Long value) {
        Assert.isTrue(value >= 0, () -> String.format("can't convert negative numbers for value %d", value));

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = getRequiredFormsInReversedOrder(valueChunks.size());


        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }
}
