package pl.allegro.finance.tradukisto.internal.converters

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter
import spock.lang.Specification

class BigDecimalToBankingMoneyConverterTest extends Specification {

    def integerToStringConverter = Stub(IntegerToStringConverter)
    def converter = new BigDecimalToBankingMoneyConverter(integerToStringConverter, "PLN")

    def "setup"() {
        integerToStringConverter.asWords(123) >> "sto dwadzieścia trzy"
    }

    def "should convert whole numbers"() {
        expect:
        converter.asWords(123) == "sto dwadzieścia trzy PLN 00/100"
    }

    def "should convert value with one digit after decimal point"() {
        expect:
        converter.asWords(123.4) == "sto dwadzieścia trzy PLN 40/100"
    }

    def "should throw value with two digits after decimal point"() {
        expect:
        converter.asWords(123.4) == "sto dwadzieścia trzy PLN 40/100"
    }

    def "should not support thousandths part of value"() {
        when:
        converter.asWords(1_234.567)

        then:
        thrown(IllegalArgumentException)
    }

    def "should not support values out of range of integer type"() {
        when:
        converter.asWords(outOfRangeValue)

        then:
        thrown(IllegalArgumentException)

        where:
        outOfRangeValue << [-1, new BigDecimal(Integer.MAX_VALUE) + 1, new BigDecimal(Integer.MAX_VALUE) * 2 + 10]
    }
}
