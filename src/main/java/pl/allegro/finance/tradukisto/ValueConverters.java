package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.finance.tradukisto.internal.Container.*;

public enum ValueConverters {

    BRAZILIAN_PORTUGUESE_INTEGER(brazilianPortugueseContainer().getNumbersConverter()),
    ENGLISH_INTEGER(englishContainer().getNumbersConverter()),
    GERMAN_INTEGER(germanContainer().getNumbersConverter()),
    RUSSIAN_INTEGER(russianContainer().getNumbersConverter()),
    ITALIAN_INTEGER(italianContainer().getNumbersConverter()),
    POLISH_INTEGER(polishContainer().getNumbersConverter()),
    CZECH_INTEGER(czechContainer().getNumbersConverter()),
    SLOVAK_INTEGER(slovakContainer().getNumbersConverter()),
    LATVIAN_INTEGER(latvianContainer().getNumbersConverter()),
    KAZAKH_INTEGER(kazakhContainer().getNumbersConverter()),
    UKRAINIAN_INTEGER(ukrainianContainer().getNumbersConverter()),
    SERBIAN_INTEGER(serbianContainer().getNumbersConverter()),
    FRENCH_INTEGER(frenchContainer().getNumbersConverter()),
    TURKISH_INTEGER(turkishContainer().getNumbersConverter()),
    KYRGYZ_INTEGER(kyrgyzContainer().getNumbersConverter());

    private final IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
