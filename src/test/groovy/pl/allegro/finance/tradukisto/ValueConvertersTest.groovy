package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.ValueConverters.CZECH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.ENGLISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.GERMAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.BRAZILIAN_PORTUGUESE_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.POLISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.RUSSIAN_INTEGER

class ValueConvertersTest extends Specification {

    def "should convert numbers in Brazilian Portuguese"() {
        expect:
        BRAZILIAN_PORTUGUESE_INTEGER.asWords(1_234) == "mil duzentos e trinta e quatro"
    }	

    def "should convert numbers in German"() {
        expect:
        GERMAN_INTEGER.asWords(1_234) == "eintausendzweihundertvierunddreißig"
    }

    def "should convert numbers in Russian"() {
        expect:
        RUSSIAN_INTEGER.asWords(1_234) == "одна тысяча двести тридцать четыре"
    }

    def "should convert numbers in Polish"() {
        expect:
        POLISH_INTEGER.asWords(1_234) == "jeden tysiąc dwieście trzydzieści cztery"
    }

    def "should convert numbers in Czech"() {
        expect:
        CZECH_INTEGER.asWords(1_234) == "jeden tisíc dvě stě třicet čtyři"
    }

    def "should convert numbers in English"() {
        expect:
        ENGLISH_INTEGER.asWords(1_234) == "one thousand two hundred thirty-four"
    }

    def "should throw exception when null given"() {
        when:
        POLISH_INTEGER.asWords(null)

        then:
        thrown(VerifyException)
    }
}
