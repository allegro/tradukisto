package pl.allegro.finance.tradukisto.internal.languages.swedish;

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm
import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms

class SwedishHundredToWordsConverterTest extends Specification {

    def "should convert a single value from the list of base values"() {
        given:
        def converter = new SwedishHundredToWordsConverter([1: genderForms("en",
                "en",
                "ett",
                "ett")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "ett"
    }

    def "should convert a two digit number from the list of base values"() {
        given:
        def converter = new SwedishHundredToWordsConverter([20: genderForm("tjugo"),
                                                            1 : genderForms("en",
                                                                     "en",
                                                                     "ett",
                                                                     "ett")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "tjugoett"
    }

    def "should convert a three digit number from the list of base values"() {
        given:
        def converter = new SwedishHundredToWordsConverter([900: genderForm("nio hundra"),
                                                            90 : genderForm("nittio"),
                                                            9  : genderForm("nio")])

        expect:
        converter.asWords(999, GenderType.NON_APPLICABLE) == "nio hundra och nittionio"
    }


    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new SwedishHundredToWordsConverter([1: genderForm("ett")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
