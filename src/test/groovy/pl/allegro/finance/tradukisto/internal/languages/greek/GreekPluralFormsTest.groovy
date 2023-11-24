package pl.allegro.finance.tradukisto.internal.languages.greek

import pl.allegro.finance.tradukisto.internal.languages.english.EnglishPluralForms
import spock.lang.Specification

class GreekPluralFormsTest extends Specification {

    def pluralForms = new GreekPluralForms("χιλιάδες")

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(value) == "χιλιάδες"

        where:
        value << (0..100)
    }
}
