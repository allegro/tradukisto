package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.MoneyConverters.CZECH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.ENGLISH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.POLISH_BANKING_MONEY_VALUE

class MoneyConvertersTest extends Specification {

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

    def "should throw exception when null given"() {
        when:
        POLISH_BANKING_MONEY_VALUE.asWords(null)

        then:
        thrown(VerifyException)
    }
}
