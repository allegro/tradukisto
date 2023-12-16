package pl.allegro.finance.tradukisto.internal.languages.hindi

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.hindiContainer

class HindiLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = hindiContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000            : "पाँच अरब",

            1_000_000_000_000        : "दस खरब",
            2_000_000_000_000        : "बीस खरब",
            5_000_000_000_000        : "पचास खरब",

            1_000_000_000_000_000    : "एक पद्म",
            2_000_000_000_000_000    : "दो पद्म",
            5_000_000_000_000_000    : "पाँच पद्म",

            1_000_000_000_000_000_000: "दस शंख",
            2_000_000_000_000_000_000: "बीस शंख",
            (Long.MAX_VALUE)         : "बानवे शंख तेईस पद्म सैंतीस नील बीस खरब छत्तीस अरब पचासी करोड़ सैंतालीस लाख पचहत्तर हजार आठ सौ सात"
    ]
}
