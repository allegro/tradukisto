package pl.allegro.utils.tradukisto.internal.languages.polish;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import pl.allegro.utils.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.utils.tradukisto.internal.NumberChunking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

class IntegerToPolishConverter implements IntegerToStringConverter {

    private final List<PolishPluralForms> polishPluralForms = PolishBaseValues.getPluralForms();
    private final IntegerToStringConverter hundredsToPolishConverter;
    private final NumberChunking numberChunking;

    public IntegerToPolishConverter(IntegerToStringConverter hundredsToPolishConverter,
                                    NumberChunking numberChunking) {
        this.hundredsToPolishConverter = hundredsToPolishConverter;
        this.numberChunking = numberChunking;
    }

    @Override
    public String asWords(Integer value) {
        checkArgument(value >= 0, "can't convert negative numbers for value {}", value);

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PolishPluralForms> formsToUse = Lists.reverse(polishPluralForms.subList(0, valueChunks.size()));

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    private String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PolishPluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            String currentForm = formsToUse.next().getFor(currentChunkValue);

            if (currentChunkValue > 0) {
                result.add(hundredsToPolishConverter.asWords(currentChunkValue));
                result.add(currentForm);
            }
        }

        return joinParts(result);
    }

    private String joinParts(List<String> result) {
        if (result.size() == 0) {
            return hundredsToPolishConverter.asWords(0);
        }

        return Joiner.on(" ").join(result).trim();
    }
}
