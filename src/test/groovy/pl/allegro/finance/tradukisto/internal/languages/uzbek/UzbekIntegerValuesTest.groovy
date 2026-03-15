package pl.allegro.finance.tradukisto.internal.languages.uzbek

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.uzbekContainer

class UzbekIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = uzbekContainer().getIntegerConverter()
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0            : "nol",
            1            : "bir",
            2            : "ikki",
            3            : "uch",
            4            : "to'rt",
            5            : "besh",
            6            : "olti",
            7            : "yetti",
            8            : "sakkiz",
            9            : "to'qqiz",
            10           : "o'n",

            11           : "o'n bir",
            12           : "o'n ikki",
            13           : "o'n uch",
            14           : "o'n to'rt",
            15           : "o'n besh",
            16           : "o'n olti",
            17           : "o'n yetti",
            18           : "o'n sakkiz",
            19           : "o'n to'qqiz",

            20           : "yigirma",
            30           : "o'ttiz",
            40           : "qirq",
            50           : "ellik",
            60           : "oltmish",
            70           : "yetmish",
            80           : "sakson",
            90           : "to'qson",
            100          : "bir yuz",

            200          : "ikki yuz",
            300          : "uch yuz",
            400          : "to'rt yuz",
            500          : "besh yuz",
            600          : "olti yuz",
            700          : "yetti yuz",
            800          : "sakkiz yuz",
            900          : "to'qqiz yuz",
            1000         : "bir ming",

            1_000_000    : "bir million",
            1_000_000_000: "bir milliard",

            21           : "yigirma bir",
            37           : "o'ttiz yetti",
            43           : "qirq uch",
            58           : "ellik sakkiz",
            69           : "oltmish to'qqiz",
            76           : "yetmish olti",
            82           : "sakson ikki",
            95           : "to'qson besh",

            111          : "bir yuz o'n bir",
            272          : "ikki yuz yetmish ikki",
            387          : "uch yuz sakson yetti",
            448          : "to'rt yuz qirq sakkiz",
            569          : "besh yuz oltmish to'qqiz",
            625          : "olti yuz yigirma besh",
            782          : "yetti yuz sakson ikki",
            895          : "sakkiz yuz to'qson besh",
            999          : "to'qqiz yuz to'qson to'qqiz",

            2_000        : "ikki ming",
            3_000        : "uch ming",
            4_000        : "to'rt ming",
            5_000        : "besh ming",
            7_634        : "yetti ming olti yuz o'ttiz to'rt",

            11_000       : "o'n bir ming",
            15_000       : "o'n besh ming",
            21_000       : "yigirma bir ming",
            24_190       : "yigirma to'rt ming bir yuz to'qson",
            653_000      : "olti yuz ellik uch ming",
            123_454      : "bir yuz yigirma uch ming to'rt yuz ellik to'rt",
            700_000      : "yetti yuz ming",
            999_999      : "to'qqiz yuz to'qson to'qqiz ming to'qqiz yuz to'qson to'qqiz",

            2_000_000    : "ikki million",
            5_000_000    : "besh million",
            23_437_219   : "yigirma uch million to'rt yuz o'ttiz yetti ming ikki yuz o'n to'qqiz",
            100_000_000  : "bir yuz million",
            123_456_789  : "bir yuz yigirma uch million to'rt yuz ellik olti ming yetti yuz sakson to'qqiz",
            322_089_890  : "uch yuz yigirma ikki million sakson to'qqiz ming sakkiz yuz to'qson",

            2_147_483_647: "ikki milliard bir yuz qirq yetti million to'rt yuz sakson uch ming olti yuz qirq yetti"
    ]
}
