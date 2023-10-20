package pl.allegro.finance.tradukisto.internal.languages

import pl.allegro.finance.tradukisto.internal.Container
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter
import pl.allegro.finance.tradukisto.internal.LongToStringConverter
import spock.lang.Specification
import spock.lang.Unroll

abstract class AbstractValuesTest extends Specification {

    abstract ValuesTestInput input

    @Unroll
    def "should convert #value to '#words'"() {
        expect:
        getInput().getIntConverter().asWords(value) == words

        where:
        value << intNumbers
        words << getInput().intWords
    }

    @Unroll
    def "should convert long #value to '#words'"() {
        expect:
        getInput().getLongConverter().asWords(value) == words

        where:
        value << longNumbers
        words << getInput().longWords
    }

    private static intNumbers = [
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            11, 12, 13, 14, 15, 16, 17, 18, 19,
            10, 20, 30, 40, 50, 60, 70, 80, 90,
            21, 37, 43, 58, 69, 76, 82, 95,
            100, 200, 300, 400, 500, 600, 700, 800, 900,
            111, 272, 387, 448, 569, 625, 782, 895, 999,
            1_000, 2_000, 3_000, 4_000, 5_000, 7_634, 11_000,
            15_000, 21_000, 24_190, 653_000, 123_454, 700_000, 999_999,
            1_000_000, 2_000_000, 5_000_000, 23_437_219,
            100_000_000, 123_456_789, 322_089_890,
            1_000_000_000, 2_147_483_647,
    ]

    private static longNumbers = [
            5_000_000_000,
            1_000_000_000_000,
            2_000_000_000_000,
            5_000_000_000_000,
            1_000_000_000_000_000,
            2_000_000_000_000_000,
            5_000_000_000_000_000,
            1_000_000_000_000_000_000,
            2_000_000_000_000_000_000,
            Long.MAX_VALUE
    ]

    static class ValuesTestInput {
        IntegerToStringConverter intConverter
        LongToStringConverter longConverter
        Collection<String> intWords
        Collection<String> longWords

        ValuesTestInput(Container container, Collection<String> intWords, Collection<String> longWords) {
            this.intConverter = container.getIntegerConverter()
            this.longConverter = container.getLongConverter()
            this.intWords = intWords
            this.longWords = longWords
        }
    }
}
