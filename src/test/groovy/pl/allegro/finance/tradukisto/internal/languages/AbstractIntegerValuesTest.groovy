package pl.allegro.finance.tradukisto.internal.languages

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter
import spock.lang.Specification
import spock.lang.Unroll

abstract class AbstractIntegerValuesTest extends Specification {
    abstract IntegerValuesTestData testData
    abstract IntegerToStringConverter intConverter

    private static final OBLIGATORY_INT_VALUES = [
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

    @Unroll
    def "should convert integer #input to #output"() {
        expect:
        intConverter.asWords(input) == output

        where:
        input << getTestData().getIntegerTranslations().keySet()
        output << getTestData().getIntegerTranslations().values()
    }

    static class IntegerValuesTestData {
        private final Map<Integer, String> integerTranslations

        IntegerValuesTestData(Map<Integer, String> integerTranslations) {
            this.integerTranslations = prepareIntegerInput(integerTranslations)
        }

        Map<Integer, String> getIntegerTranslations() {
            return integerTranslations
        }

        private static prepareIntegerInput(Map<Integer, String> intWords) {
            OBLIGATORY_INT_VALUES.stream()
                    .forEach {
                        intWords.putIfAbsent(it, "⚠️Please specify expected output")
                    }
            return intWords.sort { it.key }
        }
    }
}
