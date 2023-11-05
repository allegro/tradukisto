package pl.allegro.finance.tradukisto.internal.languages.japanese

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.japaneseContainer

class JapaneseValuesTest extends Specification {

    static intConverter = japaneseContainer().getIntegerConverter()
    static longConverter = japaneseContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Japanese"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value       | words
        0             | "零"
        1             | "一"
        2             | "二"
        3             | "三"
        4             | "四"
        5             | "五"
        6             | "六"
        7             | "七"
        8             | "八"
        9             | "九"

        11            | "十一"
        12            | "十二"
        13            | "十三"
        14            | "十四"
        15            | "十五"
        16            | "十六"
        17            | "十七"
        18            | "十八"
        19            | "十九"

        10            | "十"
        20            | "二十"
        30            | "三十"
        40            | "四十"
        50            | "五十"
        60            | "六十"
        70            | "七十"
        80            | "八十"
        90            | "九十"

        21            | "二十一"
        37            | "三十七"
        43            | "四十三"
        58            | "五十八"
        69            | "六十九"
        76            | "七十六"
        82            | "八十二"
        95            | "九十五"

        100           | "百"
        200           | "二百"
        300           | "三百"
        400           | "四百"
        500           | "五百"
        600           | "六百"
        700           | "七百"
        800           | "八百"
        900           | "九百"

        111           | "百十一"
        272           | "二百七十二"
        387           | "三百八十七"
        448           | "四百四十八"
        569           | "五百六十九"
        625           | "六百二十五"
        782           | "七百八十二"
        895           | "八百九十五"
        999           | "九百九十九"

        1_000         | "千"
        2_000         | "二千"
        3_000         | "三千"
        4_000         | "四千"
        5_000         | "五千"
        7_634         | "七千六百三十四"
        11_000        | "一万千"
        15_000        | "一万五千"
        21_000        | "二万千"
        24_190        | "二万四千百九十"
        653_000       | "六十五万三千"
        123_454       | "十二万三千四百五十四"
        700_000       | "七十万"
        999_999       | "九十九万九千九百九十九"

        1_000_000     | "百万"
        2_000_000     | "二百万"
        5_000_000     | "五百万"
        23_437_219    | "二千三百四十三万七千二百十九"
        100_000_000   | "一億"
        123_456_789   | "一億二千三百四十五万六千七百八十九"
        322_089_890   | "三億二千二百八万九千八百九十"

        1_000_000_000 | "十億"
        2_147_483_647 | "二十一億四千七百四十八万三千六百四十七"
    }

    @Unroll
    def "should convert long #value to '#words' in Japanese"() {
        expect:
        longConverter.asWords(value) == words

        where:
        value                     | words
        5_000_000_000             | "五十億"

        1_000_000_000_000         | "一兆"
        2_000_000_000_000         | "二兆"
        5_000_000_000_000         | "五兆"

        1_000_000_000_000_000     | "千兆"
        2_000_000_000_000_000     | "二千兆"
        5_000_000_000_000_000     | "五千兆"

        1_000_000_000_000_000_000 | "百京"
        2_000_000_000_000_000_000 | "二百京"
        Long.MAX_VALUE            | "九百二十二京三千三百七十二兆三百六十八億五千四百七十七万五千八百七"
    }
}