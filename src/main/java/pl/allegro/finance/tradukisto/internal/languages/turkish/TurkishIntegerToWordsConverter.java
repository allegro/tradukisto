package pl.allegro.finance.tradukisto.internal.languages.turkish;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.NumberProcessor;

/**
 * @author Dilaver Demirel
 */
public class TurkishIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final TurkishSmallNumbersToWordsConverter smallNumbersConverter;

    public TurkishIntegerToWordsConverter(
        IntegerToStringConverter bigNumbersConverter,
        TurkishSmallNumbersToWordsConverter smallNumbersConverter
    ) {
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
