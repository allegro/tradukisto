package pl.allegro.utils.tradukisto.internal.languages.polish;

import spock.lang.Specification

import static pl.allegro.utils.tradukisto.internal.languages.polish.PolishContainer.polishContainer

class BigDecimalToPolishBankingMoneyValueConverterTest extends Specification {

    def static MAX_SUPPORTED_VALUE = new BigDecimal(Integer.MAX_VALUE) + 0.99

    def converter = polishContainer().getBankingMoneyConverter()

    def "should convert money in Polish"() {
        expect:
        converter.asWords(value) == words

        where:
        value               | words
        0                   | "zero PLN 00/100"
        0.01                | "zero PLN 01/100"
        0.5                 | "zero PLN 50/100"
        0.50                | "zero PLN 50/100"
        20                  | "dwadzieścia PLN 00/100"
        1.1                 | "jeden PLN 10/100"
        123.01              | "sto dwadzieścia trzy PLN 01/100"
        1_234.56            | "jeden tysiąc dwieście trzydzieści cztery PLN 56/100"
        5_012_519.01        | "pięć milionów dwanaście tysięcy pięćset dziewiętnaście PLN 01/100"
        MAX_SUPPORTED_VALUE | "dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące " +
                "sześćset czterdzieści siedem PLN 99/100"
    }

    def "should not support thousandths part of value"() {
        when:
        converter.asWords(1_234.567)

        then:
        thrown(IllegalArgumentException)
    }

    def "should not support values out of range of integer type"() {
        when:
        converter.asWords(outOfRangeValue)

        then:
        thrown(IllegalArgumentException)

        where:
        outOfRangeValue << [-1, new BigDecimal(Integer.MAX_VALUE) + 1, new BigDecimal(Integer.MAX_VALUE) * 2 + 10]
    }
}
