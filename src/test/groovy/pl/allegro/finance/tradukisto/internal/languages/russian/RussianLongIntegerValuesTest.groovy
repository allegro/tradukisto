package pl.allegro.finance.tradukisto.internal.languages.russian

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.russianContainer

class RussianLongIntegerValuesTest  extends AbstractLongValuesTest {

    def setup() {
        longConverter = russianContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000            : "пять миллиардов",

            1_000_000_000_000        : "один триллион",
            2_000_000_000_000        : "два триллиона",
            5_000_000_000_000        : "пять триллионов",

            1_000_000_000_000_000    : "один квадриллион",
            2_000_000_000_000_000    : "два квадриллиона",
            5_000_000_000_000_000    :  "пять квадриллионов",

            1_000_000_000_000_000_000:  "один квинтиллион",
            2_000_000_000_000_000_000: "два квинтиллиона",
            (Long.MAX_VALUE)         :  "девять квинтиллионов двести двадцать три квадриллиона триста семьдесят два триллиона тридцать шесть миллиардов восемьсот пятьдесят четыре миллиона семьсот семьдесят пять тысяч восемьсот семь"

    ]
}
