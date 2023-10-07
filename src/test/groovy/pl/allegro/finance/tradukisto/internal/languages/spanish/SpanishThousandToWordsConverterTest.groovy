package pl.allegro.finance.tradukisto.internal.languages.spanish

import pl.allegro.finance.tradukisto.internal.MultiFormNumber
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

    def "should return correct words for other thousands with no following number"() {
        given:
        def converter = new SpanishThousandToWordsConverter([3: genderForm("tres")], [:])

        expect:
        converter.asWords(3000) == "tres mil"
    }

    def "should return correct words for other thousands with following hundred"() {
        given:
        def converter = new SpanishThousandToWordsConverter([3: genderForm("tres")], [100: new MultiFormNumber("cien", "ciento")])

        expect:
        converter.asWords(3100) == "tres mil cien"
    }

    def "should return correct words for thousands with other values than hundred"() {
        given:
        def converter = new SpanishThousandToWordsConverter([5: genderForm("cinco"), 50: genderForm("cincuenta")], [:])

        expect:
        converter.asWords(5050) == "cinco mil cincuenta"
    }

    def "should return correct words for thousands with other values than hundred and no following number"() {
        given:
        def converter = new SpanishThousandToWordsConverter([5: genderForm("cinco"), 50: genderForm("cincuenta")], [:])

        expect:
        converter.asWords(5000) == "cinco mil"
    }

    def "should return correct words for 21 with no following number"() {
        given:
        def converter = new SpanishThousandToWordsConverter([21: genderForm("veintiún"), 20: genderForm("veinte")], [:])

        expect:
        converter.asWords(21000) == "veintiún mil"

    }

    def "should return correct words for 21 with following hundred"() {
        given:
        def converter = new SpanishThousandToWordsConverter([21: genderForm("veintiún"), 20: genderForm("veinte")], [100: new MultiFormNumber("cien", "ciento")])

        expect:
        converter.asWords(21100) == "veintiún mil cien"
    }

    def "should return correct words for other cases with no following number"() {
        given:
        def converter = new SpanishThousandToWordsConverter([30: genderForm("treinta"), 1: genderForm("un")], [:])

        expect:
        converter.asWords(31000) == "treinta y un mil"
    }

    def "should return correct words for other cases with following hundred"() {
        given:
        def converter = new SpanishThousandToWordsConverter([30: genderForm("treinta"), 1: genderForm("un")], [100: new MultiFormNumber("cien", "ciento")])

        expect:
        converter.asWords(31100) == "treinta y un mil cien"
    }
}
