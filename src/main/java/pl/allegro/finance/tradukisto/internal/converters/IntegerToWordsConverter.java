package pl.allegro.finance.tradukisto.internal.converters;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.support.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class IntegerToWordsConverter implements IntegerToStringConverter {

    private final NumberChunking numberChunking = new NumberChunking();

    private final IntegerToStringConverter hundredsToWordsConverter;
    private final List<PluralForms> pluralForms;

    public IntegerToWordsConverter(IntegerToStringConverter hundredsToWordsConverter,
                                   List<PluralForms> pluralForms) {
        this.hundredsToWordsConverter = hundredsToWordsConverter;
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Integer value) {
        checkArgument(value >= 0, "can't convert negative numbers for value %d", value);

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = Lists.reverse(pluralForms.subList(0, valueChunks.size()));

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    private String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            String currentForm = formsToUse.next().getFor(currentChunkValue);

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue));
                result.add(currentForm);
            }
        }

        return joinParts(result);
    }

    private String joinParts(List<String> result) {
        if (result.size() == 0) {
            return hundredsToWordsConverter.asWords(0);
        }

        return Joiner.on(" ").join(result).trim();
    }
}
