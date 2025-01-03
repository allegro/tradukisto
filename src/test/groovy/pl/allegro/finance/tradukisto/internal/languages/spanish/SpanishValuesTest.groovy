package pl.allegro.finance.tradukisto.internal.languages.spanish

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.spanishContainer

class SpanishValuesTest extends Specification {
    static moneyConverter = spanishContainer().getBankingMoneyConverter()
    

    @Unroll
    def "should convert money #value to '#words' in Spanish"() {
        expect:
        moneyConverter.asWords(value, "€") == words

        where:
        value   | words
        51      | "cincuenta y un € 00/100"
        111.12  | "ciento once € 12/100"
        112.12  | "ciento doce € 12/100"
        123.29  | "ciento veintitrés € 29/100"
        154.63  | "ciento cincuenta y cuatro € 63/100"
        415.51  | "cuatrocientos quince € 51/100"
        426.83  | "cuatrocientos veintiséis € 83/100"
        447.60  | "cuatrocientos cuarenta y siete € 60/100"
        1298    | "mil doscientos noventa y ocho € 00/100"
        1299     | "mil doscientos noventa y nueve € 00/100"
        1111111.11    | "un millón ciento once mil ciento once € 11/100"
    }
}
