package pl.allegro.finance.tradukisto.internal.languages.swedish

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.swedishContainer

class SwedishIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = swedishContainer().getIntegerConverter()
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0         : "noll",
            1         : "ett",
            2         : "två",
            3         : "tre",
            4         : "fyra",
            5         : "fem",
            6         : "sex",
            7         : "sju",
            8         : "åtta",
            9         : "nio",

            11        : "elva",
            12        : "tolv",
            13        : "tretton",
            14        : "fjorton",
            15        : "femton",
            16        : "sexton",
            17        : "sjutton",
            18        : "arton",
            19        : "nitton",

            10        : "tio",
            20        : "tjugo",
            30        : "trettio",
            40        : "fyrtio",
            50        : "femtio",
            60        : "sextio",
            70        : "sjuttio",
            80        : "åttio",
            90        : "nittio",

            21        : "tjugoett",
            32        : "trettiotvå",
            37        : "trettiosju",
            43        : "fyrtiotre",
            54        : "femtiofyra",
            58        : "femtioåtta",
            65        : "sextiofem",
            69        : "sextionio",
            76        : "sjuttiosex",
            82        : "åttiotvå",
            87        : "åttiosju",
            95        : "nittiofem",
            98        : "nittioåtta",

            100       : "ett hundra",
            200       : "två hundra",
            300       : "tre hundra",
            400       : "fyra hundra",
            500       : "fem hundra",
            600       : "sex hundra",
            700       : "sju hundra",
            800       : "åtta hundra",
            900       : "nio hundra",

            109       : "ett hundra och nio",
            111       : "ett hundra och elva",
            218       : "två hundra och arton",
            272       : "två hundra och sjuttiotvå",
            327       : "tre hundra och tjugosju",
            387       : "tre hundra och åttiosju",
            436       : "fyra hundra och trettiosex",
            448       : "fyra hundra och fyrtioåtta",
            545       : "fem hundra och fyrtiofem",
            569       : "fem hundra och sextionio",
            625       : "sex hundra och tjugofem",
            654       : "sex hundra och femtiofyra",
            763       : "sju hundra och sextiotre",
            782       : "sju hundra och åttiotvå",
            872       : "åtta hundra och sjuttiotvå",
            895       : "åtta hundra och nittiofem",
            981       : "nio hundra och åttioett",
            999       : "nio hundra och nittionio",

            1000      : "ett tusen",
            2000      : "två tusen",
            3000      : "tre tusen",
            4000      : "fyra tusen",
            5000      : "fem tusen",
            6000      : "sex tusen",
            7000      : "sju tusen",
            8000      : "åtta tusen",
            9000      : "nio tusen",

            1911      : "ett tusen nio hundra och elva",
            2890      : "två tusen åtta hundra och nittio",
            3789      : "tre tusen sju hundra och åttionio",
            4678      : "fyra tusen sex hundra och sjuttioåtta",
            5567      : "fem tusen fem hundra och sextiosju",
            6456      : "sex tusen fyra hundra och femtiosex",
            7345      : "sju tusen tre hundra och fyrtiofem",
            7634      : "sju tusen sex hundra och trettiofyra",
            8234      : "åtta tusen två hundra och trettiofyra",
            9123      : "nio tusen ett hundra och tjugotre",

            21000     : "tjugoett tusen",
            24190     : "tjugofyra tusen ett hundra och nittio",
            123454    : "ett hundra och tjugotre tusen fyra hundra och femtiofyra",
            653000    : "sex hundra och femtiotre tusen",
            999999    : "nio hundra och nittionio tusen nio hundra och nittionio",

            10000     : "tio tusen",
            11000     : "elva tusen",
            12000     : "tolv tusen",
            13000     : "tretton tusen",
            14000     : "fjorton tusen",
            15000     : "femton tusen",
            16000     : "sexton tusen",
            17000     : "sjutton tusen",
            18000     : "arton tusen",
            19000     : "nitton tusen",

            20000     : "tjugo tusen",
            30000     : "trettio tusen",
            40000     : "fyrtio tusen",
            50000     : "femtio tusen",
            60000     : "sextio tusen",
            70000     : "sjuttio tusen",
            80000     : "åttio tusen",
            90000     : "nittio tusen",

            100000    : "ett hundra tusen",
            200000    : "två hundra tusen",
            300000    : "tre hundra tusen",
            400000    : "fyra hundra tusen",
            500000    : "fem hundra tusen",
            600000    : "sex hundra tusen",
            700000    : "sju hundra tusen",
            800000    : "åtta hundra tusen",

            1000000   : "en miljon",
            2000000   : "två miljoner",
            3000000   : "tre miljoner",
            4000000   : "fyra miljoner",
            5000000   : "fem miljoner",
            6000000   : "sex miljoner",
            7000000   : "sju miljoner",
            8000000   : "åtta miljoner",
            9000000   : "nio miljoner",

            1111111   : "en miljon ett hundra och elva tusen ett hundra och elva",
            2222222   : "två miljoner två hundra och tjugotvå tusen två hundra och tjugotvå",
            3333333   : "tre miljoner tre hundra och trettiotre tusen tre hundra och trettiotre",
            4444444   : "fyra miljoner fyra hundra och fyrtiofyra tusen fyra hundra och fyrtiofyra",
            5555555   : "fem miljoner fem hundra och femtiofem tusen fem hundra och femtiofem",
            6666666   : "sex miljoner sex hundra och sextiosex tusen sex hundra och sextiosex",
            7777777   : "sju miljoner sju hundra och sjuttiosju tusen sju hundra och sjuttiosju",
            8888888   : "åtta miljoner åtta hundra och åttioåtta tusen åtta hundra och åttioåtta",
            9999999   : "nio miljoner nio hundra och nittionio tusen nio hundra och nittionio",

            23437219  : "tjugotre miljoner fyra hundra och trettiosju tusen två hundra och nitton",
            100000000 : "ett hundra miljoner",
            123456789 : "ett hundra och tjugotre miljoner fyra hundra och femtiosex tusen sju hundra och åttionio",
            322089890 : "tre hundra och tjugotvå miljoner åttionio tusen åtta hundra och nittio",

            1000000000: "en miljard",
            2000000000: "två miljarder",
            2147483647: "två miljarder ett hundra och fyrtiosju miljoner fyra hundra och åttiotre tusen sex hundra och fyrtiosju"
    ]
}
