package pl.allegro.finance.tradukisto.internal.languages.urdu

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.urduContainer

class UrduLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = urduContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslation)
    }

    private static longTranslation = [
            5_000_000_000            : "پانچ ارب",

            1_000_000_000_000        : "دس کھرب",
            2_000_000_000_000        : "بیس کھرب",
            5_000_000_000_000        : "پچاس کھرب",

            1_000_000_000_000_000    : "ایک پدم",
            2_000_000_000_000_000    : "دو پدم",
            5_000_000_000_000_000    : "پانچ پدم",

            1_000_000_000_000_000_000: "دس سنکھ",
            2_000_000_000_000_000_000: "بیس سنکھ",
            (Long.MAX_VALUE)         : "بانوے سنکھ تئیس پدم سینتیس نیلم بیس کھرب چھتیس ارب پچاسی کروڑ سینتالیس لاکھ پچہتر ہزار آٹھ سو سات"
    ]
}
