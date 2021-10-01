package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.finance.tradukisto.internal.Container.brazilianPortugueseContainer;
import static pl.allegro.finance.tradukisto.internal.Container.czechContainer;
import static pl.allegro.finance.tradukisto.internal.Container.englishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.frenchContainer;
import static pl.allegro.finance.tradukisto.internal.Container.germanContainer;
import static pl.allegro.finance.tradukisto.internal.Container.italianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.kazakhContainer;
import static pl.allegro.finance.tradukisto.internal.Container.latvianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.russianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.serbianCyrillicContainer;
import static pl.allegro.finance.tradukisto.internal.Container.serbianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.slovakContainer;
import static pl.allegro.finance.tradukisto.internal.Container.turkishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.ukrainianContainer;

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
    SERBIAN_CYRILLIC_INTEGER(serbianCyrillicContainer().getNumbersConverter()),
    FRENCH_INTEGER(frenchContainer().getNumbersConverter()),
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
