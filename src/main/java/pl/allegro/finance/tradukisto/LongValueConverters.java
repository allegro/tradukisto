package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.LongToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.finance.tradukisto.internal.Container.englishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer;

public enum LongValueConverters {

    ENGLISH_LONG(englishContainer().getLongConverter()),
    POLISH_LONG(polishContainer().getLongConverter());

    private final LongToStringConverter converter;

    LongValueConverters(LongToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Long value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
