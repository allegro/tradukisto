package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.LongToStringConverter;
import java.util.Objects;

import static pl.allegro.finance.tradukisto.internal.Container.*;

public enum LongValueConverters {

    CROATIAN_LONG(croatianContainer().getLongConverter()),
    ENGLISH_LONG(englishContainer().getLongConverter()),
    POLISH_LONG(polishContainer().getLongConverter()),
    HINDI_LONG(hindiContainer().getLongConverter()),
    SWEDISH_LONG(swedishContainer().getLongConverter()),
    JAPANESE_KANJI_LONG(japaneseKanjiContainer().getLongConverter()),
    CHINESE_HANZI_LONG(chineseHanZiContainer().getLongConverter());

    private final LongToStringConverter converter;

    LongValueConverters(LongToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Long value) {
        Objects.requireNonNull(value);

        return converter.asWords(value);
    }
}
