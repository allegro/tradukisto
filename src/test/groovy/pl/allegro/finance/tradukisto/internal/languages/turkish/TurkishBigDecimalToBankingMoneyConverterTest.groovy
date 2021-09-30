package pl.allegro.finance.tradukisto.internal.languages.turkish


import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.Container.turkishContainer

class TurkishBigDecimalToBankingMoneyConverterTest extends Specification {

    static converter = turkishContainer().getBankingMoneyConverter()

    def "should convert whole numbers"() {
        expect:
        converter.asWords(123) == "YüzYirmiÜçTL"
    }

    def "should convert value with one digit after decimal point"() {
        expect:
        converter.asWords(123.4) == "YüzYirmiÜçTL,KırkKr."
    }

    def "should not support thousands part of value"() {
        when:
        converter.asWords(1_234.567)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform more than 2 decimal places for value 1234.567"
    }

    def "should not support negative values"() {
        when:
        converter.asWords(-1)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform negative numbers for value -1"

    }

    def "should not support values out of range of integer type"() {
        when:
        converter.asWords(outOfRangeValue)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform numbers greater than Integer.MAX_VALUE for value " + outOfRangeValue

        where:
        outOfRangeValue << [new BigDecimal(Integer.MAX_VALUE) + 1, new BigDecimal(Integer.MAX_VALUE) * 2 + 10]
    }
}
