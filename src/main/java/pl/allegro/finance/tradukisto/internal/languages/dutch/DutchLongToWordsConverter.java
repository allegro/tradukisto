package pl.allegro.finance.tradukisto.internal.languages.dutch;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.LongToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.Assert;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.reverse;

public class DutchLongToWordsConverter implements LongToStringConverter {

    private final NumberChunking numberChunking = new NumberChunking();

    private final GenderAwareIntegerToStringConverter hundredsToWordsConverter;
    private final List<PluralForms> pluralForms;

    public DutchLongToWordsConverter(
        GenderAwareIntegerToStringConverter hundredsToWordsConverter,
        List<PluralForms> pluralForms
    ) {
        this.hundredsToWordsConverter = hundredsToWordsConverter;
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Long value) {
        Assert.isTrue(value >= 0, () -> String.format("can't convert negative numbers for value %d", value));

        List<String> result = new ArrayList<>();

        long bigNumber = value / 1000000;
        long smallNumber = value % 1000000;

        if (bigNumber > 0) {
            List<Integer> valueChunks = numberChunking.chunk(bigNumber);
            List<PluralForms> formsToUse = getRequiredFormsInReversedOrder(valueChunks.size());
            result.add(joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator()));
        }

        if (smallNumber > 0) {
            result.add(hundredsToWordsConverter.asWords((int) smallNumber, GenderType.NON_APPLICABLE));
        }

        return joinParts(result);
    }

    protected List<PluralForms> getRequiredFormsInReversedOrder(int chunks) {
        List<PluralForms> formsToUse = new ArrayList<>(pluralForms.subList(0, chunks));
        reverse(formsToUse);
        return formsToUse;
    }

    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                String words = hundredsToWordsConverter.asWords(currentChunkValue, currentForms.genderType());
                result.add(words);
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

    protected String joinParts(List<String> result) {
        return result.isEmpty()
            ? hundredsToWordsConverter.asWords(0, pluralForms.get(0).genderType())
            : String.join(" ", result).trim();
    }
}
