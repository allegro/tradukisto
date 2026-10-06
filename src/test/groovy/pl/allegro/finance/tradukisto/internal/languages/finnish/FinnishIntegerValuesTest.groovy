package pl.allegro.finance.tradukisto.internal.languages.finnish

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.finnishContainer

class FinnishIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = finnishContainer().getIntegerConverter()
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0         : "nolla",
            1         : "yksi",
            2         : "kaksi",
            3         : "kolme",
            4         : "neljä",
            5         : "viisi",
            6         : "kuusi",
            7         : "seitsemän",
            8         : "kahdeksan",
            9         : "yhdeksän",

            11        : "yksitoista",
            12        : "kaksitoista",
            13        : "kolmetoista",
            14        : "neljätoista",
            15        : "viisitoista",
            16        : "kuusitoista",
            17        : "seitsemäntoista",
            18        : "kahdeksantoista",
            19        : "yhdeksäntoista",

            10        : "kymmenen",
            20        : "kaksikymmentä",
            30        : "kolmekymmentä",
            40        : "neljäkymmentä",
            50        : "viisikymmentä",
            60        : "kuusikymmentä",
            70        : "seitsemänkymmentä",
            80        : "kahdeksankymmentä",
            90        : "yhdeksänkymmentä",

            21        : "kaksikymmentäyksi",
            37        : "kolmekymmentäseitsemän",
            43        : "neljäkymmentäkolme",
            58        : "viisikymmentäkahdeksan",
            69        : "kuusikymmentäyhdeksän",
            76        : "seitsemänkymmentäkuusi",
            82        : "kahdeksankymmentäkaksi",
            95        : "yhdeksänkymmentäviisi",

            100       : "sata",
            200       : "kaksisataa",
            300       : "kolmesataa",
            400       : "neljäsataa",
            500       : "viisisataa",
            600       : "kuusisataa",
            700       : "seitsemänsataa",
            800       : "kahdeksansataa",
            900       : "yhdeksänsataa",

            111       : "satayksitoista",
            272       : "kaksisataaseitsemänkymmentäkaksi",
            387       : "kolmesataakahdeksankymmentäseitsemän",
            448       : "neljäsataaneljäkymmentäkahdeksan",
            569       : "viisisataakuusikymmentäyhdeksän",
            625       : "kuusisataakaksikymmentäviisi",
            782       : "seitsemänsataakahdeksankymmentäkaksi",
            895       : "kahdeksansataayhdeksänkymmentäviisi",
            999       : "yhdeksänsataayhdeksänkymmentäyhdeksän",

            1000      : "tuhat",
            2000      : "kaksituhatta",
            3000      : "kolmetuhatta",
            4000      : "neljätuhatta",
            5000      : "viisituhatta",
            7634      : "seitsemäntuhatta kuusisataakolmekymmentäneljä",

            11000     : "yksitoistatuhatta",
            15000     : "viisitoistatuhatta",
            21000     : "kaksikymmentäyksituhatta",
            24190     : "kaksikymmentäneljätuhatta satayhdeksänkymmentä",
            653000    : "kuusisataaviisikymmentäkolmetuhatta",
            123454    : "satakaksikymmentäkolmetuhatta neljäsataaviisikymmentäneljä",
            700000    : "seitsemänsataatuhatta",
            999999    : "yhdeksänsataayhdeksänkymmentäyhdeksäntuhatta yhdeksänsataayhdeksänkymmentäyhdeksän",

            1000000   : "miljoona",
            2000000   : "kaksi miljoonaa",
            5000000   : "viisi miljoonaa",
            23437219  : "kaksikymmentäkolme miljoonaa neljäsataakolmekymmentäseitsemäntuhatta kaksisataayhdeksäntoista",
            100000000 : "sata miljoonaa",
            123456789 : "satakaksikymmentäkolme miljoonaa neljäsataaviisikymmentäkuusituhatta seitsemänsataakahdeksankymmentäyhdeksän",
            322089890 : "kolmesataakaksikymmentäkaksi miljoonaa kahdeksankymmentäyhdeksäntuhatta kahdeksansataayhdeksänkymmentä",

            1000000000: "miljardi",
            2147483647: "kaksi miljardia sataneljäkymmentäseitsemän miljoonaa neljäsataakahdeksankymmentäkolmetuhatta kuusisataaneljäkymmentäseitsemän"
    ]
}
