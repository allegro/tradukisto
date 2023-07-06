package pl.allegro.finance.tradukisto.internal.languages;

import java.util.Map;

import static java.lang.String.format;
import static pl.allegro.finance.tradukisto.internal.support.MapSupport.unmodifiableEntry;
import static pl.allegro.finance.tradukisto.internal.support.MapSupport.unmodifiableMapOf;

public class GenderForms {

    private final Map<GenderType, String> forms;

    public static GenderForms genderForms(String masculineForm, String feminineForm, String neuterForm) {
        return new GenderForms(masculineForm, feminineForm, neuterForm);
    }

    public static GenderForms genderForms(String masculineForm, String feminineForm, String neuterForm, String nonApplicableForm) {
        return new GenderForms(masculineForm, feminineForm, neuterForm, nonApplicableForm);
    }

    public static GenderForms genderForm(String nonApplicableForm) {
        return new GenderForms(nonApplicableForm);
    }

    public GenderForms(String masculineForm, String feminineForm, String neuterForm) {
        this.forms = unmodifiableMapOf(
                unmodifiableEntry(GenderType.MASCULINE, masculineForm),
                unmodifiableEntry(GenderType.FEMININE, feminineForm),
                unmodifiableEntry(GenderType.NEUTER, neuterForm)
        );
    }

    public GenderForms(String masculineForm, String feminineForm, String neuterForm, String nonApplicableForm) {
        this.forms = unmodifiableMapOf(
                unmodifiableEntry(GenderType.MASCULINE, masculineForm),
                unmodifiableEntry(GenderType.FEMININE, feminineForm),
                unmodifiableEntry(GenderType.NEUTER, neuterForm),
                unmodifiableEntry(GenderType.NON_APPLICABLE, nonApplicableForm)
        );
    }

    public GenderForms(String nonApplicableForm) {
        this.forms = unmodifiableMapOf(
                unmodifiableEntry(GenderType.MASCULINE, nonApplicableForm),
                unmodifiableEntry(GenderType.FEMININE, nonApplicableForm),
                unmodifiableEntry(GenderType.NEUTER, nonApplicableForm),
                unmodifiableEntry(GenderType.NON_APPLICABLE, nonApplicableForm)
        );
    }

    public String formFor(GenderType gender) {
        validate(gender);
        return forms.get(gender);
    }

    private void validate(GenderType gender) {
        if (!forms.containsKey(gender)) {
            throw new MissingFormException(format("No form found for %s. Available forms: %s", gender, forms));
        }
    }
}
