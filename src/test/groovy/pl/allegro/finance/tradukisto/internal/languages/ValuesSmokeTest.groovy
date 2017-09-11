package pl.allegro.finance.tradukisto.internal.languages

import pl.allegro.finance.tradukisto.ValueConverters
import spock.lang.Specification
import spock.lang.Unroll

class ValuesSmokeTest extends Specification {

    @Unroll
    def "should convert any value in range of 0-999 using #converter converter"() {
        expect:
        (0..999).each {
            assert converter.asWords(it).length() > 0
        }

        where:
        converter << ValueConverters.values()
    }
}
