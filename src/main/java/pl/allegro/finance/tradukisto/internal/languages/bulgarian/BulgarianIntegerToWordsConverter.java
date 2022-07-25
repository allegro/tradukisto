package pl.allegro.finance.tradukisto.internal.languages.bulgarian;

import pl.allegro.finance.tradukisto.internal.converters.HundredsToWordsConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.List;

import static java.lang.String.format;

public class BulgarianIntegerToWordsConverter extends NumberToWordsConverter {

    private final String oneThousand;

    private static final String MERGE_PATTERN = "%s %s";
    private static final int ONE_THOUSAND = 1000;
    private static final int TWO_THOUSAND = 2000;

    public BulgarianIntegerToWordsConverter(HundredsToWordsConverter hundredsToStringConverter, List<PluralForms> pluralForms, String oneThousand) {
        super(hundredsToStringConverter, pluralForms);
        this.oneThousand = oneThousand;
    }

    @Override
    public String asWords(Integer value) {
        if (value == ONE_THOUSAND) {
            return oneThousand;
        }

        if (isBetweenOneThousandAndTwoThousand(value)) {
            int remainder = getNumbersSmallerThanOneThousand(value);
            return format(MERGE_PATTERN, oneThousand, super.asWords(remainder));
        } else {
            return super.asWords(value);
        }
    }

    private boolean isBetweenOneThousandAndTwoThousand(Integer value) {
        return value >= ONE_THOUSAND && value < TWO_THOUSAND;
    }

    private Integer getNumbersSmallerThanOneThousand(Integer values) {
        return values % ONE_THOUSAND;
    }
}
