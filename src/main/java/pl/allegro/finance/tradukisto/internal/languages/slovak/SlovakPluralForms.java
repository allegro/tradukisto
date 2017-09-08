package pl.allegro.finance.tradukisto.internal.languages.slovak;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechPluralForms;

public class SlovakPluralForms extends CzechPluralForms {

    public SlovakPluralForms(String singularForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        super(singularForm, pluralForm, genitivePluralForm, genderType);
    }

    public SlovakPluralForms() {
        super();
    }
}
