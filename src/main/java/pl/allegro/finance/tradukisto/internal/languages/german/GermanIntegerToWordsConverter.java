package pl.allegro.finance.tradukisto.internal.languages.german;

import com.google.common.base.Joiner;
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

import java.util.ArrayList;
import java.util.List;

public class GermanIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final IntegerToStringConverter smallNumbersConverter;

    public GermanIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                         GenderAwareIntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        List<String> result = new ArrayList<>();

        if (bigNumber > 0) {
            result.add(bigNumbersConverter.asWords(bigNumber));
        }

        if (smallNumber > 0) {
            result.add(smallNumbersConverter.asWords(smallNumber));
        }

        return mergeResult(result);
    }

    private String mergeResult(List<String> result) {
        if (result.isEmpty()) {
            return smallNumbersConverter.asWords(0, GenderType.NON_APPLICABLE);
        }

        return Joiner.on(" ").join(result);
    }
}
