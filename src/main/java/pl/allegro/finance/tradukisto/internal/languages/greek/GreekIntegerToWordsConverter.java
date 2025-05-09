package pl.allegro.finance.tradukisto.internal.languages.greek;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.LongToStringConverter;
import pl.allegro.finance.tradukisto.internal.NumberProcessor;

import java.util.Map;

public class GreekIntegerToWordsConverter  implements IntegerToStringConverter, LongToStringConverter {
    private final Map<Integer, String> exceptions;

    private final NumberProcessor numberProcessor;

    public GreekIntegerToWordsConverter(
            IntegerToStringConverter bigNumbersConverter,
            IntegerToStringConverter smallNumbersConverter,
            Map<Integer, String> exceptions
    ) {
        this.numberProcessor = new NumberProcessor(bigNumbersConverter, smallNumbersConverter);
        this.exceptions = exceptions;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }

        Integer bigNumber = value / 1000;
        Integer smallNumber = value % 1000;

        return numberProcessor.process(bigNumber, smallNumber);
    }

    @Override
    public String asWords(Long value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }

        Integer bigNumber = value.intValue() / 1000;
        Integer smallNumber = value.intValue() % 1000;

        return numberProcessor.process(bigNumber, smallNumber);
    }
}
