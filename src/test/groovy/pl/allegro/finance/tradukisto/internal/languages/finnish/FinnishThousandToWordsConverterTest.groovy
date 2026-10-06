package pl.allegro.finance.tradukisto.internal.languages.finnish

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class FinnishThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new FinnishThousandToWordsConverter([1: genderForm("yksi")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "yksi"
    }

    def "should convert two digits number"() {
        given:
        def converter = new FinnishThousandToWordsConverter([20: genderForm("kaksikymmentä"), 1: genderForm("yksi")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "kaksikymmentäyksi"
    }

    def "should convert three digits number"() {
        given:
        def converter = new FinnishThousandToWordsConverter([
                600: genderForm("kuusisataa"),
                60 : genderForm("kuusikymmentä"),
                6  : genderForm("kuusi")
        ])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "kuusisataakuusikymmentäkuusi"
    }

    def "should convert more than three digits number"() {
        given:
        def converter = new FinnishThousandToWordsConverter([
                600: genderForm("kuusisataa"),
                60 : genderForm("kuusikymmentä"),
                6  : genderForm("kuusi")
        ])

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "kuusikymmentäkuusituhatta kuusisataakuusikymmentäkuusi"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new FinnishThousandToWordsConverter([1: genderForm("yksi")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
