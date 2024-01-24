package pl.allegro.finance.tradukisto.internal.languages.polish

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.polishContainer

class PolishLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = polishContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000            : "pięć miliardów",

            1_000_000_000_000        : "jeden bilion",
            2_000_000_000_000        : "dwa biliony",
            5_000_000_000_000        : "pięć bilionów",

            1_000_000_000_000_000    : "jeden biliard",
            2_000_000_000_000_000    : "dwa biliardy",
            5_000_000_000_000_000    : "pięć biliardów",

            1_000_000_000_000_000_000: "jeden trylion",
            2_000_000_000_000_000_000: "dwa tryliony",
            (Long.MAX_VALUE)         : "dziewięć trylionów dwieście dwadzieścia trzy biliardy " +
                    "trzysta siedemdziesiąt dwa biliony trzydzieści sześć miliardów " +
                    "osiemset pięćdziesiąt cztery miliony siedemset siedemdziesiąt pięć tysięcy " +
                    "osiemset siedem"
    ]
}
