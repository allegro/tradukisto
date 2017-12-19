package pl.allegro.finance.tradukisto.internal.converters

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class HundredsToWordsConverterTest extends Specification {

    char separator = '-'

    def "should convert value from list of base values"() {
        given:
        def converter = new HundredsToWordsConverter([1: genderForm("one")], separator)

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "one"
    }

    def "should convert two digits number"() {
        given:
        def converter = new HundredsToWordsConverter([20: genderForm("twenty"), 1: genderForm("one")], separator)

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "twenty-one"
    }

    def "should convert three digits number"() {
        given:
        def converter = new HundredsToWordsConverter([600: genderForm("six hundred"), 60: genderForm("sixty"), 6: genderForm("six")], separator)

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) =="six hundred sixty-six"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new HundredsToWordsConverter([1: genderForm("one")], separator)

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
