package pl.allegro.finance.tradukisto.internal.languages.czech;

import com.google.common.base.Joiner;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CzechIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final IntegerToStringConverter smallNumbersConverter;
    private Map<Integer, String> exceptions;

    public CzechIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                        IntegerToStringConverter smallNumbersConverter,
                                        Map<Integer, String> exceptions) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.smallNumbersConverter = smallNumbersConverter;
        this.exceptions = exceptions;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }

        Integer bigNumber = value / 1000;
        Integer smallNumber = value % 1000;

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
            return smallNumbersConverter.asWords(0);
        }

        return Joiner.on(" ").join(result);
    }
}
