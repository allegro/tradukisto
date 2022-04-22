package pl.allegro.finance.tradukisto.internal.languages.french

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.frenchContainer

class FrenchValuesTest extends Specification {

    static converter = frenchContainer().getNumbersConverter()

    @Unroll
    def "should convert #value to '#words' in French"() {
        expect:
        converter.asWords(value) == words

        where:
        value         | words
        0             | "zéro"
        1             | "un"
        2             | "deux"
        3             | "trois"
        4             | "quatre"
        5             | "cinq"
        6             | "six"
        7             | "sept"
        8             | "huit"
        9             | "neuf"

        11            | "onze"
        12            | "douze"
        13            | "treize"
        14            | "quatorze"
        15            | "quinze"
        16            | "seize"
        17            | "dix-sept"
        18            | "dix-huit"
        19            | "dix-neuf"

        10            | "dix"
        20            | "vingt"
        30            | "trente"
        40            | "quarante"
        50            | "cinquante"
        60            | "soixante"
        70            | "soixante-dix"
        80            | "quatre-vingts"
        90            | "quatre-vingt-dix"

        21            | "vingt-et-un"
        22            | "vingt-deux"
        31            | "trente-et-un"
        32            | "trente-deux"
        37            | "trente-sept"
        41            | "quarante-et-un"
        43            | "quarante-trois"
        51            | "cinquante-et-un"
        58            | "cinquante-huit"
        61            | "soixante-et-un"
        69            | "soixante-neuf"
        76            | "soixante-seize"
        82            | "quatre-vingt-deux"
        95            | "quatre-vingt-quinze"

        100           | "cent"
        200           | "deux cents"
        300           | "trois cents"
        400           | "quatre cents"
        500           | "cinq cents"
        600           | "six cents"
        700           | "sept cents"
        800           | "huit cents"
        900           | "neuf cents"

        111           | "cent onze"
        272           | "deux cent soixante-douze"
        387           | "trois cent quatre-vingt-sept"
        448           | "quatre cent quarante-huit"
        569           | "cinq cent soixante-neuf"
        625           | "six cent vingt-cinq"
        782           | "sept cent quatre-vingt-deux"
        895           | "huit cent quatre-vingt-quinze"
        999           | "neuf cent quatre-vingt-dix-neuf"

        1_000         | "mille"
        2_000         | "deux mille"
        3_000         | "trois mille"
        4_000         | "quatre mille"
        5_000         | "cinq mille"
        7_634         | "sept mille six cent trente-quatre"
        11_000        | "onze mille"
        15_000        | "quinze mille"
        21_000        | "vingt-et-un mille"
        24_190        | "vingt-quatre mille cent quatre-vingt-dix"
        653_000       | "six cent cinquante-trois mille"
        123_454       | "cent vingt-trois mille quatre cent cinquante-quatre"
        700_000       | "sept cent mille"
        999_999       | "neuf cent quatre-vingt-dix-neuf mille neuf cent quatre-vingt-dix-neuf"

        1_000_000     | "un million"
        2_000_000     | "deux millions"
        5_000_000     | "cinq millions"
        23_437_219    | "vingt-trois millions quatre cent trente-sept mille deux cent dix-neuf"
        100_000_000   | "cent millions"
        123_456_789   | "cent vingt-trois millions quatre cent cinquante-six mille sept cent quatre-vingt-neuf"
        322_089_890   | "trois cent vingt-deux millions quatre-vingt-neuf mille huit cent quatre-vingt-dix"

        1_000_000_000 | "un milliard"
        2_147_483_647 | "deux milliards cent quarante-sept millions quatre cent quatre-vingt-trois mille six cent " +
                "quarante-sept" 
    }
}
