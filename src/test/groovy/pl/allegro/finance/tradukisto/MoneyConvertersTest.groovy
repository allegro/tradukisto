package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.MoneyConverters.*

class MoneyConvertersTest extends Specification {

    def "should convert money in Brazilian Portuguese"() {
        expect:
        BRAZILIAN_PORTUGUESE_BANKING_MONEY_VALUE.asWords(1_234.56) == "mil duzentos e trinta e quatro R\$ 56/100"
    }

    def "should convert money in German"() {
        expect:
        GERMAN_BANKING_MONEY_VALUE.asWords(1_234.56) == "eintausendzweihundertvierunddreißig € 56/100"
    }

    def "should convert money in Italian"() {
        expect:
        ITALIAN_BANKING_MONEY_VALUE.asWords(1_234.56) == "milleduecentotrentaquattro € 56/100"
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

    def "should convert money in Slovak"() {
        expect:
        SLOVAK_BANKING_MONEY_VALUE.asWords(1_234.56) == "jeden tisíc dvesto tridsať štyri € 56/100"
    }

    def "should convert money in Latvain"() {
        expect:
        LATVIAN_BANKING_MONEY_VALUE.asWords(1_234.56) == "viens tūkstotis divi simti trīsdesmit četri EUR 56/100"
    }

    def "should convert money in English"() {
        expect:
        ENGLISH_BANKING_MONEY_VALUE.asWords(1_234.56) == "one thousand two hundred thirty-four £ 56/100"
    }

    def "should convert money in Kazakh"() {
        expect:
        KAZAKH_BANKING_MONEY_VALUE.asWords(1_234.56) == "бір мың екі жүз отыз төрт KZT 56/100"
    }

    def "should convert money in Ukrainian"() {
        expect:
        UKRAINIAN_BANKING_MONEY_VALUE.asWords(1_234.56) == "одна тисяча двісті тридцять чотири ₴ 56/100"
    }

    def "should convert money in Serbian"() {
        expect:
        SERBIAN_BANKING_MONEY_VALUE.asWords(1_234.56) == "jedna hiljada dvesta trideset četiri RSD 56/100"
    }

    def "should convert numbers in French"() {
        expect:
        FRENCH_BANKING_MONEY_VALUE.asWords(1_234.56) == "mille deux cent trente-quatre € 56/100"
    }

    def "should throw exception when null given"() {
        when:
        POLISH_BANKING_MONEY_VALUE.asWords(null)

        then:
        thrown(VerifyException)
    }

    def "should convert money in Turkish"() {
        expect:
        TURKISH_BANKING_MONEY_VALUE.asWords(1_23.4) == "YüzYirmiÜçTL,KırkKr."
    }
}
