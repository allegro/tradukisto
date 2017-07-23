package pl.allegro.finance.tradukisto.internal.languages.portuguese

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

class PortuguesePluralFormsTest extends Specification {

    def pluralForms = new PortuguesePluralForms("milhão", "milhões")

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
