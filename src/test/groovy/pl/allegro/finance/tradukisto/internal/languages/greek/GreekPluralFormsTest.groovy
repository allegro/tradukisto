package pl.allegro.finance.tradukisto.internal.languages.greek

import spock.lang.Specification
import spock.lang.Unroll

class GreekPluralFormsTest extends Specification {

    def pluralForms = new GreekPluralForms("χίλια", "χιλιάδες")

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(1) == "χίλια"
    }

    @Unroll
    def "should provide value for plural form: #value"() {
        expect:
        pluralForms.formFor(value) == "χιλιάδες"

        where:
        value << (2..4)
    }
}
