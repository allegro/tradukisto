package pl.allegro.finance.tradukisto.internal.languages

import spock.lang.Specification

class GenderFormsTest extends Specification {

    def "should handle non applicable form"() {
        given:
        def genderForms = new GenderForms("non-applicable-form")

        expect:
        genderForms.formFor(form) == "non-applicable-form"

        where:
        form << GenderType.values()
    }

    def "should handle different forms"() {
        given:
        def genderForms = new GenderForms("masculine-form", "feminine-form", "neuter-form")

        expect:
        genderForms.formFor(GenderType.MASCULINE) == "masculine-form"
        genderForms.formFor(GenderType.FEMININE) == "feminine-form"
        genderForms.formFor(GenderType.NEUTER) == "neuter-form"
    }


    def "should not handle non applicable where this form is not given"() {
        given:
        def genderForms = new GenderForms("masculine-form", "feminine-form", "neuter-form")

        when:
        genderForms.formFor(GenderType.NON_APPLICABLE)

        then:
        thrown(MissingFormException)
    }
}
