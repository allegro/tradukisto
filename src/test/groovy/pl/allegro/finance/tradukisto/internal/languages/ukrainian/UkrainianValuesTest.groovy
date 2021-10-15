package pl.allegro.finance.tradukisto.internal.languages.ukrainian

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.ukrainianContainer

class UkrainianValuesTest extends Specification {

    static intConverter = ukrainianContainer().getIntegerConverter()
    static longConverter = ukrainianContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Ukrainian"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value         | words
        0             | "нуль"
        1             | "один"
        2             | "два"
        3             | "три"
        4             | "чотири"
        5             | "п'ять"
        6             | "шість"
        7             | "сім"
        8             | "вісім"
        9             | "дев'ять"
        11            | "одинадцять"
        12            | "дванадцять"
        13            | "тринадцять"
        14            | "чотирнадцять"
        15            | "п'ятнадцять"
        16            | "шістнадцять"
        17            | "сімнадцять"
        18            | "вісімнадцять"
        19            | "дев'ятнадцять"
        10            | "десять"
        20            | "двадцять"
        30            | "тридцять"
        40            | "сорок"
        50            | "пятдесят"
        60            | "шістдесят"
        70            | "сімдесят"
        80            | "вісімдесят"
        90            | "дев'яносто"
        21            | "двадцять один"
        37            | "тридцять сім"


        43            | "сорок три"
        58            | "пятдесят вісім"
        69            | "шістдесят дев'ять"
        76            | "сімдесят шість"
        82            | "вісімдесят два"
        95            | "дев'яносто п'ять"
        100           | "сто"
        200           | "двісті"
        300           | "триста"
        400           | "чотириста"
        500           | "п'ятсот"
        600           | "шістсот"
        700           | "сімсот"
        800           | "вісімсот"
        900           | "дев'ятсот"
        111           | "сто одинадцять"
        272           | "двісті сімдесят два"
        387           | "триста вісімдесят сім"
        448           | "чотириста сорок вісім"
        569           | "п'ятсот шістдесят дев'ять"
        625           | "шістсот двадцять п'ять"
        782           | "сімсот вісімдесят два"
        895           | "вісімсот дев'яносто п'ять"
        999           | "дев'ятсот дев'яносто дев'ять"
        1_000         | "одна тисяча"
        2_000         | "дві тисячі"
        5_000         | "п'ять тисяч"
        7_634         | "сім тисяч шістсот тридцять чотири"
        21_000        | "двадцять одна тисяча"
        24_190        | "двадцять чотири тисячі сто дев'яносто"
        51_000        | "пятдесят одна тисяча"
        101_000       | "сто одна тисяча"
        481_000       | "чотириста вісімдесят одна тисяча"
        653_000       | "шістсот пятдесят три тисячі"
        123_454       | "сто двадцять три тисячі чотириста пятдесят чотири"
        700_000       | "сімсот тисяч"
        999_999       | "дев'ятсот дев'яносто дев'ять тисяч дев'ятсот дев'яносто дев'ять"
        1_000_000     | "один мільйон"
        2_000_000     | "два мільйони"
        5_000_000     | "п'ять мільйонів"
        23_437_219    | "двадцять три мільйони чотириста тридцять сім тисяч двісті дев'ятнадцять"
        100_000_000   | "сто мільйонів"
        123_456_789   | "сто двадцять три мільйони чотириста пятдесят шість тисяч сімсот вісімдесят дев'ять"
        1_000_000_000 | "один мільярд"
        2_147_483_647 | "два мільярди сто сорок сім мільйонів чотириста вісімдесят три тисячі шістсот сорок сім"
    }

    @Ignore("Needs Ukrainian long converter and values for trillion, quadrillion, quintillion")
    @Unroll
    def "should convert long #value to '#words' in Ukrainian"() {
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
