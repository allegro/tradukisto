package pl.allegro.finance.tradukisto.internal.languages.slovak

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.slovakContainer

class SlovakIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = slovakContainer().getIntegerConverter()
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0            : "nula",
            1            : "jedna",
            2            : "dve",
            3            : "tri",
            4            : "štyri",
            5            : "päť",
            6            : "šesť",
            7            : "sedem",
            8            : "osem",
            9            : "deväť",

            11           : "jedenásť",
            12           : "dvanásť",
            13           : "trinásť",
            14           : "štrnásť",
            15           : "pätnásť",
            16           : "šestnásť",
            17           : "sedemnásť",
            18           : "osemnásť",
            19           : "devätnásť",

            10           : "desať",
            20           : "dvadsať",
            30           : "tridsať",
            40           : "štyridsať",
            50           : "päťdesiat",
            60           : "šesťdesiat",
            70           : "sedemdesiat",
            80           : "osemdesiat",
            90           : "deväťdesiat",

            21           : "dvadsať jedna",
            37           : "tridsať sedem",
            43           : "štyridsať tri",
            58           : "päťdesiat osem",
            69           : "šesťdesiat deväť",
            76           : "sedemdesiat šesť",
            82           : "osemdesiat dva",
            95           : "deväťdesiat päť",

            100          : "sto",
            200          : "dvesto",
            300          : "tristo",
            400          : "štyristo",
            500          : "päťsto",
            600          : "šesťsto",
            700          : "sedemsto",
            800          : "osemsto",
            900          : "deväťsto",

            111          : "sto jedenásť",
            272          : "dvesto sedemdesiat dva",
            387          : "tristo osemdesiat sedem",
            448          : "štyristo štyridsať osem",
            569          : "päťsto šesťdesiat deväť",
            625          : "šesťsto dvadsať päť",
            782          : "sedemsto osemdesiat dva",
            895          : "osemsto deväťdesiat päť",
            999          : "deväťsto deväťdesiat deväť",

            1_000        : "jeden tisíc",
            2_000        : "dva tisíce",
            3_000        : "tri tisíce",
            4_000        : "štyri tisíce",
            5_000        : "päť tisíc",
            7_634        : "sedem tisíc šesťsto tridsať štyri",
            11_000       : "jedenásť tisíc",
            15_000       : "pätnásť tisíc",
            21_000       : "dvadsať jeden tisíc",
            24_190       : "dvadsať štyri tisíc sto deväťdesiat",
            653_000      : "šesťsto päťdesiat tri tisíc",
            123_454      : "sto dvadsať tri tisíc štyristo päťdesiat štyri",
            700_000      : "sedemsto tisíc",
            999_999      : "deväťsto deväťdesiat deväť tisíc deväťsto deväťdesiat deväť",

            1_000_000    : "jeden milión",
            2_000_000    : "dva milióny",
            5_000_000    : "päť miliónov",
            23_437_219   : "dvadsať tri miliónov štyristo tridsať sedem tisíc dvesto devätnásť",
            100_000_000  : "sto miliónov",
            123_456_789  : "sto dvadsať tri miliónov štyristo päťdesiat šesť tisíc sedemsto osemdesiat deväť",
            322_089_890  : "tristo dvadsať dva miliónov osemdesiat deväť tisíc osemsto deväťdesiat",

            1_000_000_000: "jedna miliarda",
            2_147_483_647: "dve miliardy sto štyridsať sedem miliónov štyristo osemdesiat tri tisíc šesťsto štyridsať sedem"
    ]

    def "should convert any value in range of 0-999 in Slovak"() {
        when:
        def words = intConverter.asWords(value)

        then:
        notThrown(IllegalArgumentException)
        words.length() > 0

        where:
        value << (0..999)
    }
}
