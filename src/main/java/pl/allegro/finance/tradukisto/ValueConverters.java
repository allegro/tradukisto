package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.finance.tradukisto.internal.Container.czechContainer;
import static pl.allegro.finance.tradukisto.internal.Container.englishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.russianContainer;

public enum ValueConverters {

    POLISH_INTEGER(polishContainer().getNumbersConverter()),
    RUSSIAN_INTEGER(russianContainer().getNumbersConverter()),
    CZECH_INTEGER(czechContainer().getNumbersConverter()),
    ENGLISH_INTEGER(englishContainer().getNumbersConverter());

    private IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
