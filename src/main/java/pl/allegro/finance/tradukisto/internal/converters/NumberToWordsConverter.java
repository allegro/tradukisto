package pl.allegro.finance.tradukisto.internal.converters;

import com.google.common.base.Joiner;
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.LongToStringConverter;
import pl.allegro.finance.tradukisto.internal.ToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.reverse;

public class NumberToWordsConverter implements IntegerToStringConverter, LongToStringConverter {

    private final NumberChunking numberChunking = new NumberChunking();

    protected final GenderAwareIntegerToStringConverter hundredsToWordsConverter;
    private final List<PluralForms> pluralForms;

    public NumberToWordsConverter(GenderAwareIntegerToStringConverter hundredsToWordsConverter,
                                  List<PluralForms> pluralForms) {
        this.hundredsToWordsConverter = hundredsToWordsConverter;
        this.pluralForms = pluralForms;
    }

    public NumberToWordsConverter(final IntegerToStringConverter hundredsToWordsConverter,
                                  List<PluralForms> pluralForms) {
        this.hundredsToWordsConverter = ToStringConverter.toGenderAwareInteger(hundredsToWordsConverter);
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Integer value) {
        return asWords(value.longValue());
    }

    @Override
    public String asWords(Long value) {
        checkArgument(value >= 0, "can't convert negative numbers for value %d", value);

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = reverse(pluralForms.subList(0, valueChunks.size()));

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue, currentForms.genderType()));
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

    protected String joinParts(List<String> result) {
        if (result.size() == 0) {
            return hundredsToWordsConverter.asWords(0, pluralForms.get(0).genderType());
        }

        return Joiner.on(" ").join(result).trim();
    }
}
