package pl.allegro.finance.tradukisto.internal.languages.latvian;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class LatvianPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;

    private final GenderType genderType;

    LatvianPluralForms(String singularForm, String pluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        if (useSingular(value)) {
            return singularForm;
        } else {
            return pluralForm;
        }
    }

    private boolean useSingular(Integer value) {
        return value == 1 || (value % 100 != 11 && value % 10 == 1);
    }


    @Override
    public GenderType genderType() {
        return genderType;
    }
}
