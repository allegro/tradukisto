package pl.allegro.finance.tradukisto.internal.languages.spanish

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.spanishContainer

class SpanishValuesTest extends Specification {

    static intConverter = spanishContainer().getIntegerConverter()
    static longConverter = spanishContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Spanish"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value         | words
        0             | "cero"
        1             | "uno"
        2             | "dos"
        3             | "tres"
        4             | "cuatro"
        5             | "cinco"
        6             | "seis"
        7             | "siete"
        8             | "ocho"
        9             | "nueve"

        11            | "once"
        12            | "doce"
        13            | "trece"
        14            | "catorce"
        15            | "quince"
        16            | "dieciséis"
        17            | "diecisiete"
        18            | "dieciocho"
        19            | "diecinueve"

        10            | "diez"
        20            | "veinte"
        30            | "treinta"
        40            | "cuarenta"
        50            | "cincuenta"
        60            | "sesenta"
        70            | "setenta"
        80            | "ochenta"
        90            | "noventa"

        21            | "veintiuno"
        22            | "veintidós"
        31            | "treinta y uno"
        32            | "treinta y dos"
        37            | "treinta y siete"
        41            | "cuarenta y uno"
        43            | "cuarenta y tres"
        51            | "cincuenta y uno"
        58            | "cincuenta y ocho"
        61            | "sesenta y uno"
        69            | "sesenta y nueve"
        76            | "setenta y seis"
        82            | "ochenta y dos"
        95            | "noventa y cinco"

        100           | "cien"
        200           | "doscientos"
        300           | "trescientos"
        400           | "cuatrocientos"
        500           | "quinientos"
        600           | "seiscientos"
        700           | "setecientos"
        800           | "ochocientos"
        900           | "novecientos"

        101           | "ciento uno"
        111           | "ciento once"
        272           | "doscientos setenta y dos"
        387           | "trescientos ochenta y siete"
        448           | "cuatrocientos cuarenta y ocho"
        569           | "quinientos sesenta y nueve"
        625           | "seiscientos veinticinco"
        782           | "setecientos ochenta y dos"
        801           | "ochocientos uno"
        895           | "ochocientos noventa y cinco"
        999           | "novecientos noventa y nueve"

        1_000         | "mil"
        2_000         | "dos mil"
        3_000         | "tres mil"
        4_000         | "cuatro mil"
        5_000         | "cinco mil"
        7_634         | "siete mil seiscientos treinta y cuatro"
        11_000        | "once mil"
        15_000        | "quince mil"
        21_000        | "veintiún mil"
        24_190        | "veinticuatro mil ciento noventa"
        653_000       | "seiscientos cincuenta y tres mil"
        123_454       | "ciento veintitrés mil cuatrocientos cincuenta y cuatro"
        700_000       | "setecientos mil"
        999_999       | "novecientos noventa y nueve mil novecientos noventa y nueve"

        1_000_000     | "un millón"
        2_000_000     | "dos millones"
        5_000_000     | "cinco millones"
        23_437_219    | "veintitrés millones cuatrocientos treinta y siete mil doscientos diecinueve"
        100_000_000   | "cien millones"
        123_456_789   | "ciento veintitrés millones cuatrocientos cincuenta y seis mil setecientos ochenta y nueve"
        322_089_890   | "trescientos veintidós millones ochenta y nueve mil ochocientos noventa"

        1_000_000_000 | "mil millones"
        2_001_001_110 | "dos mil millones un millón mil ciento diez"
        2_005_004_110 | "dos mil millones cinco millones cuatro mil ciento diez"
        2_001_001_100 | "dos mil millones un millón mil cien"
        2_147_483_647 | "dos mil ciento cuarenta y siete millones cuatrocientos ochenta y tres mil seiscientos cuarenta y siete"
    }

    @Ignore("Needs Spanish long converter and values for trillion, quadrillion, quintillion")
    @Unroll
    def "should convert long #value to '#words' in Spanish"() {
        expect:
        longConverter.asWords(value) == words

        where:
        value                     | words
        5_000_000_000             | ""

        1_000_000_000_000         | ""
        2_000_000_000_000         | ""
        5_000_000_000_000         | ""

        1_000_000_000_000_000     | ""
        2_000_000_000_000_000     | ""
        5_000_000_000_000_000     | ""

        1_000_000_000_000_000_000 | ""
        2_000_000_000_000_000_000 | ""
        Long.MAX_VALUE            | ""
    }
}