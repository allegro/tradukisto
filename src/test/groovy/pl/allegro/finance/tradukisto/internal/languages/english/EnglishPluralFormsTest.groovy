package pl.allegro.finance.tradukisto.internal.languages.english
import spock.lang.Specification

class EnglishPluralFormsTest extends Specification {

    def pluralForms = new EnglishPluralForms("thousand")

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(value) == "thousand"

        where:
        value << (0..100)
    }
}
