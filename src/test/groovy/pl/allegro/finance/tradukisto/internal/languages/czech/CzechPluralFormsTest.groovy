package pl.allegro.finance.tradukisto.internal.languages.czech

import spock.lang.Specification
import spock.lang.Unroll

class CzechPluralFormsTest extends Specification {

    def pluralForms = new CzechPluralForms("milion", "miliony", "milionů")

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(1) == "milion"
    }

    @Unroll
    def "should provide value for plural form: #value"() {
        expect:
        pluralForms.formFor(value) == "miliony"

        where:
        value << (2..4)
    }

    @Unroll
    def "should provide value for genitive plural form: #value"() {
        expect:
        pluralForms.formFor(value) == "milionů"

        where:
        value << [0] + (5..100) + (1735..1741)
    }
}
