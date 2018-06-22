package pl.allegro.finance.tradukisto;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.finance.tradukisto.internal.Container.*;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

public enum ValueConverters {

    BRAZILIAN_PORTUGUESE_INTEGER(brazilianPortugueseContainer().getNumbersConverter()),
    ENGLISH_INTEGER(englishContainer().getNumbersConverter()),
    GERMAN_INTEGER(germanContainer().getNumbersConverter()),
    RUSSIAN_INTEGER(russianContainer().getNumbersConverter()),
    POLISH_INTEGER(polishContainer().getNumbersConverter()),
    CZECH_INTEGER(czechContainer().getNumbersConverter()),
    SLOVAK_INTEGER(slovakContainer().getNumbersConverter()),
    LATVIAN_INTEGER(latvianContainer().getNumbersConverter()),
    KAZAKH_INTEGER(kazakhContainer().getNumbersConverter()),
    UKRAINIAN_INTEGER(ukrainianContainer().getNumbersConverter()),
    TURKISH_INTEGER(turkishContainer().getNumbersConverter());

    private final IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
