package pl.allegro.finance.tradukisto.internal.support;

import com.google.common.collect.Range;

public class PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    public PluralForms(String singularForm, String pluralForm, String genitivePluralForm) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;
    }

    public String getFor(Integer value) {
        if (value == 1) {
            return singularForm;
        } else if (usePluralForm(value)) {
            return pluralForm;
        }
        return genitivePluralForm;
    }

    private boolean usePluralForm(Integer value) {
        return Range.closed(2, 4).contains(value % 10) && !Range.closed(12, 14).contains(value % 100);
    }
}
