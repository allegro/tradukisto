package pl.allegro.finance.tradukisto.internal.languages.english

import pl.allegro.finance.tradukisto.internal.languages.AbstractValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.englishContainer

class EnglishValuesTest extends AbstractValuesTest {

    @Override
    ValuesTestData getTestData() {
        testData = new ValuesTestData(
                englishContainer(),
                intWords,
                longWords
        )
    }

    private static intWords = [
            0            : "zero",
            1            : "one",
            2            : "two",
            3            : "three",
            4            : "four",
            5            : "five", // if you comment it - this one test will fail
            6            : "six",
            7            : "seven",
            8            : "eight",
            9            : "nine",

            11           : "eleven",
            12           : "twelve",
            13           : "thirteen",
            14           : "fourteen",
            15           : "fifteen",
            16           : "sixteen",
            17           : "seventeen",
            18           : "eighteen",
            19           : "nineteen",

            10           : "ten",
            20           : "twenty",
            30           : "thirty",
            40           : "forty",
            50           : "fifty",
            60           : "sixty",
            70           : "seventy",
            80           : "eighty",
            90           : "ninety",

            21           : "twenty-one",
            37           : "thirty-seven",
            43           : "forty-three",
            58           : "fifty-eight",
            69           : "sixty-nine",
            76           : "seventy-six",
            82           : "eighty-two",
            95           : "ninety-five",

            100          : "one hundred",
            200          : "two hundred",
            300          : "three hundred",
            400          : "four hundred",
            500          : "five hundred",
            600          : "six hundred",
            700          : "seven hundred",
            800          : "eight hundred",
            900          : "nine hundred",

            111          : "one hundred eleven",
            272          : "two hundred seventy-two",
            387          : "three hundred eighty-seven",
            448          : "four hundred forty-eight",
            569          : "five hundred sixty-nine",
            625          : "six hundred twenty-five",
            782          : "seven hundred eighty-two",
            895          : "eight hundred ninety-five",
            999          : "nine hundred ninety-nine",

            1_000        : "one thousand",
            2_000        : "two thousand",
            3_000        : "three thousand",
            4_000        : "four thousand",
            5_000        : "five thousand",
            2_137        : "two thousand one hundred thirty-seven", // not required, but added to extend test data, passes
            7_634        : "seven thousand six hundred thirty-four",
            11_000       : "eleven thousand",
            15_000       : "fifteen thousand",
            21_000       : "twenty-one thousand",
            24_190       : "twenty-four thousand one hundred ninety",
            653_000      : "six hundred fifty-three thousand",
            123_454      : "one hundred twenty-three thousand four hundred fifty-four",
            700_000      : "seven hundred thousand",
            999_999      : "nine hundred ninety-nine thousand nine hundred ninety-nine",

            1_000_000    : "one million",
            2_000_000    : "two million",
            5_000_000    : "five million",
            23_437_219   : "twenty-three million four hundred thirty-seven thousand two hundred nineteen",
            100_000_000  : "one hundred million",
            123_456_789  : "one hundred twenty-three million four hundred fifty-six thousand seven hundred eighty-nine",
            322_089_890  : "three hundred twenty-two million eighty-nine thousand eight hundred ninety",

            1_000_000_000: "one billion",
            2_147_483_647: "two billion one hundred forty-seven million four hundred eighty-three thousand six hundred " +
                    "forty-seven"
    ]

    private static longWords = [
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
