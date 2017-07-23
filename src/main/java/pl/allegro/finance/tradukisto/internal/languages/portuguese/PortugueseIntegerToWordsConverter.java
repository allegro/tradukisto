package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

public class PortugueseIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, String[]> exceptions;
    private final IntegerToStringConverter smallNumbersConverter;

    public PortugueseIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                         Map<Integer, String[]> exceptions,
                                         IntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value)[0];
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
            result.add(smallNumbersConverter.asWords(smallNumber));
        }

        return merge(result);
    }

    private String merge(List<String> result) {
        if (result.isEmpty()) {
            return smallNumbersConverter.asWords(0);
        }

        return Joiner.on(" ").join(result);
    }
}
