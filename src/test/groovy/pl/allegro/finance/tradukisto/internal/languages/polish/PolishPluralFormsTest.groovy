package pl.allegro.finance.tradukisto.internal.languages.polish

import spock.lang.Specification
import spock.lang.Unroll

class PolishPluralFormsTest extends Specification {

    def pluralForms = new PolishPluralForms("tysiąc", "tysiące", "tysięcy")

    def "should provide value for singular form"() {
        expect:
        pluralForms.getFor(1) == "tysiąc"
    }

    @Unroll
    def "should provide value for plural form: #value"() {
        expect:
        pluralForms.getFor(value) == "tysiące"

        where:
        value << (2..4) + (22..24) + (32..34) + (172..174) + (1732..1734)
    }

    @Unroll
    def "should provide value for genitive plural form: #value"() {
        expect:
        pluralForms.getFor(value) == "tysięcy"

        where:
        value << [0] + (5..21) + (25..31) + (175..181) + (1735..1741)
    }
}
