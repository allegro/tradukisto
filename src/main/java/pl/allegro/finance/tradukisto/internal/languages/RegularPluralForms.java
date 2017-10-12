package pl.allegro.finance.tradukisto.internal.languages;

public class RegularPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final GenderType genderType;

    public RegularPluralForms(String singularForm, String pluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genderType = genderType;
    }

    public RegularPluralForms(String singularForm, String pluralForm) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genderType = GenderType.NON_APPLICABLE;
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
