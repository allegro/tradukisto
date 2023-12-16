package pl.allegro.finance.tradukisto.internal.languages.english

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.englishContainer

class EnglishLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = englishContainer().longConverter
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }
    private static longTranslations = [
            5_000_000_000            : "five billion",

            1_000_000_000_000        : "one trillion",
            2_000_000_000_000        : "two trillion",
            5_000_000_000_000        : "five trillion",

            1_000_000_000_000_000    : "one quadrillion",
            2_000_000_000_000_000    : "two quadrillion",
            5_000_000_000_000_000    : "five quadrillion",

            1_000_000_000_000_000_000: "one quintillion",
            2_000_000_000_000_000_000: "two quintillion",
            (Long.MAX_VALUE)         : "nine quintillion two hundred twenty-three quadrillion " +
                    "three hundred seventy-two trillion thirty-six billion " +
                    "eight hundred fifty-four million seven hundred seventy-five thousand " +
                    "eight hundred seven"
    ]
}
