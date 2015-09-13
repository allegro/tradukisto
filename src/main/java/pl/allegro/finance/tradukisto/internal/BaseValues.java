package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

public interface BaseValues {

    Map<Integer, GenderForms> baseNumbers();

    Map<Integer, String> exceptions();

    List<PluralForms> pluralForms();

    String currency();

    char twoDigitsNumberSeparator();
}
