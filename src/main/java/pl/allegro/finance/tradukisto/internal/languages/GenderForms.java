package pl.allegro.finance.tradukisto.internal.languages;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class GenderForms {

    private final Map<GenderType, String> forms;

    public static GenderForms genderForms(String masculineForm, String feminineForm, String neuterForm) {
        return new GenderForms(masculineForm, feminineForm, neuterForm);
    }

    public static GenderForms genderForm(String nonApplicableForm) {
        return new GenderForms(nonApplicableForm);
    }

    public GenderForms(String masculineForm, String feminineForm, String neuterForm) {
        this.forms = formsForThreeBaseTypes(masculineForm, feminineForm, neuterForm).build();
    }

    public GenderForms(String nonApplicableForm) {
        this.forms = formsForThreeBaseTypes(nonApplicableForm, nonApplicableForm, nonApplicableForm)
                .put(GenderType.NON_APPLICABLE, nonApplicableForm)
                .build();
    }

    private ImmutableMap.Builder<GenderType, String> formsForThreeBaseTypes(String masculineForm,
                                                                            String feminineForm,
                                                                            String neuterForm) {
        return ImmutableMap.<GenderType, String>builder()
                .put(GenderType.MASCULINE, masculineForm)
                .put(GenderType.FEMININE, feminineForm)
                .put(GenderType.NEUTER, neuterForm);
    }

    public String formFor(GenderType gender) {
        validateGender(gender);
        return forms.get(gender);
    }

    private void validateGender(GenderType gender) {
        if (!forms.containsKey(gender)) {
            throw new MissingFormException(String.format("No form found for %s. Available forms: %s", gender, forms));
        }
    }
}
