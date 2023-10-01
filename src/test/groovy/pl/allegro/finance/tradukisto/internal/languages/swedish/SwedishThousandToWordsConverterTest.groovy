package pl.allegro.finance.tradukisto.internal.languages.swedish;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import spock.lang.Specification;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm;
import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;

class SwedishThousandToWordsConverterTest extends Specification {

    def "should convert a single value from the list of base values"() {
        given:
        def converter = new SwedishThousandToWordsConverter([1: genderForms("en",
                "en",
                "ett",
                "ett")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "ett"
    }

    def "should convert a two digit number from the list of base values"() {
        given:
        def converter = new SwedishThousandToWordsConverter([20: genderForm("tjugo"),
                                                             1: genderForms("en",
                                                                     "en",
                                                                     "ett",
                                                                     "ett")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "tjugoett"
    }

    def "should convert a three digit number from the list of base values"() {
        given:
        def converter = new SwedishThousandToWordsConverter([900: genderForm("nio hundra"),
                                                             90: genderForm("nittio"),
                                                             9: genderForm("nio")])

        expect:
        converter.asWords(999, GenderType.NON_APPLICABLE) == "nio hundra och nittionio"
    }

    def "should convert a four digit number from the list of base values"() {
        given:
        def converter = new SwedishThousandToWordsConverter([600: genderForm("sex hundra"),
                                                             3: genderForm("tre"),
                                                             2: genderForm("två")])

        expect:
        converter.asWords(3602, GenderType.NON_APPLICABLE) == "tre tusen sex hundra och två"
    }

    def "should convert a five digit number from the list of base values"() {
        given:
        def converter = new SwedishThousandToWordsConverter([400: genderForm("fyra hundra"),
                                                             88: genderForm("åttioåtta"),
                                                             80: genderForm("åttio"),
                                                             7: genderForm("sju")])

        expect:
        converter.asWords(88487, GenderType.NON_APPLICABLE) == "åttioåtta tusen fyra hundra och åttiosju"
    }

    def "should convert a six digit number from the list of base values"() {
        given:
        def converter = new SwedishThousandToWordsConverter([900: genderForm("nio hundra"),
                                                             200: genderForm("två hundra"),
                                                             13: genderForm("tretton"),
                                                             5: genderForm("fem")])

        expect:
        converter.asWords(905213, GenderType.NON_APPLICABLE) == "nio hundra och fem tusen två hundra och tretton"
    }


    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new SwedishThousandToWordsConverter([1: genderForm("ett")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
