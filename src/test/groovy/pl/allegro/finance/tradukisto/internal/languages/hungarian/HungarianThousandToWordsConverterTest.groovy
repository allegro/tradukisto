package pl.allegro.finance.tradukisto.internal.languages.hungarian

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class HungarianThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new HungarianThousandToWordsConverter([1: genderForm("egy")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "egy"
    }

    def "should convert two digits number"() {
        given:
        def converter = new HungarianThousandToWordsConverter([20: genderForm("húsz"), 1: genderForm("egy")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "huszonegy"
    }

    def "should convert three digits number"() {
        given:
        def converter = new HungarianThousandToWordsConverter([
                600: genderForm("hatszáz"),
                60 : genderForm("hatvan"),
                6  : genderForm("hat")
        ])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "hatszázhatvanhat"
    }

    def "should convert more than three digits number"() {
        given:
        def converter = new HungarianThousandToWordsConverter([
                600: genderForm("hatszáz"),
                60 : genderForm("hatvan"),
                6  : genderForm("hat")
        ])

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "hatvanhatezerhatszázhatvanhat"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new HungarianThousandToWordsConverter([1: genderForm("egy")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
