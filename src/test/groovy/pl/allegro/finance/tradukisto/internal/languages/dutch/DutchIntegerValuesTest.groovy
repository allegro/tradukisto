package pl.allegro.finance.tradukisto.internal.languages.dutch

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.dutchContainer

class DutchIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = dutchContainer().getIntegerConverter()
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0         : "nul",
            1         : "één",
            2         : "twee",
            3         : "drie",
            4         : "vier",
            5         : "vijf",
            6         : "zes",
            7         : "zeven",
            8         : "acht",
            9         : "negen",

            11        : "elf",
            12        : "twaalf",
            13        : "dertien",
            14        : "veertien",
            15        : "vijftien",
            16        : "zestien",
            17        : "zeventien",
            18        : "achttien",
            19        : "negentien",

            10        : "tien",
            20        : "twintig",
            30        : "dertig",
            40        : "veertig",
            50        : "vijftig",
            60        : "zestig",
            70        : "zeventig",
            80        : "tachtig",
            90        : "negentig",

            21        : "éénentwintig",
            37        : "zevenendertig",
            43        : "drieënveertig",
            58        : "achtenvijftig",
            62        : "tweeënzestig",
            69        : "negenenzestig",
            76        : "zesenzeventig",
            82        : "tweeëntachtig",
            95        : "vijfennegentig",

            100       : "honderd",
            200       : "tweehonderd",
            300       : "driehonderd",
            400       : "vierhonderd",
            500       : "vijfhonderd",
            600       : "zeshonderd",
            700       : "zevenhonderd",
            800       : "achthonderd",
            900       : "negenhonderd",

            111       : "honderdelf",
            272       : "tweehonderdtweeënzeventig",
            387       : "driehonderdzevenentachtig",
            448       : "vierhonderdachtenveertig",
            569       : "vijfhonderdnegenenzestig",
            625       : "zeshonderdvijfentwintig",
            782       : "zevenhonderdtweeëntachtig",
            895       : "achthonderdvijfennegentig",
            999       : "negenhonderdnegenennegentig",

            1000      : "duizend",
            1001      : "duizendéén",
            2000      : "tweeduizend",
            3000      : "drieduizend",
            4000      : "vierduizend",
            5000      : "vijfduizend",
            7634      : "zevenduizendzeshonderdvierendertig",

            11000     : "elfduizend",
            15000     : "vijftienduizend",
            21000     : "éénentwintigduizend",
            24190     : "vierentwintigduizendhonderdnegentig",
            24191     : "vierentwintigduizendhonderdéénennegentig",
            653000    : "zeshonderddrieënvijftigduizend",
            123454    : "honderddrieëntwintigduizendvierhonderdvierenvijftig",
            700000    : "zevenhonderdduizend",
            999999    : "negenhonderdnegenennegentigduizendnegenhonderdnegenennegentig",

            1000000   : "één miljoen",
            2000000   : "twee miljoen",
            5000000   : "vijf miljoen",
            23437219  : "drieëntwintig miljoen vierhonderdzevenendertigduizendtweehonderdnegentien",
            100000000 : "honderd miljoen",
            123456789 : "honderddrieëntwintig miljoen vierhonderdzesenvijftigduizendzevenhonderdnegenentachtig",
            322089890 : "driehonderdtweeëntwintig miljoen negenentachtigduizendachthonderdnegentig",

            1000000000: "één miljard",
            2147483647: "twee miljard honderdzevenenveertig miljoen vierhonderddrieëntachtigduizendzeshonderdzevenenveertig"
    ]
}
