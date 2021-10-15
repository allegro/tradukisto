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
import static pl.allegro.finance.tradukisto.internal.Container.serbianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.serbianCyrillicContainer;
import static pl.allegro.finance.tradukisto.internal.Container.slovakContainer;
import static pl.allegro.finance.tradukisto.internal.Container.turkishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.ukrainianContainer;

public enum ValueConverters {

    BRAZILIAN_PORTUGUESE_INTEGER(brazilianPortugueseContainer().getIntegerConverter()),
    CZECH_INTEGER(czechContainer().getIntegerConverter()),
    ENGLISH_INTEGER(englishContainer().getIntegerConverter()),
    FRENCH_INTEGER(frenchContainer().getIntegerConverter()),
    GERMAN_INTEGER(germanContainer().getIntegerConverter()),
    ITALIAN_INTEGER(italianContainer().getIntegerConverter()),
    KAZAKH_INTEGER(kazakhContainer().getIntegerConverter()),
    LATVIAN_INTEGER(latvianContainer().getIntegerConverter()),
    POLISH_INTEGER(polishContainer().getIntegerConverter()),
    RUSSIAN_INTEGER(russianContainer().getIntegerConverter()),
    SERBIAN_INTEGER(serbianContainer().getIntegerConverter()),
    SERBIAN_CYRILLIC_INTEGER(serbianCyrillicContainer().getIntegerConverter()),
    SLOVAK_INTEGER(slovakContainer().getIntegerConverter()),
    TURKISH_INTEGER(turkishContainer().getIntegerConverter()),
    UKRAINIAN_INTEGER(ukrainianContainer().getIntegerConverter());

    private final IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
