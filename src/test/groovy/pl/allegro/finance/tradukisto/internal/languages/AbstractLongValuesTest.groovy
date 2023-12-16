package pl.allegro.finance.tradukisto.internal.languages

import pl.allegro.finance.tradukisto.internal.LongToStringConverter
import spock.lang.Specification
import spock.lang.Unroll

abstract class AbstractLongValuesTest extends Specification {
    abstract LongValuesTestData testData
    abstract LongToStringConverter longConverter

    private static final OBLIGATORY_LONG_VALUES = [
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

    @Unroll
    def "should convert long #input to #output"() {
        expect:
        longConverter.asWords(input) == output

        where:
        input << getTestData().getLongTranslations().keySet()
        output << getTestData().getLongTranslations().values()
    }

    static class LongValuesTestData {
        private final Map<Long, String> longTranslations

        LongValuesTestData(Map<Long, String> longTranslations) {
            this.longTranslations = prepareLongInput(longTranslations)
        }

        Map<Long, String> getLongTranslations() {
            return longTranslations
        }

        private static prepareLongInput(Map<Long, String> longWords) {
            OBLIGATORY_LONG_VALUES.stream()
                    .forEach {
                        longWords.putIfAbsent(it, "⚠️Please specify expected output")
                    }
            return longWords.sort { it.key }
        }
    }
}
