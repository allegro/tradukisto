package pl.allegro.finance.tradukisto.internal.languages.hebrew

import spock.lang.Specification
import spock.lang.Unroll

import static java.math.BigDecimal.ONE
import static pl.allegro.finance.tradukisto.MoneyConverters.HEBREW_BANKING_MONEY_VALUE

/**
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.11.0
 * @since 1.11.0
 */
class HebrewBigDecimalToBankingMoneyConverterTest extends Specification {

    static converter = HEBREW_BANKING_MONEY_VALUE;

    @Unroll
    def "should convert whole numbers monetary #value to '#words' in Hebrew"() {
        expect:
        converter.asWords(value) == words

        where:
        value   | words
        0       | "\u20aa \u05d0\u05e4\u05e1"
        1       | "\u20aa \u05d0\u05d7\u05d3"
        1234    | "\u20aa \u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4"
        1000    | "\u20aa \u05d0\u05dc\u05e3"
        10000   | "\u20aa \u05e2\u05e9\u05e8\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd"
        1.4     | "\u05d0\u05d7\u05d3 \u20aa \u05d5\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1.44    | "\u05d0\u05d7\u05d3 \u20aa \u05d5\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1.46    | "\u05d0\u05d7\u05d3 \u20aa \u05d5\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1234.56 | "\u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4 \u20aa \u05d5\u05d7\u05de\u05d9\u05e9\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
    }

    @Unroll
    def "should throw exception when value has more than two decimals"() {
        when:
        converter.asWords(new BigDecimal("1.234"))

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform more than 2 decimal places for value 1.234"
    }

    @Unroll
    def "should throw exception when value is grater than INTEGER.MAX_VALUE"() {
        when:
        converter.asWords(new BigDecimal(Integer.MAX_VALUE).add(ONE))

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform numbers greater than Integer.MAX_VALUE for value 2147483648"
    }

    @Unroll
    def "should throw exception when value is negative"() {
        when:
        converter.asWords(new BigDecimal(-1))

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform negative numbers for value -1"
    }
}
