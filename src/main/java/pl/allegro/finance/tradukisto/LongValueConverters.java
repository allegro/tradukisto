package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.LongToStringConverter;
import java.util.Objects;

import static pl.allegro.finance.tradukisto.internal.Container.croatianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.englishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.hindiContainer;

public enum LongValueConverters {

    CROATIAN_LONG(croatianContainer().getLongConverter()),
    ENGLISH_LONG(englishContainer().getLongConverter()),
    POLISH_LONG(polishContainer().getLongConverter()),
    HINDI_LONG(hindiContainer().getLongConverter());

    private final LongToStringConverter converter;

    LongValueConverters(LongToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Long value) {
        Objects.requireNonNull(value);

        return converter.asWords(value);
    }
}
