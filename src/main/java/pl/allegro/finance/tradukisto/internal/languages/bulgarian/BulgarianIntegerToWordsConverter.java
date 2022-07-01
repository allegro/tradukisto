package pl.allegro.finance.tradukisto.internal.languages.bulgarian;

import pl.allegro.finance.tradukisto.internal.converters.HundredsToWordsConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.NumberChunking;

import java.util.List;

import static com.google.common.collect.Lists.reverse;
import static java.lang.String.format;

public class BulgarianIntegerToWordsConverter extends IntegerToWordsConverter {

    private final NumberChunking numberChunking = new NumberChunking();
    private final List<PluralForms> pluralForms;
    private final String thousand;

    private static final String MERGE_PATTER = "%s %s";
    private static final int THOUSAND = 1000;
    private static final int TWO_THOUSAND = 2000;

    public BulgarianIntegerToWordsConverter(HundredsToWordsConverter hundredsToStringConverter, List<PluralForms> pluralForms, String thousand) {
        super(hundredsToStringConverter, pluralForms);
        this.pluralForms = pluralForms;
        this.thousand = thousand;
    }

    @Override
    public String asWords(Integer value) {
        if (checkForOneThousand(value)) {
            return thousand;
        }

        String prefix = null;
        if (checkForThousandRange(value)) {
            prefix = thousand;
            value = getSmallerNumbersThenThousand(value);
        }

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = reverse(pluralForms.subList(0, valueChunks.size()));

        String result;
        if (prefix == null) {
            result = joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
        } else {
            result = format(MERGE_PATTER, prefix, joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator()));
        }

        return result;
    }

    private boolean checkForThousandRange(Integer value) {
        return value >= THOUSAND && value < TWO_THOUSAND;
    }

    private boolean checkForOneThousand(Integer value) {
        return value == THOUSAND;
    }

    private Integer getSmallerNumbersThenThousand(Integer values) {
        return values % THOUSAND;
    }
}
