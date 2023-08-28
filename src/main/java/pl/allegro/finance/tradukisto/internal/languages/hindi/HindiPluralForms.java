package pl.allegro.finance.tradukisto.internal.languages.hindi;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class HindiPluralForms implements PluralForms {

    private final String form;

    public HindiPluralForms(String form) {
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
