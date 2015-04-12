package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.support.PluralForms;

import java.util.List;
import java.util.Map;

public interface BaseValues {

    Map<Integer, String> baseNumbers();

    List<PluralForms> pluralForms();

    String currency();
}
