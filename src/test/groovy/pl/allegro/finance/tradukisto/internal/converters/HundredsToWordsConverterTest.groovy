package pl.allegro.finance.tradukisto.internal.converters

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class HundredsToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new HundredsToWordsConverter([1: genderForm("jeden")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "jeden"
    }

    def "should convert two digits number"() {
        given:
        def converter = new HundredsToWordsConverter([20: genderForm("dwadzieścia"), 1: genderForm("jeden")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "dwadzieścia jeden"
    }

    def "should convert three digits number"() {
        given:
        def converter = new HundredsToWordsConverter([600: genderForm("sześćset"), 60: genderForm("sześćdziesiąt"), 6: genderForm("sześć")])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) =="sześćset sześćdziesiąt sześć"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new HundredsToWordsConverter([1: genderForm("jeden")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
