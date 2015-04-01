package pl.allegro.utils.tradukisto.internal.languages.polish

import spock.lang.Specification
import spock.lang.Unroll

class HundredsToPolishConverterTest extends Specification {

    def conversion = new HundredsToPolishConverter()

    @Unroll
    def "should convert unit: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value | word
        0     | "zero"
        1     | "jeden"
        2     | "dwa"
        3     | "trzy"
        4     | "cztery"
        5     | "pięć"
        6     | "sześć"
        7     | "siedem"
        8     | "osiem"
        9     | "dziewięć"
    }

    @Unroll
    def "should convert a dozen or so: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value | word
        11    | "jedenaście"
        12    | "dwanaście"
        13    | "trzynaście"
        14    | "czternaście"
        15    | "piętnaście"
        16    | "szesnaście"
        17    | "siedemnaście"
        18    | "osiemnaście"
        19    | "dziewiętnaście"
    }

    @Unroll
    def "should convert tens: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value | word
        10    | "dziesięć"
        20    | "dwadzieścia"
        30    | "trzydzieści"
        40    | "czterdzieści"
        50    | "pięćdziesiąt"
        60    | "sześćdziesiąt"
        70    | "siedemdziesiąt"
        80    | "osiemdziesiąt"
        90    | "dziewięćdziesiąt"
    }

    @Unroll
    def "should convert hundreds: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value  | word
        100    | "sto"
        200    | "dwieście"
        300    | "trzysta"
        400    | "czterysta"
        500    | "pięćset"
        600    | "sześćset"
        700    | "siedemset"
        800    | "osiemset"
        900    | "dziewięćset"
    }

    @Unroll
    def "should convert two digits numbers with units: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value  | word
        21     | "dwadzieścia jeden"
        37     | "trzydzieści siedem"
        43     | "czterdzieści trzy"
        58     | "pięćdziesiąt osiem"
        69     | "sześćdziesiąt dziewięć"
        76     | "siedemdziesiąt sześć"
        82     | "osiemdziesiąt dwa"
        95     | "dziewięćdziesiąt pięć"
    }

    @Unroll
    def "should convert three digits numbers with tens and units: #value"() {
        expect:
        conversion.asWords(value) == word

        where:
        value   | word
        111     | "sto jedenaście"
        272     | "dwieście siedemdziesiąt dwa"
        387     | "trzysta osiemdziesiąt siedem"
        448     | "czterysta czterdzieści osiem"
        569     | "pięćset sześćdziesiąt dziewięć"
        625     | "sześćset dwadzieścia pięć"
        782     | "siedemset osiemdziesiąt dwa"
        895     | "osiemset dziewięćdziesiąt pięć"
        999     | "dziewięćset dziewięćdziesiąt dziewięć"
    }

    def "should convert any value in range of 0-999"() {
        when:
        conversion.asWords(value)

        then:
        notThrown(IllegalArgumentException)

        where:
        value << (0..999)
    }

    @Unroll
    def "should not support values less that 0 and greater that 999: #value"() {
        when:
        conversion.asWords(value)

        then:
        thrown(IllegalArgumentException)

        where:
        value << [-1999, -1, 1000, 1001, 1999]
    }
}
