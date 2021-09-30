package pl.allegro.finance.tradukisto.internal.languages.italian

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class ItalianThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new ItalianThousandToWordsConverter([1: genderForm("uno")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "uno"
    }

    def "should convert three digits number"() {
        given:
        def converter = new ItalianThousandToWordsConverter([600: genderForm("seicento"), 60: genderForm("sessanta"), 6: genderForm("sei")])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "seicentosessantasei"
    }

    def "should convert more that three digits number"() {
        given:
        def converter = new ItalianThousandToWordsConverter([600: genderForm("seicento"), 60: genderForm("sessanta"), 6: genderForm("sei")])

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "sessantaseimilaseicentosessantasei"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new ItalianThousandToWordsConverter([1: genderForm("uno")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Cannot convert 2"
    }
}
