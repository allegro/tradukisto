package pl.allegro.finance.tradukisto.internal.languages.serbian

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.serbianContainer

class SerbianIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = serbianContainer().getIntegerConverter()
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
            16                 : "šestnaest",
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
            200                : "dvesta",
            300                : "trista",
            400                : "četiristo",
            500                : "petsto",
            600                : "šeststo",
            700                : "sedamsto",
            800                : "osamsto",
            900                : "devetsto",

            101                : "sto jedan",
            111                : "sto jedanaest",
            272                : "dvesta sedamdeset dva",
            387                : "trista osamdeset sedam",
            421                : "četiristo dvadeset jedan",
            448                : "četiristo četrdeset osam",
            569                : "petsto šezdeset devet",
            625                : "šeststo dvadeset pet",
            782                : "sedamsto osamdeset dva",
            895                : "osamsto devedeset pet",
            999                : "devetsto devedeset devet",

            1_000              : "jedna hiljada",
            2_000              : "dve hiljade",
            3_000              : "tri hiljade",
            4_000              : "četiri hiljade",
            5_000              : "pet hiljada",
            11_000             : "jedanaest hiljada",
            12_000             : "dvanaest hiljada",
            13_000             : "trinaest hiljada",
            14_000             : "četrnaest hiljada",
            15_000             : "petnaest hiljada",
            21_000             : "dvadeset jedna hiljada",

            7_634              : "sedam hiljada šeststo trideset četiri",
            24_190             : "dvadeset četiri hiljade sto devedeset",
            99_999             : "devedeset devet hiljada devetsto devedeset devet",

            111_000            : "sto jedanaest hiljada",
            112_000            : "sto dvanaest hiljada",
            113_000            : "sto trinaest hiljada",
            115_000            : "sto petnaest hiljada",
            700_000            : "sedamsto hiljada",
            653_000            : "šeststo pedeset tri hiljade",

            123_454            : "sto dvadeset tri hiljade četiristo pedeset četiri",
            999_999            : "devetsto devedeset devet hiljada devetsto devedeset devet",

            1_000_000          : "jedan milion",
            2_000_000          : "dva miliona",
            5_000_000          : "pet miliona",
            11_437_219         : "jedanaest miliona četiristo trideset sedam hiljada dvesta devetnaest",
            21_437_219         : "dvadeset jedan milion četiristo trideset sedam hiljada dvesta devetnaest",
            22_437_219         : "dvadeset dva miliona četiristo trideset sedam hiljada dvesta devetnaest",
            23_437_219         : "dvadeset tri miliona četiristo trideset sedam hiljada dvesta devetnaest",
            100_000_000        : "sto miliona",
            121_000_000        : "sto dvadeset jedan milion",
            121_451_789        : "sto dvadeset jedan milion četiristo pedeset jedna hiljada sedamsto osamdeset devet",
            123_456_789        : "sto dvadeset tri miliona četiristo pedeset šest hiljada sedamsto osamdeset devet",

            1_000_000_000      : "jedna milijarda",
            2_141_123_731      : "dve milijarde sto četrdeset jedan milion sto dvadeset tri hiljade sedamsto trideset jedan",
            (Integer.MAX_VALUE): "dve milijarde sto četrdeset sedam miliona četiristo osamdeset tri hiljade šeststo četrdeset sedam"
    ]
}
