package pl.allegro.finance.tradukisto.internal.languages;

public class SimplePluralForms implements PluralForms {

    private final String form;

    public SimplePluralForms(String form) {
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
