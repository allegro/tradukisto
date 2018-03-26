package pl.allegro.finance.tradukisto.internal.languages.german

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class GermanThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new GermanThousandToWordsConverter([1: genderForm("eins")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "eins"
    }

    def "should convert two digits number"() {
        given:
        def converter = new GermanThousandToWordsConverter([20: genderForm("zwanzig"), 1: genderForm("ein")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "einundzwanzig"
    }

    def "should convert three digits number"() {
        given:
        def converter = new GermanThousandToWordsConverter([600: genderForm("sechshundert"), 60: genderForm("sechzig"), 6: genderForm("sechs")])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "sechshundertsechsundsechzig"
    }

    def "should convert more that three digits number"() {
        given:
        def converter = new GermanThousandToWordsConverter([600: genderForm("sechshundert"), 60: genderForm("sechzig"), 6: genderForm("sechs")])

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "sechsundsechzigtausendsechshundertsechsundsechzig"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new GermanThousandToWordsConverter([1: genderForm("eins")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
