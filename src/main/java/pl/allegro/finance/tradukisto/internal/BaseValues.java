package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

public interface BaseValues {

    Map<Integer, String> baseNumbers();

    List<? extends PluralForms> pluralForms();

    String currency();
}
