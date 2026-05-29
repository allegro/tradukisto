package pl.allegro.finance.tradukisto.internal.languages.arabic;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class ArabicPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;

    public ArabicPluralForms(String form) {
        this.singularForm = form;
        this.pluralForm = form;
    }

    public ArabicPluralForms(String singularForm, String pluralForm) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
    }

    @Override
    public String formFor(Integer value) {
        return (value == 1) ? singularForm : pluralForm;
    }

    @Override
    public GenderType genderType() {
        return GenderType.NON_APPLICABLE;
    }
}
