package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification

class MoneyConvertersTest extends Specification {

    def converter = MoneyConverters.POLISH_BANKING_MONEY_VALUE

    def "should convert money in Polish"() {
        expect:
        converter.asWords(1_234.56) == "jeden tysiąc dwieście trzydzieści cztery PLN 56/100"
    }

    def "should throw exception when null given"() {
        when:
        converter.asWords(null)

        then:
        thrown(VerifyException)
    }
}
