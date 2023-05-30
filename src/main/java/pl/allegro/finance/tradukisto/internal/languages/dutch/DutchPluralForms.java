package pl.allegro.finance.tradukisto.internal.languages.dutch;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

/**
 * @author Dilaver Demirel
 */
public class DutchPluralForms implements PluralForms {

    private final String form;

    public DutchPluralForms(String form) {
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
