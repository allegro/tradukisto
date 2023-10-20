package pl.allegro.finance.tradukisto.internal.languages

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter
import pl.allegro.finance.tradukisto.internal.LongToStringConverter
import spock.lang.Specification
import spock.lang.Unroll

abstract class AbstractValuesTest extends Specification {
    abstract ValuesTestData testData
    abstract IntegerToStringConverter intConverter
    abstract LongToStringConverter longConverter

    @Unroll
    def "should convert integer #input to #output"() {
        expect:
        intConverter.asWords(input) == output

        where:
        input << getTestData().getIntWords().keySet()
        output << getTestData().getIntWords().values()
    }

    @Unroll
    def "should convert long #input to #output"() {
        expect:
        longConverter.asWords(input) == output

        where:
        input << getTestData().getLongWords().keySet()
        output << getTestData().getLongWords().values()
    }

    private static requiredIntNumbers = [
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

    private static requiredLongNumbers = [
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

    static class ValuesTestData {
        HashMap<Integer, String> intWords
        HashMap<Long, String> longWords

        ValuesTestData(HashMap<Integer, String> intWords, HashMap<Long, String> longWords) {
            this.intWords = prepareIntegerInput(intWords) // fulfills dataset with required data if was not specified, allows adding new entries
            this.longWords = prepareLongInput(longWords)
        }

        private static prepareIntegerInput(HashMap<String, String> intWords) {
            requiredIntNumbers.stream()
                  .forEach {
                      intWords.putIfAbsent(it, "⚠️Please specify expected output")  // todo: how to handle if someone removes required input? throw exception or push fake data as here?
                  }
            return intWords.sort{ it.key }
        }

        private static prepareLongInput(HashMap<String, String> longWords) {
            requiredLongNumbers.stream()
                    .forEach {
                        longWords.putIfAbsent(it, "⚠️Please specify expected output")  // todo: how to handle if someone removes required input? throw exception or push fake data as here?
                    }
            return longWords.sort{ it.key }
        }
    }
}
