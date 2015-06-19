package pl.allegro.finance.tradukisto.internal.languages.czech;

import com.google.common.base.Joiner;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import java.util.ArrayList;
import java.util.List;

public class CzechIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final IntegerToStringConverter smallNumbersConverter;

    public CzechIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                        IntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
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
