package pl.allegro.finance.tradukisto.internal.languages.japanese

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.japaneseKanjiContainer

class JapaneseKanjiLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = japaneseKanjiContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000             : "五十億",

            1_000_000_000_000         : "一兆",
            2_000_000_000_000         : "二兆",
            5_000_000_000_000         : "五兆",

            1_000_000_000_000_000     : "千兆",
            2_000_000_000_000_000     : "二千兆",
            5_000_000_000_000_000     : "五千兆",

            1_000_000_000_000_000_000 : "百京",
            2_000_000_000_000_000_000 : "二百京",
            (Long.MAX_VALUE)            : "九百二十二京三千三百七十二兆三百六十八億五千四百七十七万五千八百七"
    ]
}
