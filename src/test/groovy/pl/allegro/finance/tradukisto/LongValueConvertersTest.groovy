package pl.allegro.finance.tradukisto

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.LongValueConverters.ENGLISH_LONG
import static pl.allegro.finance.tradukisto.LongValueConverters.HINDI_LONG
import static pl.allegro.finance.tradukisto.LongValueConverters.POLISH_LONG
import static pl.allegro.finance.tradukisto.LongValueConverters.SWEDISH_LONG

class LongValueConvertersTest extends Specification {

    @Unroll
    def "should convert numbers in #language"() {
        expect:
        converter.asWords(1_000_000_000_000_000_000) == number

        where:
        language  | converter    || number
        "English" | ENGLISH_LONG || "one quintillion"
        "Polish"  | POLISH_LONG  || "jeden trylion"
        "Hindi"   | HINDI_LONG   || "दस शंख"
        "Swedish" | SWEDISH_LONG || "en triljon"
    }

    def "should throw exception when null given"() {
        when:
        converter.asWords(null)

        then:
        thrown(NullPointerException)

        where:
        converter << ValueConverters.values()
    }

}
