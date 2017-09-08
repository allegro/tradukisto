package pl.allegro.finance.tradukisto.internal.languages.slovak;

import java.util.Map;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechIntegerToWordsConverter;

public class SlovakIntegerToWordsConverter extends CzechIntegerToWordsConverter {

    public SlovakIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                        IntegerToStringConverter smallNumbersConverter,
                                        Map<Integer, String> exceptions) {
        super(bigNumbersConverter, smallNumbersConverter, exceptions);
    }

}
