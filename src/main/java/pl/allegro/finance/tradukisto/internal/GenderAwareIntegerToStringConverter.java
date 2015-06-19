package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;

public interface GenderAwareIntegerToStringConverter {
    String asWords(Integer value, GenderType genderType);
}
