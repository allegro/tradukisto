package pl.allegro.finance.tradukisto.internal.languages.persian;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

/**
 * @author omidp
 *
 */
public class PersianPluralForms implements PluralForms
{

    private final String form;

    public PersianPluralForms(String form) {
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
