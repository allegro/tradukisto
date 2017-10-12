package pl.allegro.finance.tradukisto.internal.languages.german

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.germanContainer

class GermanValuesTest extends Specification {

    static converter = germanContainer().getNumbersConverter()

    @Unroll
    def "should convert #value to '#words' in German"() {
        expect:
        converter.asWords(value) == words

        where:
        value      | words
        0          | "null"
        1          | "eins"
        2          | "zwei"
        3          | "drei"
        4          | "vier"
        5          | "fünf"
        6          | "sechs"
        7          | "sieben"
        8          | "acht"
        9          | "neun"

        11         | "elf"
        12         | "zwölf"
        13         | "dreizehn"
        14         | "vierzehn"
        15         | "fünfzehn"
        16         | "sechzehn"
        17         | "siebzehn"
        18         | "achtzehn"
        19         | "neunzehn"

        10         | "zehn"
        20         | "zwanzig"
        30         | "dreißig"
        40         | "vierzig"
        50         | "fünfzig"
        60         | "sechzig"
        70         | "siebzig"
        80         | "achtzig"
        90         | "neunzig"

        21         | "einundzwanzig"
        37         | "siebenunddreißig"
        43         | "dreiundvierzig"
        58         | "achtundfünfzig"
        69         | "neunundsechzig"
        76         | "sechsundsiebzig"
        82         | "zweiundachtzig"
        95         | "fünfundneunzig"

        100        | "einhundert"
        200        | "zweihundert"
        300        | "dreihundert"
        400        | "vierhundert"
        500        | "fünfhundert"
        600        | "sechshundert"
        700        | "siebenhundert"
        800        | "achthundert"
        900        | "neunhundert"

        111        | "einhundertelf"
        272        | "zweihundertzweiundsiebzig"
        387        | "dreihundertsiebenundachtzig"
        448        | "vierhundertachtundvierzig"
        569        | "fünfhundertneunundsechzig"
        625        | "sechshundertfünfundzwanzig"
        782        | "siebenhundertzweiundachtzig"
        895        | "achthundertfünfundneunzig"
        999        | "neunhundertneunundneunzig"

        1000       | "eintausend"
        2000       | "zweitausend"
        3000       | "dreitausend"
        4000       | "viertausend"
        5000       | "fünftausend"
        7634       | "siebentausendsechshundertvierunddreißig"

        11000      | "elftausend"
        15000      | "fünfzehntausend"
        21000      | "einundzwanzigtausend"
        24190      | "vierundzwanzigtausendeinhundertneunzig"
        653000     | "sechshundertdreiundfünfzigtausend"
        123454     | "einhundertdreiundzwanzigtausendvierhundertvierundfünfzig"
        700000     | "siebenhunderttausend"
        999999     | "neunhundertneunundneunzigtausendneunhundertneunundneunzig"

        1000000    | "eine Million"
        2000000    | "zwei Millionen"
        5000000    | "fünf Millionen"
        23437219   | "dreiundzwanzig Millionen vierhundertsiebenunddreißigtausendzweihundertneunzehn"
        100000000  | "einhundert Millionen"
        123456789  | "einhundertdreiundzwanzig Millionen vierhundertsechsundfünfzigtausendsiebenhundertneunundachtzig"
        322089890  | "dreihundertzweiundzwanzig Millionen neunundachtzigtausendachthundertneunzig"

        1000000000 | "eine Milliarde"
        2147483647 | "zwei Milliarden einhundertsiebenundvierzig Millionen vierhundertdreiundachtzigtausendsechshundertsiebenundvierzig"
    }
}
