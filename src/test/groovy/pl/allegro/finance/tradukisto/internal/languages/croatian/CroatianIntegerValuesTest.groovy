package pl.allegro.finance.tradukisto.internal.languages.croatian

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.croatianContainer

class CroatianIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = croatianContainer().integerConverter
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0                  : "nula",
            1                  : "jedan",
            2                  : "dva",
            3                  : "tri",
            4                  : "četiri",
            5                  : "pet",
            6                  : "šest",
            7                  : "sedam",
            8                  : "osam",
            9                  : "devet",

            11                 : "jedanaest",
            12                 : "dvanaest",
            13                 : "trinaest",
            14                 : "četrnaest",
            15                 : "petnaest",
            16                 : "šesnaest",
            17                 : "sedamnaest",
            18                 : "osamnaest",
            19                 : "devetnaest",

            10                 : "deset",
            20                 : "dvadeset",
            30                 : "trideset",
            40                 : "četrdeset",
            50                 : "pedeset",
            60                 : "šezdeset",
            70                 : "sedamdeset",
            80                 : "osamdeset",
            90                 : "devedeset",

            21                 : "dvadeset jedan",
            37                 : "trideset sedam",
            43                 : "četrdeset tri",
            58                 : "pedeset osam",
            69                 : "šezdeset devet",
            76                 : "sedamdeset šest",
            82                 : "osamdeset dva",
            95                 : "devedeset pet",

            100                : "sto",
            200                : "dvjesto",
            300                : "tristo",
            400                : "četiristo",
            500                : "petsto",
            600                : "šeststo",
            700                : "sedamsto",
            800                : "osamsto",
            900                : "devetsto",

            101                : "sto jedan",
            111                : "sto jedanaest",
            272                : "dvjesto sedamdeset dva",
            387                : "tristo osamdeset sedam",
            421                : "četiristo dvadeset jedan",
            448                : "četiristo četrdeset osam",
            569                : "petsto šezdeset devet",
            625                : "šeststo dvadeset pet",
            782                : "sedamsto osamdeset dva",
            895                : "osamsto devedeset pet",
            999                : "devetsto devedeset devet",

            1_000              : "jedna tisuća",
            2_000              : "dvije tisuće",
            3_000              : "tri tisuće",
            4_000              : "četiri tisuće",
            5_000              : "pet tisuća",
            11_000             : "jedanaest tisuća",
            12_000             : "dvanaest tisuća",
            13_000             : "trinaest tisuća",
            14_000             : "četrnaest tisuća",
            15_000             : "petnaest tisuća",
            21_000             : "dvadeset jedna tisuća",

            7_634              : "sedam tisuća šeststo trideset četiri",
            24_190             : "dvadeset četiri tisuće sto devedeset",
            99_999             : "devedeset devet tisuća devetsto devedeset devet",

            111_000            : "sto jedanaest tisuća",
            112_000            : "sto dvanaest tisuća",
            113_000            : "sto trinaest tisuća",
            115_000            : "sto petnaest tisuća",
            700_000            : "sedamsto tisuća",
            653_000            : "šeststo pedeset tri tisuće",

            123_454            : "sto dvadeset tri tisuće četiristo pedeset četiri",
            999_999            : "devetsto devedeset devet tisuća devetsto devedeset devet",

            1_000_000          : "jedan milijun",
            2_000_000          : "dva milijuna",
            5_000_000          : "pet milijuna",
            11_437_219         : "jedanaest milijuna četiristo trideset sedam tisuća dvjesto devetnaest",
            21_437_219         : "dvadeset jedan milijun četiristo trideset sedam tisuća dvjesto devetnaest",
            22_437_219         : "dvadeset dva milijuna četiristo trideset sedam tisuća dvjesto devetnaest",
            23_437_219         : "dvadeset tri milijuna četiristo trideset sedam tisuća dvjesto devetnaest",
            100_000_000        : "sto milijuna",
            121_000_000        : "sto dvadeset jedan milijun",
            121_451_789        : "sto dvadeset jedan milijun četiristo pedeset jedna tisuća sedamsto osamdeset devet",
            123_456_789        : "sto dvadeset tri milijuna četiristo pedeset šest tisuća sedamsto osamdeset devet",
            322_089_890        : "tristo dvadeset dva milijuna osamdeset devet tisuća osamsto devedeset",

            1_000_000_000      : "jedna milijarda",
            2_141_123_731      : "dvije milijarde sto četrdeset jedan milijun sto dvadeset tri tisuće sedamsto trideset jedan",
            (Integer.MAX_VALUE): "dvije milijarde sto četrdeset sedam milijuna četiristo osamdeset tri tisuće šeststo četrdeset sedam"
    ]
}
