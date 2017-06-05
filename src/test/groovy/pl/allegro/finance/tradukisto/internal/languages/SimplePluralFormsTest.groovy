package pl.allegro.finance.tradukisto.internal.languages

import spock.lang.Specification

class SimplePluralFormsTest extends Specification {

    def pluralForms = new SimplePluralForms("thousand")

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(value) == "thousand"

        where:
        value << (0..100)
    }
}
