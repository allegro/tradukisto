package pl.allegro.finance.tradukisto.internal.languages.kazakh;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class KazakhPluralForms implements PluralForms {

    private String form;

    public KazakhPluralForms(String form) {
        this.form = form;
    }

    @Override
    public String formFor(Integer value) {
        return form;
    }

    @Override
    public GenderType genderType() {
        return GenderType.NON_APPLICABLE;
    }
}
