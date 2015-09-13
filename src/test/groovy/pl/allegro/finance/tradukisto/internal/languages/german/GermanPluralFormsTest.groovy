package pl.allegro.finance.tradukisto.internal.languages.german

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

class GermanPluralFormsTest extends Specification {

    def pluralForms = new GermanPluralForms("Million", "Millionen", GenderType.NON_APPLICABLE)

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(1) == "Million"
    }

    def "should provide value for plural forms"() {
        expect:
        pluralForms.formFor(value) == "Millionen"

        where:
        value << [0] + (2..100)
    }
}
