package pl.allegro.finance.tradukisto.internal.converters
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter
import spock.lang.Specification

class BigDecimalToBankingMoneyConverterTest extends Specification {

    def integerToStringConverter = Stub(IntegerToStringConverter)
    def converter = new BigDecimalToBankingMoneyConverter(integerToStringConverter, "£")

    def "setup"() {
        integerToStringConverter.asWords(123) >> "one hundred twenty-three"
    }

    def "should convert whole numbers"() {
        expect:
        converter.asWords(123) == "one hundred twenty-three £ 00/100"
    }

    def "should convert value with one digit after decimal point"() {
        expect:
        converter.asWords(123.4) == "one hundred twenty-three £ 40/100"
    }

    def "should convert value with two digits after decimal point"() {
        expect:
        converter.asWords(123.4) == "one hundred twenty-three £ 40/100"
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
