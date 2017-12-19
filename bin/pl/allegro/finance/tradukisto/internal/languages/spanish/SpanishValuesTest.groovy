package pl.allegro.finance.tradukisto.internal.languages.portuguese

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.spanishContainer

class SpanishValuesTest extends Specification {

    static converter = spanishContainer().getNumbersConverter()

    @Unroll
    def "should convert #value to '#words' in Spanish"() {
        expect:
        converter.asWords(value) == words

        where:
        value      | words
        0          | "cero"
        1          | "uno"
        2          | "dos"
        3          | "tres"
        4          | "cuatro"
        5          | "cinco"
        6          | "seis"
        7          | "siete"
        8          | "ocho"
        9          | "nueve"

        11         | "once"
        12         | "doce"
        13         | "trece"
        14         | "catorce"
        15         | "quince"
        16         | "dieciséis"
        17         | "diecisiete"
        18         | "dieciocho"
        19         | "diecinueve"

        10         | "diez"
        20         | "veinte"
        30         | "treinta"
        40         | "cuarenta"
        50         | "cincuenta"
        60         | "sesenta"
        70         | "setenta"
        80         | "ochenta"
        90         | "noventa"

        21         | "veintiuno"
        37         | "treinta y siete"
        43         | "cuarenta y tres"
        58         | "cincuenta y ocho"
        69         | "sesenta y nueve"
        76         | "setenta y seis"
        82         | "ochenta y dos"
        95         | "noventa y cinco"

        100        | "cien"
        200        | "doscientos"
        300        | "trescientos"
        400        | "cuatrocientos"
        500        | "quinientos"
        600        | "seiscientos"
        700        | "setecientos"
        800        | "ochocientos"
        900        | "novecientos"

        111        | "ciento once"
        272        | "doscientos setenta y dos"
        387        | "trescientos ochenta y siete"
        448        | "cuatrocientos cuarenta y ocho"
        569        | "quinientos sesenta y nueve"
        625        | "seiscientos veinticinco"
        782        | "setecientos ochenta y dos"
        895        | "ochocientos noventa y cinco"
        999        | "novecientos noventa y nueve"

        1000       | "mil"
        1100       | "mil cien"
        1110       | "mil ciento diez"
        2000       | "dos mil"
        2100       | "dos mil cien"
        2110       | "dos mil ciento diez"
        3000       | "tres mil"
        4000       | "cuatro mil"
        5000       | "cinco mil"
        7634       | "siete mil seiscientos treinta y cuatro"

        11000      | "once mil"
        15000      | "quince mil"
        21000      | "veintiún mil"
        21500      | "veintiún mil quinientos"
        21537      | "veintiún mil quinientos treinta y siete"
        31000      | "treinta y un mil"
        24190      | "veinticuatro mil ciento noventa"
        653000     | "seiscientos cincuenta y tres mil"
        123454     | "ciento veintitrés mil cuatrocientos cincuenta y cuatro"
        700000     | "setecientos mil"
        999999     | "novecientos noventa y nueve mil novecientos noventa y nueve"

        //1000000    | "un millón"
        2000000    | "dos millones"
        5000000    | "cinco millones"
        23437219   | "veintitrés millones cuatrocientos treinta y siete mil doscientos diecinueve"
        100000000  | "cien millones"
        123456789  | "ciento veintitrés millones cuatrocientos cincuenta y seis mil setecientos ochenta y nueve"
        322089890  | "trescientos veintidós millones ochenta y nueve mil ochocientos noventa"

        //1000000000 | "mil millones"
        //2001001110 | "dos mil un millones mil ciento diez"
        //2001001100 | "dos mil un millones  mil cien"
        //2147483647 | "dos mil ciento cuarenta y siete millones cuatrocientos ochenta y tres mil seiscientos cuarenta y siete"
    }
}
