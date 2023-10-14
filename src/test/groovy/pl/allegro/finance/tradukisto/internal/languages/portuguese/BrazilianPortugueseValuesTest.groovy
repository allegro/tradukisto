package pl.allegro.finance.tradukisto.internal.languages.portuguese

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.brazilianPortugueseContainer

class BrazilianPortugueseValuesTest extends Specification {

    static intConverter = brazilianPortugueseContainer().getIntegerConverter()
    static longConverter = brazilianPortugueseContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Brazilian Portuguese"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value      | words
        0          | "zero"
        1          | "um"
        2          | "dois"
        3          | "três"
        4          | "quatro"
        5          | "cinco"
        6          | "seis"
        7          | "sete"
        8          | "oito"
        9          | "nove"

        11         | "onze"
        12         | "doze"
        13         | "treze"
        14         | "catorze"
        15         | "quinze"
        16         | "dezesseis"
        17         | "dezessete"
        18         | "dezoito"
        19         | "dezenove"

        10         | "dez"
        20         | "vinte"
        30         | "trinta"
        40         | "quarenta"
        50         | "cinquenta"
        60         | "sessenta"
        70         | "setenta"
        80         | "oitenta"
        90         | "noventa"

        21         | "vinte e um"
        37         | "trinta e sete"
        43         | "quarenta e três"
        58         | "cinquenta e oito"
        69         | "sessenta e nove"
        76         | "setenta e seis"
        82         | "oitenta e dois"
        95         | "noventa e cinco"

        100        | "cem"
        200        | "duzentos"
        300        | "trezentos"
        400        | "quatrocentos"
        500        | "quinhentos"
        600        | "seiscentos"
        700        | "setecentos"
        800        | "oitocentos"
        900        | "novecentos"

        111        | "cento e onze"
        272        | "duzentos e setenta e dois"
        387        | "trezentos e oitenta e sete"
        448        | "quatrocentos e quarenta e oito"
        569        | "quinhentos e sessenta e nove"
        625        | "seiscentos e vinte e cinco"
        782        | "setecentos e oitenta e dois"
        895        | "oitocentos e noventa e cinco"
        999        | "novecentos e noventa e nove"

        1000       | "mil"
        1100       | "mil e cem"
        1110       | "mil cento e dez"
        2000       | "dois mil"
        2100       | "dois mil e cem"
        2110       | "dois mil cento e dez"
        3000       | "três mil"
        4000       | "quatro mil"
        5000       | "cinco mil"
        7634       | "sete mil seiscentos e trinta e quatro"

        11000      | "onze mil"
        15000      | "quinze mil"
        21000      | "vinte e um mil"
        24190      | "vinte e quatro mil cento e noventa"
        653000     | "seiscentos e cinquenta e três mil"
        123454     | "cento e vinte e três mil quatrocentos e cinquenta e quatro"
        700000     | "setecentos mil"
        999999     | "novecentos e noventa e nove mil novecentos e noventa e nove"

        1000000    | "um milhão"
        2000000    | "dois milhões"
        5000000    | "cinco milhões"
        23437219   | "vinte e três milhões quatrocentos e trinta e sete mil duzentos e dezenove"
        100000000  | "cem milhões"
        123456789  | "cento e vinte e três milhões quatrocentos e cinquenta e seis mil setecentos e oitenta e nove"
        322089890  | "trezentos e vinte e dois milhões oitenta e nove mil oitocentos e noventa"

        1000000000 | "um bilhão"
        2001001110 | "dois bilhões um milhão mil cento e dez"
        2001001100 | "dois bilhões um milhão mil e cem"
        2147483647 | "dois bilhões cento e quarenta e sete milhões quatrocentos e oitenta e três mil seiscentos e quarenta e sete"
    }

    @Ignore("Needs Brazilian Portuguese long converter and values for trillion, quadrillion, quintillion")
    @Unroll
    def "should convert long #value to '#words' in Brazilian Portuguese"() {
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
