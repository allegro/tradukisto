package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.MoneyConverters.CZECH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.ENGLISH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.GERMAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.POLISH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.BRAZILIAN_PORTUGUESE_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.RUSSIAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.SPANISH_BANKING_MONEY_VALUE

class MoneyConvertersTest extends Specification {

    def "should convert money in Brazilian Portuguese"() {
        expect:
        BRAZILIAN_PORTUGUESE_BANKING_MONEY_VALUE.asWords(1_234.56) == "mil duzentos e trinta e quatro R\$ 56/100"
    }

    def "should convert money in German"() {
        expect:
        GERMAN_BANKING_MONEY_VALUE.asWords(1_234.56) == "eintausendzweihundertvierunddreißig € 56/100"
    }

    def "should convert money in Russian"() {
        expect:
        RUSSIAN_BANKING_MONEY_VALUE.asWords(1_234.56) == "одна тысяча двести тридцать четыре руб. 56/100"
    }

    def "should convert money in Polish"() {
        expect:
        POLISH_BANKING_MONEY_VALUE.asWords(1_234.56) == "jeden tysiąc dwieście trzydzieści cztery PLN 56/100"
    }

    def "should convert money in Czech"() {
        expect:
        CZECH_BANKING_MONEY_VALUE.asWords(1_234.56) == "jeden tisíc dvě stě třicet čtyři Kč 56/100"
    }

    def "should convert money in English"() {
        expect:
        ENGLISH_BANKING_MONEY_VALUE.asWords(1_234.56) == "one thousand two hundred thirty-four £ 56/100"
    }
    
    def "should convert money in Spanish"() {
        expect:
        SPANISH_BANKING_MONEY_VALUE.asWords(1_234.56) == "mil doscientos treinta y cuatro € 56/100"
    }

    def "should throw exception when null given"() {
        when:
        POLISH_BANKING_MONEY_VALUE.asWords(null)

        then:
        thrown(VerifyException)
    }
}
