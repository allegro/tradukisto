package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.polish.PolishContainer;

import static com.google.common.base.Verify.verifyNotNull;

public enum ValueConverters {

    POLISH_INTEGER(PolishContainer.polishContainer().getNumbersConverter());

    private IntegerToStringConverter converter;

    private ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
