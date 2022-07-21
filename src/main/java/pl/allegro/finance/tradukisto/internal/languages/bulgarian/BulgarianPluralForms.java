package pl.allegro.finance.tradukisto.internal.languages.bulgarian;

import com.google.common.collect.Range;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.SlavonicPluralForms;

public class BulgarianPluralForms extends SlavonicPluralForms {

    private final String singularForm;

    public BulgarianPluralForms(String singularForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        super(singularForm, pluralForm, genitivePluralForm, genderType);
        this.singularForm = singularForm;
    }

    @Override
    public String formFor(Integer value) {
        if (useSingular(value)) {
            return singularForm;
        } else {
            return super.formFor(value);
        }
    }

    private boolean useSingular(Integer value) {
        return value == 1 || (value % 100 != 11 && value % 10 == 1);
    }}
