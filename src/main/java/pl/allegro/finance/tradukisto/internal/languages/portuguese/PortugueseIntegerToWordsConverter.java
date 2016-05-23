package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import com.google.common.base.Joiner;
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PortugueseIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, String> exceptions;
    private final GenderAwareIntegerToStringConverter smallNumbersConverter;

    public PortugueseIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                         Map<Integer, String> exceptions,
                                         GenderAwareIntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }

        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        return processNumbers(bigNumber, smallNumber);
    }

    private String processNumbers(Integer bigNumber, Integer smallNumber) {
        List<String> result = new ArrayList<>();

        if (bigNumber > 0) {
            result.add(bigNumbersConverter.asWords(bigNumber));
        }

        if (smallNumber > 0) {
            result.add(smallNumbersConverter.asWords(smallNumber, GenderType.NON_APPLICABLE));
        }

        return merge(result);
    }

    private String merge(List<String> result) {
        if (result.isEmpty()) {
            return smallNumbersConverter.asWords(0, GenderType.NON_APPLICABLE);
        }

        return Joiner.on(" ").join(result);
    }
}
