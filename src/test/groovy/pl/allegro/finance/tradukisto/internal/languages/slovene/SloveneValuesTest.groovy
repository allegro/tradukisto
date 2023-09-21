package pl.allegro.finance.tradukisto.internal.languages.slovene

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.sloveneContainer

class SloveneValuesTest extends Specification {

    static intConverter = sloveneContainer().getIntegerConverter()
    static longConverter = sloveneContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Slovene"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value             | words
        0                 | "nič"
        1                 | "ena"
        2                 | "dva"
        3                 | "tri"
        4                 | "štiri"
        5                 | "pet"
        6                 | "šest"
        7                 | "sedem"
        8                 | "osem"
        9                 | "devet"
        11                | "enajst"
        12                | "dvanajst"
        13                | "trinajst"
        14                | "štirinajst"
        15                | "petnajst"
        16                | "šestnajst"
        17                | "sedemnajst"
        18                | "osemnajst"
        19                | "devetnajst"
        10                | "deset"
        20                | "dvajset"
        30                | "trideset"
        40                | "štirideset"
        50                | "petdeset"
        60                | "šestdeset"
        70                | "sedemdeset"
        80                | "osemdeset"
        90                | "devetdeset"
        21                | "enaindvajset"
        37                | "sedemintrideset"
        43                | "triinštirideset"
        58                | "oseminpetdeset"
        69                | "devetinšestdeset"
        76                | "šestinsedemdeset"
        82                | "dvainosemdeset"
        95                | "petindevetdeset"
        100               | "sto"
        200               | "dvesto"
        300               | "tristo"
        400               | "štiristo"
        500               | "petsto"
        600               | "šeststo"
        700               | "sedemsto"
        800               | "osemsto"
        900               | "devetsto"
        101               | "sto ena"
        111               | "sto enajst"
        272               | "dvesto dvainsedemdeset"
        387               | "tristo sedeminosemdeset"
        421               | "štiristo enaindvajset"
        448               | "štiristo oseminštirideset"
        569               | "petsto devetinšestdeset"
        625               | "šeststo petindvajset"
        782               | "sedemsto dvainosemdeset"
        895               | "osemsto petindevetdeset"
        999               | "devetsto devetindevetdeset"
        1_000             | "ena tisoč"
        2_000             | "dva tisoč"
        3_000             | "tri tisoč"
        4_000             | "štiri tisoč"
        5_000             | "pet tisoč"
        11_000            | "enajst tisoč"
        12_000            | "dvanajst tisoč"
        13_000            | "trinajst tisoč"
        14_000            | "štirinajst tisoč"
        15_000            | "petnajst tisoč"
        21_000            | "enaindvajset tisoč"
        7_634             | "sedem tisoč šeststo štiriintrideset"
        24_190            | "štiriindvajset tisoč sto devetdeset"
        99_999            | "devetindevetdeset tisoč devetsto devetindevetdeset"
        111_000           | "sto enajst tisoč"
        112_000           | "sto dvanajst tisoč"
        113_000           | "sto trinajst tisoč"
        115_000           | "sto petnajst tisoč"
        700_000           | "sedemsto tisoč"
        653_000           | "šeststo triinpetdeset tisoč"
        123_454           | "sto triindvajset tisoč štiristo štiriinpetdeset"
        999_999           | "devetsto devetindevetdeset tisoč devetsto devetindevetdeset"
        1_000_000         | "ena milijon"
        2_000_000         | "dva milijona"
        3_000_000         | "tri milijone"
        4_000_000         | "štiri milijone"
        5_000_000         | "pet milijonov"
        6_000_000         | "šest milijonov"
        11_437_219        | "enajst milijonov štiristo sedemintrideset tisoč dvesto devetnajst"
        21_437_219        | "enaindvajset milijonov štiristo sedemintrideset tisoč dvesto devetnajst"
        22_437_219        | "dvaindvajset milijonov štiristo sedemintrideset tisoč dvesto devetnajst"
        23_437_219        | "triindvajset milijonov štiristo sedemintrideset tisoč dvesto devetnajst"
        100_000_000       | "sto milijonov"
        121_000_000       | "sto enaindvajset milijonov"
        121_451_789       | "sto enaindvajset milijonov štiristo enainpetdeset tisoč sedemsto devetinosemdeset"
        123_456_789       | "sto triindvajset milijonov štiristo šestinpetdeset tisoč sedemsto devetinosemdeset"
        1_000_000_000     | "ena milijarda"
        2_141_123_731     | "dve milijardi sto enainštirideset milijonov sto triindvajset tisoč sedemsto enaintrideset"
        Integer.MAX_VALUE | "dve milijardi sto sedeminštirideset milijonov štiristo triinosemdeset tisoč šeststo sedeminštirideset"
    }

    @Ignore("Needs Slovene long converter")
    @Unroll
    def "should convert long #value to '#words' in Slovene"() {
        expect:
        longConverter.asWords(value) == words

        where:
        value                     | words
        5_000_000_000             | "pet milijardi"

        1_000_000_000_000         | "jedan bilijun"
        2_000_000_000_000         | "dva bilijuna"
        5_000_000_000_000         | "pet bilijuna"

        1_000_000_000_000_000     | "jedna bilijarda"
        2_000_000_000_000_000     | "dvije bilijarde"
        5_000_000_000_000_000     | "pet bilijardi"

        1_000_000_000_000_000_000 | "jedan trilijun"
        2_000_000_000_000_000_000 | "dva trilijuna"
        Long.MAX_VALUE            | "devet trilijuna dvjesto dvadeset tri bilijarde tristo sedamdeset dva bilijuna trideset šest milijardi osamsto pedeset četiri milijona sedamsto sedamdeset pet tisuća osamsto sedam"
    }
}
