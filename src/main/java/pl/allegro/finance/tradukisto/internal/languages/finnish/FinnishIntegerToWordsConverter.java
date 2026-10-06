package pl.allegro.finance.tradukisto.internal.languages.finnish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.NumberProcessor;

public class FinnishIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final GenderAwareIntegerToStringConverter smallNumbersConverter;

    public FinnishIntegerToWordsConverter(
            IntegerToStringConverter bigNumbersConverter,
            GenderAwareIntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        return new NumberProcessor(bigNumbersConverter, smallNumbersConverter).process(bigNumber, smallNumber);
    }
}
