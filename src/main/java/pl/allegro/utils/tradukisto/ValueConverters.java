package pl.allegro.utils.tradukisto;

import pl.allegro.utils.tradukisto.internal.IntegerToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.utils.tradukisto.internal.languages.polish.PolishContainer.polishContainer;

public enum ValueConverters {

    POLISH_INTEGER(polishContainer().getNumbersConverter());

    private IntegerToStringConverter converter;

    private ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
