package pl.allegro.finance.tradukisto.internal.languages.swedish;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.NumberProcessor;

public class SwedishIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter swedishBigIntegersConverter;
    private final GenderAwareIntegerToStringConverter swedishSmallIntegersConverter;

    public SwedishIntegerToWordsConverter(IntegerToStringConverter swedishBigIntegersConverter,
                                          GenderAwareIntegerToStringConverter swedishSmallIntegersConverter) {
        this.swedishBigIntegersConverter = swedishBigIntegersConverter;
        this.swedishSmallIntegersConverter = swedishSmallIntegersConverter;
    }

    @Override
    public String asWords(Integer value) {
        Integer bigNum = value / 1000000;
        Integer smallNum = value % 1000000;
        return new NumberProcessor(this.swedishBigIntegersConverter, this.swedishSmallIntegersConverter).process(bigNum, smallNum);
    }
}
