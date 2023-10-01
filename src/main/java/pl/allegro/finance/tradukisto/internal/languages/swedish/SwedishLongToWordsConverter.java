package pl.allegro.finance.tradukisto.internal.languages.swedish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.Assert;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;
import pl.allegro.finance.tradukisto.internal.support.SwedishNumberChunking;

import java.util.List;

public class SwedishLongToWordsConverter extends NumberToWordsConverter {

    private final NumberChunking swedishNumberChunking = new SwedishNumberChunking();

    public SwedishLongToWordsConverter(GenderAwareIntegerToStringConverter hundredsToWordsConverter,
                                       List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    public String asWords(Long value) {
        Assert.isTrue(value >= 0, () -> String.format("can't convert negative numbers for value %d", value));

        List<Integer> valueChunks = swedishNumberChunking.chunk(value);
        List<PluralForms> formsToUse = getRequiredFormsInReversedOrder(valueChunks.size());

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }
}
