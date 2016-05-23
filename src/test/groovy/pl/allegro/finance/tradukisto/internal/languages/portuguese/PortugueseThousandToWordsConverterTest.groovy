package pl.allegro.finance.tradukisto.internal.languages.portuguese

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class PortugueseThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new PortugueseThousandToWordsConverter([1: genderForm("um")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "um"
    }

    def "should convert two digits number"() {
        given:
        def converter = new PortugueseThousandToWordsConverter([20: genderForm("vinte"), 1: genderForm("um")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "vinte e um"
    }

    def "should convert three digits number"() {
        given:
        def converter = new PortugueseThousandToWordsConverter([600: genderForm("seiscentos"), 60: genderForm("sessenta"), 6: genderForm("seis")])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "seiscentos e sessenta e seis"
    }

    def "should convert more that three digits number"() {
        given:
        def converter = new PortugueseThousandToWordsConverter([600: genderForm("seiscentos"), 60: genderForm("sessenta"), 6: genderForm("seis")])

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "sessenta e seis mil seiscentos e sessenta e seis"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new PortugueseThousandToWordsConverter([1: genderForm("um")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
