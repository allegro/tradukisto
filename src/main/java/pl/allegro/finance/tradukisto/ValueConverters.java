package pl.allegro.finance.tradukisto;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.finance.tradukisto.internal.Container.brazilianPortugueseContainer;
import static pl.allegro.finance.tradukisto.internal.Container.czechContainer;
import static pl.allegro.finance.tradukisto.internal.Container.englishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.germanContainer;
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.russianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.slovakContainer;
import static pl.allegro.finance.tradukisto.internal.Container.latvianContainer;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

public enum ValueConverters {

    BRAZILIAN_PORTUGUESE_INTEGER(brazilianPortugueseContainer().getNumbersConverter()),
    GERMAN_INTEGER(germanContainer().getNumbersConverter()),
    POLISH_INTEGER(polishContainer().getNumbersConverter()),
    RUSSIAN_INTEGER(russianContainer().getNumbersConverter()),
    CZECH_INTEGER(czechContainer().getNumbersConverter()),
    ENGLISH_INTEGER(englishContainer().getNumbersConverter()),
    SLOVAK_INTEGER(slovakContainer().getNumbersConverter());
    LATVIAN_INTEGER(latvianContainer().getNumbersConverter());

    private final IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
