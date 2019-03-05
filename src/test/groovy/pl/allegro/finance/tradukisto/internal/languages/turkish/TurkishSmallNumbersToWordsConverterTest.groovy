package pl.allegro.finance.tradukisto.internal.languages.turkish

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import spock.lang.Specification

class TurkishSmallNumbersToWordsConverterTest extends Specification {

    static TurkishValues turkishValues = new TurkishValues();

    def "should convert value from list of base values"() {
        given:
        def converter = new TurkishSmallNumbersToWordsConverter(turkishValues)

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "Bir"
    }

    def "should convert two digits number"() {
        given:
        def converter = new TurkishSmallNumbersToWordsConverter(turkishValues)

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "Yirmi Bir"
    }

    def "should convert three digits number"() {
        given:
        def converter = new TurkishSmallNumbersToWordsConverter(turkishValues)

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "Altı Yüz Altmış Altı"
    }

    def "should convert four digits numbers"() {
        given:
        def converter = new TurkishSmallNumbersToWordsConverter(turkishValues)

        expect:
        converter.asWords(1254, GenderType.NON_APPLICABLE) == "Bin İki Yüz Elli Dört"
    }

    def "should convert four digits number that one thousand"() {
        given:
        def converter = new TurkishSmallNumbersToWordsConverter(turkishValues)

        expect:
        converter.asWords(1000, GenderType.NON_APPLICABLE) == "Bin"
    }

    def "should convert more that three digits number"() {
        given:
        def converter = new TurkishSmallNumbersToWordsConverter(turkishValues)

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "Altmış Altı Bin Altı Yüz Altmış Altı"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new TurkishSmallNumbersToWordsConverter(turkishValues)

        when:
        converter.asWords(1000000, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 1000000"
    }
}
