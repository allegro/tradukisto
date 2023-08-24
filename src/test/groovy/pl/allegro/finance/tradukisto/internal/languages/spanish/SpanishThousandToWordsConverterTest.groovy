package pl.allegro.finance.tradukisto.internal.languages.spanish

import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class SpanishThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new SpanishThousandToWordsConverter([1: genderForm("uno")], [:])

        expect:
        converter.asWords(1) == "uno"
    }

    def "should convert two digits number"() {
        given:
        def converter = new SpanishThousandToWordsConverter([30: genderForm("treinta"), 1: genderForm("uno")], [:])

        expect:
        converter.asWords(31) == "treinta y uno"
    }

    def "should convert three digits number"() {
        given:
        def converter = new SpanishThousandToWordsConverter([600: genderForm("seiscientos"), 60: genderForm("sesenta"), 6: genderForm("seis")], [:])

        expect:
        converter.asWords(666) == "seiscientos sesenta y seis"
    }

    def "should convert more that three digits number"() {
        given:
        def converter = new SpanishThousandToWordsConverter([600: genderForm("seiscientos"), 60: genderForm("sesenta"), 6: genderForm("seis")], [:])

        expect:
        converter.asWords(66666) == "sesenta y seis mil seiscientos sesenta y seis"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new SpanishThousandToWordsConverter([1: genderForm("uno")], [:])

        when:
        converter.asWords(2)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
