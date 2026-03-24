package pl.allegro.finance.tradukisto.internal.languages.uzbek

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.uzbekContainer

class UzbekLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = uzbekContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000            : "besh milliard",

            1_000_000_000_000        : "bir trillion",
            2_000_000_000_000        : "ikki trillion",
            5_000_000_000_000        : "besh trillion",

            1_000_000_000_000_000    : "bir kvadrillion",
            2_000_000_000_000_000    : "ikki kvadrillion",
            5_000_000_000_000_000    : "besh kvadrillion",

            1_000_000_000_000_000_000: "bir kvintillion",
            2_000_000_000_000_000_000: "ikki kvintillion",
            (Long.MAX_VALUE)         : "to'qqiz kvintillion ikki yuz yigirma uch kvadrillion " +
                    "uch yuz yetmish ikki trillion o'ttiz olti milliard " +
                    "sakkiz yuz ellik to'rt million yetti yuz yetmish besh ming " +
                    "sakkiz yuz yetti"
    ]
}
