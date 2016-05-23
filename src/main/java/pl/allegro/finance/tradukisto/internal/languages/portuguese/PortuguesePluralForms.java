package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class PortuguesePluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;

    private final GenderType genderType;

    public PortuguesePluralForms(String singularForm, String pluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        return (value == 1) ? singularForm : pluralForm;
    }

    @Override
    public GenderType genderType() {
        return genderType;
    }
}
