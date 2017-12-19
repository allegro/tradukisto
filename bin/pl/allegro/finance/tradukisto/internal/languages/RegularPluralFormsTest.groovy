package pl.allegro.finance.tradukisto.internal.languages

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

class RegularPluralFormsTest extends Specification {

    def pluralForms = new RegularPluralForms("milhão", "milhões")
    def pluralFormsWithGender = new RegularPluralForms("Million", "Millionen", GenderType.NON_APPLICABLE)

    def "should provide value for singular form with gender"() {
        expect:
        pluralFormsWithGender.formFor(1) == "Million"
    }

    def "should provide value for plural forms with gender"() {
        expect:
        pluralFormsWithGender.formFor(value) == "Millionen"

        where:
        value << [0] + (2..100)
    }

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(1) == "milhão"
    }

    def "should provide value for plural forms"() {
        expect:
        pluralForms.formFor(value) == "milhões"

        where:
        value << [0] + (2..100)
    }
}
