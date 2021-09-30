package pl.allegro.finance.tradukisto.internal.languages.turkish

import spock.lang.Specification

class TurkishPluralFormsTest extends Specification {

    def pluralForms = new TurkishPluralForms("Bin")

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(value) == "Bin"

        where:
        value << (0..100)
    }
}
