package pl.allegro.finance.tradukisto.internal.languages.dutch

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class DutchThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new DutchThousandToWordsConverter([1: genderForm("één")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "één"
    }

    def "should convert two digits number"() {
        given:
        def converter = new DutchThousandToWordsConverter([20: genderForm("twintig"), 1: genderForm("één")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "éénentwintig"
    }

    def "should convert three digits number"() {
        given:
        def converter = new DutchThousandToWordsConverter([600: genderForm("zeshonderd"), 60: genderForm("zestig"), 6: genderForm("zes")])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "zeshonderdzesenzestig"
    }

    def "should convert more that three digits number"() {
        given:
        def converter = new DutchThousandToWordsConverter([600: genderForm("zeshonderd"), 60: genderForm("zestig"), 6: genderForm("zes")])

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "zesenzestigduizendzeshonderdzesenzestig"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new DutchThousandToWordsConverter([1: genderForm("één")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
