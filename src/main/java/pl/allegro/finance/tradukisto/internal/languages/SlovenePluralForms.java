package pl.allegro.finance.tradukisto.internal.languages;

import pl.allegro.finance.tradukisto.internal.support.Range;

public class SlovenePluralForms implements PluralForms {
    private final String singularForm;
    private final String dualForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    private final GenderType genderType;

    public SlovenePluralForms(String singularForm, String dualForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.dualForm = dualForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;
        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        if (useSingular(value)) {
            return singularForm;
        }
        if (useDual(value)) {
            return dualForm;
        }
        if (usePluralForm(value)) {
            return pluralForm;
        }
        return genitivePluralForm;
    }

    private boolean useSingular(Integer value) {
        return value == 1 || value % 100 == 1;
    }

    private boolean useDual(Integer value) {
        return value == 2 || value % 100 == 2;
    }

    private boolean usePluralForm(Integer value) {
        return Range.closed(3, 4).contains(value % 100);
    }

    @Override
    public GenderType genderType() {
        return genderType;
    }
}
