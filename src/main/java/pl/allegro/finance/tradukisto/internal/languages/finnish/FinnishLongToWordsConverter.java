package pl.allegro.finance.tradukisto.internal.languages.finnish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.LongToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.Assert;

import java.util.ArrayList;
import java.util.List;

public class FinnishLongToWordsConverter implements LongToStringConverter {

    private final GenderAwareIntegerToStringConverter smallConverter;
    private final PluralForms millions, billions, trillions;
    private final PluralForms milliards;

    public FinnishLongToWordsConverter(GenderAwareIntegerToStringConverter smallConverter,
            List<PluralForms> pluralForms) {
        this.smallConverter = smallConverter;
        this.millions = pluralForms.get(0);
        this.milliards = pluralForms.get(1);
        this.billions = pluralForms.get(2);
        this.trillions = pluralForms.get(3);
    }

    @Override
    public String asWords(Long value) {
        Assert.isTrue(value >= 0, () -> String.format("can't convert negative numbers for value %d", value));

        List<Integer> groups = new ArrayList<>();
        for (long v = value; v > 0; v /= 1_000_000) {
            groups.add((int) (v % 1_000_000));
        }

        List<String> result = new ArrayList<>();
        for (int i = groups.size() - 1; i >= 0; i--) {
            int g = groups.get(i);
            if (g == 0)
                continue;

            if (i == 0) {
                result.add(words(g));
            } else if (i == 1) {
                if (g / 1000 > 0) {
                    result.add(scaled(g / 1000, milliards));
                }

                if (g % 1000 > 0) {
                    result.add(scaled(g % 1000, millions));
                }
            } else {
                result.add(scaled(g, i == 2 ? billions : trillions));
            }
        }

        return result.isEmpty() ? words(0) : String.join(" ", result);
    }

    private String scaled(int count, PluralForms forms) {
        return count == 1 ? forms.formFor(1) : words(count) + " " + forms.formFor(count);
    }

    private String words(int n) {
        return smallConverter.asWords(n, GenderType.NON_APPLICABLE);
    }
}