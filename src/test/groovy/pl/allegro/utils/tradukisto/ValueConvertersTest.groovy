package pl.allegro.utils.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification

class ValueConvertersTest extends Specification {

    def converter = ValueConverters.POLISH_INTEGER

    def "should convert numbers in Polish"() {
        when:
        def words = converter.asWords(1_234)

        then:
        words == "jeden tysiąc dwieście trzydzieści cztery"
    }

    def "should throw exception when null given"() {
        when:
        converter.asWords(null)

        then:
        thrown(VerifyException)
    }
}
