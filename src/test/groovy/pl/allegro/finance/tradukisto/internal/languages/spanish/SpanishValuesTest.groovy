package pl.allegro.finance.tradukisto.internal.languages.spanish

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.englishContainer
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
        16         | "dieciseis"
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

        1_000       | "mil"
        2_000       | "dos mil"
        3_000       | "tres mil"
        4_000       | "cuatro mil"
        5_000       | "cinco mil"
        7_634       | "siete mil seiscientos treinta y cuatro"

        11_000      | "once mil"
        15_000      | "quince mil"
        21_000      | "veintiún mil"
        24_190      | "veinticuatro mil ciento noventa"

        653_000     | "seiscientos cincuenta y tres mil"
        123_454     | "ciento veintitres mil cuatrocientos cincuenta y cuatro"
        700_000     | "setecientos mil"
        999_999     | "novecientos noventa y nueve mil novecientos noventa y nueve"

        1_000_000    | "un millón"
        2_000_000    | "dos millones"
        5_000_000    | "cinco millones"
        23_437_219   | "veintitres millones cuatrocientos treinta y siete mil doscientos diecinueve"
        100_000_000  | "cien millones"
        123_456_789  | "ciento veintitres millones cuatrocientos cincuenta y seis mil setecientos ochenta y nueve"
        322_089_890  | "trescientos veintidos millones ochenta y nueve mil ochocientos noventa"

        1_000_000_000 | "mil millones"
        2_147_483_647 | "dos mil ciento cuarenta y siete millones cuatrocientos ochenta y tres mil seiscientos cuarenta y siete"
    }

    def "should convert any value in range of 0-999 in Czech"() {
        when:
        def words = converter.asWords(value)

        then:
        notThrown(IllegalArgumentException)
        words.length() > 0

        where:
        value << (0..999)
    }
}
