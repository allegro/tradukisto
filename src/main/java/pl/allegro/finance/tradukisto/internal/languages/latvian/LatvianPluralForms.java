package pl.allegro.finance.tradukisto.internal.languages.latvian;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class LatvianPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;

    private final GenderType genderType;

    public LatvianPluralForms(String singularForm, String pluralForm) {
        this(singularForm, pluralForm, GenderType.NON_APPLICABLE);
    }

    public LatvianPluralForms(String singularForm, String pluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        if (value == 1) {
            return singularForm;
        } else {
            return pluralForm;
        }
    }


    @Override
    public GenderType genderType() {
        return genderType;
    }
}
