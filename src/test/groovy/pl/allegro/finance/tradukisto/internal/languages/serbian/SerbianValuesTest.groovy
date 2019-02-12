package pl.allegro.finance.tradukisto.internal.languages.serbian

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.serbianContainer

class SerbianValuesTest extends Specification {

    static converter = serbianContainer().getNumbersConverter()

    @Unroll
    def "should convert #value to '#words' in Serbian"() {
        expect:
        converter.asWords(value) == words

        where:
        value                     | words
        0                         | "nula"
        1                         | "jedan"
        2                         | "dva"
        3                         | "tri"
        4                         | "četiri"
        5                         | "pet"
        6                         | "šest"
        7                         | "sedam"
        8                         | "osam"
        9                         | "devet"

        11                        | "jedanaest"
        12                        | "dvanaest"
        13                        | "trinaest"
        14                        | "četrnaest"
        15                        | "petnaest"
        16                        | "šestnaest"
        17                        | "sedamnaest"
        18                        | "osamnaest"
        19                        | "devetnaest"

        10                        | "deset"
        20                        | "dvadeset"
        30                        | "trideset"
        40                        | "četrdeset"
        50                        | "pedeset"
        60                        | "šezdeset"
        70                        | "sedamdeset"
        80                        | "osamdeset"
        90                        | "devedeset"

        21                        | "dvadeset jedan"
        37                        | "trideset sedam"
        43                        | "četrdeset tri"
        58                        | "pedeset osam"
        69                        | "šezdeset devet"
        76                        | "sedamdeset šest"
        82                        | "osamdeset dva"
        95                        | "devedeset pet"

        100                       | "sto"
        200                       | "dvesta"
        300                       | "trista"
        400                       | "četristo"
        500                       | "petsto"
        600                       | "šeststo"
        700                       | "sedamsto"
        800                       | "osamsto"
        900                       | "devetsto"

        111                       | "sto jedanaest"
        272                       | "dvesta sedamdeset dva"
        387                       | "trista osamdeset sedam"
        448                       | "četristo četrdeset osam"
        569                       | "petsto šezdeset devet"
        625                       | "šeststo dvadeset pet"
        782                       | "sedamsto osamdeset dva"
        895                       | "osamsto devedeset pet"
        999                       | "devetsto devedeset devet"

        1_000                     | "jedna hiljada"
        2_000                     | "dve hiljade"
        5_000                     | "pet hiljada"
        7_634                     | "sedam hiljada šeststo trideset četiri"
        24_190                    | "dvadeset četiri hiljade sto devedeset"
        653_000                   | "šeststo pedeset tri hiljade"
        123_454                   | "sto dvadeset tri hiljade četristo pedeset četiri"
        700_000                   | "sedamsto hiljada"
        999_999                   | "devetsto devedeset devet hiljada devetsto devedeset devet"

        1_000_000                 | "jedan milion"
        2_000_000                 | "dva miliona"
        5_000_000                 | "pet miliona"
        23_437_219                | "dvadeset tri miliona četristo trideset sedam hiljada dvesta devetnaest"
        100_000_000               | "sto miliona"
        123_456_789               | "sto dvadeset tri miliona četristo pedeset šest hiljada sedamsto osamdeset devet"

        1_000_000_000             | "jedna milijarda"
        Integer.MAX_VALUE         | "dve milijarde sto četrdeset sedam miliona četristo osamdeset tri hiljade šeststo četrdeset sedam"

    }
}
