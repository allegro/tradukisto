package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;

public class ToStringConverter {

    public static GenderAwareIntegerToStringConverter toGenderAwareInteger(final IntegerToStringConverter integerToStringConverter) {
        return new GenderAwareIntegerToStringConverter() {
            @Override
            public String asWords(Integer value, GenderType genderType) {
                return integerToStringConverter.asWords(value);
            }
        };
    }

}
