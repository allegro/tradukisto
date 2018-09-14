package pl.allegro.finance.tradukisto.internal.languages.italian

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.italianContainer

class ItalianValuesTest extends Specification {

    static converter = italianContainer().getNumbersConverter()

    @Unroll
    def "should convert #value to '#words' in Italian"() {
        expect:
        converter.asWords(value) == words

        where:
        value      | words
        0          | "zero"
        1          | "uno"
        2          | "due"
        3          | "tre"
        4          | "quattro"
        5          | "cinque"
        6          | "sei"
        7          | "sette"
        8          | "otto"
        9          | "nove"

        11         | "undici"
        12         | "dodici"
        13         | "tredici"
        14         | "quattordici"
        15         | "quindici"
        16         | "sedici"
        17         | "diciassette"
        18         | "diciotto"
        19         | "diciannove"

        10         | "dieci"
        20         | "venti"
        30         | "trenta"
        40         | "quaranta"
        50         | "cinquanta"
        60         | "sessanta"
        70         | "settanta"
        80         | "ottanta"
        90         | "novanta"

        21         | "ventuno"
        37         | "trentasette"
        43         | "quarantatre"
        58         | "cinquantotto"
        69         | "sessantanove"
        76         | "settantasei"
        82         | "ottantadue"
        95         | "novantacinque"

        100        | "cento"
        200        | "duecento"
        300        | "trecento"
        400        | "quattrocento"
        500        | "cinquecento"
        600        | "seicento"
        700        | "settecento"
        800        | "ottocento"
        900        | "novecento"

        111        | "centoundici"
        272        | "duecentosettantadue"
        387        | "trecentoottantasette"
        448        | "quattrocentoquarantotto"
        569        | "cinquecentosessantanove"
        625        | "seicentoventicinque"
        782        | "settecentoottantadue"
        895        | "ottocentonovantacinque"
        999        | "novecentonovantanove"

        1000       | "mille"
        2000       | "duemila"
        3000       | "tremila"
        4000       | "quattromila"
        5000       | "cinquemila"
        7634       | "settemilaseicentotrentaquattro"

        11000      | "undicimila"
        15000      | "quindicimila"
        21000      | "ventunomila"
        24190      | "ventiquattromilacentonovanta"
        653000     | "seicentocinquantatremila"
        123454     | "centoventitremilaquattrocentocinquantaquattro"
        700000     | "settecentomila"
        999999     | "novecentonovantanovemilanovecentonovantanove"

        1000000    | "unmilione"
        2000000    | "duemilioni"
        5000000    | "cinquemilioni"
        23437219   | "ventitremilioniquattrocentotrentasettemiladuecentodiciannove"
        100000000  | "centomilioni"
        123456789  | "centoventitremilioniquattrocentocinquantaseimilasettecentoottantanove"
        322089890  | "trecentoventiduemilioniottantanovemilaottocentonovanta"

        1000000000 | "unmiliardo"
        2147483647 | "duemiliardicentoquarantasettemilioniquattrocentoottantatremilaseicentoquarantasette"
    }
}
