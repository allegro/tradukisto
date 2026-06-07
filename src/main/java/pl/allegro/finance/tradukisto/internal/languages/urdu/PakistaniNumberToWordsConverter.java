package pl.allegro.finance.tradukisto.internal.languages.urdu;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;
import pl.allegro.finance.tradukisto.internal.support.UrduNumberChunking;

import java.util.List;

public class PakistaniNumberToWordsConverter extends NumberToWordsConverter {

    private final NumberChunking numberChunking = new UrduNumberChunking();

    public PakistaniNumberToWordsConverter(GenderAwareIntegerToStringConverter hundredsToWordsConverter, List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    public String asWords(Long value) {
        Long absValue = Math.abs(value);

        List<Integer> valueChunks = numberChunking.chunk(absValue);
        List<PluralForms> formsToUse = getRequiredFormsInReversedOrder(valueChunks.size());

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    @Override
    public String asWords(Integer value) {
        return this.asWords(value.longValue());
    }
}
