package pl.allegro.finance.tradukisto.internal.converters

import spock.lang.Specification

class HundredsToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new HundredsToWordsConverter([1: "jeden"])

        expect:
        converter.asWords(1) == "jeden"
    }

    def "should convert two digits number"() {
        given:
        def converter = new HundredsToWordsConverter([20: "dwadzieścia", 1: "jeden"])

        expect:
        converter.asWords(21) == "dwadzieścia jeden"
    }

    def "should convert three digits number"() {
        given:
        def converter = new HundredsToWordsConverter([600: "sześćset", 60: "sześćdziesiąt", 6: "sześć"])

        expect:
        converter.asWords(666) =="sześćset sześćdziesiąt sześć"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new HundredsToWordsConverter([1: "jeden"])

        when:
        converter.asWords(2)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
