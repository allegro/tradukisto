package pl.allegro.utils.tradukisto.internal.languages.polish

import spock.lang.Specification
import spock.lang.Unroll

class IntegerToPolishConverterTest extends Specification {

    def conversion = new PolishContainer().getNumbersConverter()

    @Unroll
    def "should convert single thousands: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value | word
        1_000 | "jeden tysiąc"
        2_000 | "dwa tysiące"
        3_000 | "trzy tysiące"
        4_000 | "cztery tysiące"
        5_000 | "pięć tysięcy"
        6_000 | "sześć tysięcy"
        7_000 | "siedem tysięcy"
        8_000 | "osiem tysięcy"
        9_000 | "dziewięć tysięcy"
    }

    @Unroll
    def "should convert complex thousands: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value   | word
        653_000 | "sześćset pięćdziesiąt trzy tysiące"
        123_454 | "sto dwadzieścia trzy tysiące czterysta pięćdziesiąt cztery"
        700_000 | "siedemset tysięcy"
        999_999 | "dziewięćset dziewięćdziesiąt dziewięć tysięcy dziewięćset dziewięćdziesiąt dziewięć"
    }

    @Unroll
    def "should convert hundreds: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value | word
        0     | "zero"
        4     | "cztery"
        12    | "dwanaście"
        37    | "trzydzieści siedem"
        80    | "osiemdziesiąt"
        100   | "sto"
        169   | "sto sześćdziesiąt dziewięć"
    }

    @Unroll
    def "should convert millions: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value       | word
        1_000_000   | "jeden milion"
        100_000_000 | "sto milionów"
        123_456_789 | "sto dwadzieścia trzy miliony czterysta pięćdziesiąt sześć tysięcy siedemset osiemdziesiąt " +
                "dziewięć"
    }

    def "should convert max value for integer"() {
        expect:
        conversion.asWords(Integer.MAX_VALUE) == "dwa miliardy sto czterdzieści siedem milionów czterysta " +
                "osiemdziesiąt trzy tysiące sześćset czterdzieści siedem"
    }

    def "should not support negative values"() {
        when:
        conversion.asWords(-1)

        then:
        thrown(IllegalArgumentException)
    }
}
