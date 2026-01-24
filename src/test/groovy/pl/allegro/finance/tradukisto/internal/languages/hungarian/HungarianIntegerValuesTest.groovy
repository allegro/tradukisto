package pl.allegro.finance.tradukisto.internal.languages.hungarian

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.hungarianContainer

class HungarianIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = hungarianContainer().getIntegerConverter()
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0            : "nulla",
            1            : "egy",
            2            : "kettő",
            3            : "három",
            4            : "négy",
            5            : "öt",
            6            : "hat",
            7            : "hét",
            8            : "nyolc",
            9            : "kilenc",

            11           : "tizenegy",
            12           : "tizenkettő",
            13           : "tizenhárom",
            14           : "tizennégy",
            15           : "tizenöt",
            16           : "tizenhat",
            17           : "tizenhét",
            18           : "tizennyolc",
            19           : "tizenkilenc",

            10           : "tíz",
            20           : "húsz",
            30           : "harminc",
            40           : "negyven",
            50           : "ötven",
            60           : "hatvan",
            70           : "hetven",
            80           : "nyolcvan",
            90           : "kilencven",

            21           : "huszonegy",
            37           : "harminchét",
            43           : "negyvenhárom",
            58           : "ötvennyolc",
            69           : "hatvankilenc",
            76           : "hetvenhat",
            82           : "nyolcvankettő",
            95           : "kilencvenöt",

            100          : "száz",
            200          : "kétszáz",
            300          : "háromszáz",
            400          : "négyszáz",
            500          : "ötszáz",
            600          : "hatszáz",
            700          : "hétszáz",
            800          : "nyolcszáz",
            900          : "kilencszáz",

            111          : "száztizenegy",
            272          : "kétszázhetvenkettő",
            387          : "háromszáznyolcvanhét",
            448          : "négyszáznegyvennyolc",
            569          : "ötszázhatvankilenc",
            625          : "hatszázhuszonöt",
            782          : "hétszáznyolcvankettő",
            895          : "nyolcszázkilencvenöt",
            999          : "kilencszázkilencvenkilenc",

            1_000        : "ezer",
            2_000        : "kétezer",
            3_000        : "háromezer",
            4_000        : "négyezer",
            5_000        : "ötezer",
            7_634        : "hétezerhatszázharmincnégy",
            11_000       : "tizenegyezer",
            15_000       : "tizenötezer",
            21_000       : "huszonegyezer",
            24_190       : "huszonnégyezerszázkilencven",
            653_000      : "hatszázötvenháromezer",
            123_454      : "százhuszonháromezernégyszázötvennégy",
            700_000      : "hétszázezer",
            999_999      : "kilencszázkilencvenkilencezerkilencszázkilencvenkilenc",

            1_000_000    : "egy millió",
            2_000_000    : "két millió",
            5_000_000    : "öt millió",
            23_437_219   : "huszonhárom millió négyszázharminchétezerkétszáztizenkilenc",
            100_000_000  : "száz millió",
            123_456_789  : "százhuszonhárom millió négyszázötvenhatezerhétszáznyolcvankilenc",
            322_089_890  : "háromszázhuszonkét millió nyolcvankilencezernyolcszázkilencven",

            1_000_000_000: "egy milliárd",
            2_147_483_647: "két milliárd száznegyvenhét millió négyszáznyolcvanháromezerhatszáznegyvenhét"
    ]
}
