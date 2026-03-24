package pl.allegro.finance.tradukisto.internal.languages.uzbek

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.uzbekCyrillicContainer

class UzbekCyrillicLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = uzbekCyrillicContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000            : "беш миллиард",

            1_000_000_000_000        : "бир триллион",
            2_000_000_000_000        : "икки триллион",
            5_000_000_000_000        : "беш триллион",

            1_000_000_000_000_000    : "бир квадриллион",
            2_000_000_000_000_000    : "икки квадриллион",
            5_000_000_000_000_000    : "беш квадриллион",

            1_000_000_000_000_000_000: "бир квинтиллион",
            2_000_000_000_000_000_000: "икки квинтиллион",
            (Long.MAX_VALUE)         : "тўққиз квинтиллион икки юз йигирма уч квадриллион " +
                    "уч юз етмиш икки триллион ўттиз олти миллиард " +
                    "саккиз юз эллик тўрт миллион етти юз етмиш беш минг " +
                    "саккиз юз етти"
    ]
}
