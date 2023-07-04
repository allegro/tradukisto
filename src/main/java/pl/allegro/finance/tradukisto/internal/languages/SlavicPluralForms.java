package pl.allegro.finance.tradukisto.internal.languages;

import pl.allegro.finance.tradukisto.internal.support.Range;

public class SlavicPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    private final GenderType genderType;

    public SlavicPluralForms(String singularForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;

        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        if (useSingular(value)) {
            return singularForm;
        }
        if (usePluralForm(value)) {
            return pluralForm;
        }
        return genitivePluralForm;
    }

    private boolean useSingular(Integer value) {
        return value == 1 || (value % 100 != 11 && value % 10 == 1);
    }

    private boolean usePluralForm(Integer value) {
        return Range.closed(2, 4).contains(value % 10)
                && !Range.closed(12, 14).contains(value % 100);
    }

    @Override
    public GenderType genderType() {
        return genderType;
    }
}
