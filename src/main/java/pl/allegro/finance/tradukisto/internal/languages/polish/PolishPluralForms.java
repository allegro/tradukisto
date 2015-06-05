package pl.allegro.finance.tradukisto.internal.languages.polish;

import com.google.common.collect.Range;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

public class PolishPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    public PolishPluralForms(String singularForm, String pluralForm, String genitivePluralForm) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;
    }

    @Override
    public String formFor(Integer value) {
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

    @Override
    public GenderType genderType() {
        return GenderType.MASCULINE;
    }
}
