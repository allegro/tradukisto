package pl.allegro.finance.tradukisto.internal.languages.japanese

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.japaneseKanjiContainer

class JapaneseKanjiValuesTest extends Specification {

    static intConverter = japaneseKanjiContainer().getIntegerConverter()
    static longConverter = japaneseKanjiContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Japanese"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value | words
        0     | "例"
        1     | "一"
        2     | "二"
        3     | "三"
        4     | "四"
        5     | "五"
        6     | "六"
        7     | "七"
        8     | "八"
        9     | "九"
        10    | "十"
        11    | "十一"
        12    | "十二"
        13    | "十三"
        14    | "十四"
        15    | "十五"
        16    | "十六"
        17    | "十七"
        18    | "十八"
        19    | "十九"
        20    | "二十"
        27    | "二十七"
        30    | "三十"
        35    | "三十五"
        40    | "四十"
        43    | "四十三"
        50    | "五十"
        59    | "五十九"
        60    | "六十"
        61    | "六十一"
        70    | "七十"
        72    | "七十二"
        80    | "八十"
        86    | "八十六"
        90    | "九十"
        94    | "九十四"
        100   | "百"
        161   | "百六十一"
        200   | "二百"
        294   | "二百九十四"
        372   | "三百七十二"
        400   | "四百"
        459   | "四百五十九"
        500   | "五百"
        527   | "五百二十七"
        600   | "六百"
        611   | "六百十一"
        700   | "七百"
        735   | "七百三十五"
        800   | "八百"
        808   | "八百八"
        900   | "九百"
        999   | "九百九十九"
    }

    @Unroll
    def "should convert long #value to '#words' in Japanese"() {
        expect:
        longConverter.asWords(value) == words

        where:
        value     | words
        1000      | "千"
        10000     | "万"
        100000000 | "億"
        1467      | "千四百六十七"
    }
}
