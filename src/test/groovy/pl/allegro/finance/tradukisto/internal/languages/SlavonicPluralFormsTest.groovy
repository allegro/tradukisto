package pl.allegro.finance.tradukisto.internal.languages

import spock.lang.Specification
import spock.lang.Unroll

class SlavonicPluralFormsTest extends Specification {

    def pluralForms = new SlavonicPluralForms("tysiąc", "tysiące", "tysięcy", GenderType.NON_APPLICABLE)

    def "should provide value for singular form"() {
        expect:
        pluralForms.formFor(1) == "tysiąc"
    }

    @Unroll
    def "should provide value for plural form: #value"() {
        expect:
        pluralForms.formFor(value) == "tysiące"

        where:
        value << (2..4) + (22..24) + (32..34) + (172..174) + (1732..1734)
    }

    @Unroll
    def "should provide value for genitive plural form: #value"() {
        expect:
        pluralForms.formFor(value) == "tysięcy"

        where:
        value << [0] + (5..21) + (25..31) + (175..181) + (1735..1741)
    }
}
