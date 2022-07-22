package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.ValueConverters.*

class ValueConvertersTest extends Specification {

    def "should convert numbers in Brazilian Portuguese"() {
        expect:
        BRAZILIAN_PORTUGUESE_INTEGER.asWords(1_234) == "mil duzentos e trinta e quatro"
    }

    def "should convert numbers in English"() {
        expect:
        ENGLISH_INTEGER.asWords(1_234) == "one thousand two hundred thirty-four"
    }

    def "should convert numbers in German"() {
        expect:
        GERMAN_INTEGER.asWords(1_234) == "eintausendzweihundertvierunddreißig"
    }

    def "should convert numbers in Russian"() {
        expect:
        RUSSIAN_INTEGER.asWords(1_234) == "одна тысяча двести тридцать четыре"
    }

    def "should convert numbers in Bulgarian"() {
        expect:
        BULGARIAN_INTEGER.asWords(1_234) == "хиляда двеста тридесет четири"
    }

    def "should convert numbers in Italian"() {
        expect:
        ITALIAN_INTEGER.asWords(1_234) == "milleduecentotrentaquattro"
    }

    def "should convert numbers in Polish"() {
        expect:
        POLISH_INTEGER.asWords(1_234) == "jeden tysiąc dwieście trzydzieści cztery"
    }

    def "should convert numbers in Czech"() {
        expect:
        CZECH_INTEGER.asWords(1_234) == "jeden tisíc dvě stě třicet čtyři"
    }

    def "should convert numbers in Slovak"() {
        expect:
        SLOVAK_INTEGER.asWords(1_234) == "jeden tisíc dvesto tridsať štyri"
    }

    def "should convert numbers in Latvian"() {
        expect:
        LATVIAN_INTEGER.asWords(1_234) == "viens tūkstotis divi simti trīsdesmit četri"
    }

    def "should convert numbers in Kazakh"() {
        expect:
        KAZAKH_INTEGER.asWords(1_234) == "бір мың екі жүз отыз төрт"
    }

    def "should convert numbers in Ukrainian"() {
        expect:
        UKRAINIAN_INTEGER.asWords(1_234) == "одна тисяча двісті тридцять чотири"
    }

    def "should convert numbers in Serbian"() {
        expect:
        SERBIAN_INTEGER.asWords(1_234) == "jedna hiljada dvesta trideset četiri"
    }

    def "should convert numbers in Serbian Cyrillic"() {
        expect:
        SERBIAN_CYRILLIC_INTEGER.asWords(1_234) == "једна хиљада двеста тридесет четири"
    }

    def "should convert numbers in French"() {
        expect:
        FRENCH_INTEGER.asWords(1_234) == "mille deux cent trente-quatre"
    }

    def "should convert numbers in Turkish"() {
        expect:
        TURKISH_INTEGER.asWords(1_234) == "Bin İki Yüz Otuz Dört"
    }

    def "should throw exception when null given"() {
        when:
        POLISH_INTEGER.asWords(null)

        then:
        thrown(VerifyException)
    }

    def "getByLocaleOrDefault for Brazilian Portuguese"() {
        expect:
        getByLocaleOrDefault(new Locale("pt-br"), null).asWords(1_234) == "mil duzentos e trinta e quatro"
    }

    def "getByLocaleOrDefault for Portuguese"() {
        expect:
        getByLocaleOrDefault(new Locale("pt"), null).asWords(1_234) == "mil duzentos e trinta e quatro"
    }

    def "getByLocaleOrDefault for English"() {
        expect:
        getByLocaleOrDefault(Locale.ENGLISH, null).asWords(1_234) == "one thousand two hundred thirty-four"
    }

    def "getByLocaleOrDefault for German"() {
        expect:
        getByLocaleOrDefault(new Locale("de"), null).asWords(1_234) == "eintausendzweihundertvierunddreißig"
    }

    def "getByLocaleOrDefault for Russian"() {
        expect:
        getByLocaleOrDefault(new Locale("ru"), null).asWords(1_234) == "одна тысяча двести тридцать четыре"
    }

    def "getByLocaleOrDefault for Bulgarian"() {
        expect:
        getByLocaleOrDefault(new Locale("bg"), null).asWords(1_234) == "хиляда двеста тридесет четири"
    }

    def "getByLocaleOrDefault for Italian"() {
        expect:
        getByLocaleOrDefault(new Locale("it"), null).asWords(1_234) == "milleduecentotrentaquattro"
    }

    def "getByLocaleOrDefault for Polish"() {
        expect:
        getByLocaleOrDefault(new Locale("pl"), null).asWords(1_234) == "jeden tysiąc dwieście trzydzieści cztery"
    }

    def "getByLocaleOrDefault for Czech"() {
        expect:
        getByLocaleOrDefault(new Locale("cs"), null).asWords(1_234) == "jeden tisíc dvě stě třicet čtyři"
    }

    def "getByLocaleOrDefault for Slovak"() {
        expect:
        getByLocaleOrDefault(new Locale("sk"), null).asWords(1_234) == "jeden tisíc dvesto tridsať štyri"
    }

    def "getByLocaleOrDefault for Latvian"() {
        expect:
        getByLocaleOrDefault(new Locale("lv"), null).asWords(1_234) == "viens tūkstotis divi simti trīsdesmit četri"
    }

    def "getByLocaleOrDefault for Kazakh"() {
        expect:
        getByLocaleOrDefault(new Locale("kk"), null).asWords(1_234) == "бір мың екі жүз отыз төрт"
    }

    def "getByLocaleOrDefault for Ukrainian"() {
        expect:
        getByLocaleOrDefault(new Locale("uk"), null).asWords(1_234) == "одна тисяча двісті тридцять чотири"
    }

    def "getByLocaleOrDefault for Serbian"() {
        expect:
        getByLocaleOrDefault(new Locale("sr"), null).asWords(1_234) == "jedna hiljada dvesta trideset četiri"
    }

    def "getByLocaleOrDefault for Serbian Latin"() {
        expect:
        getByLocaleOrDefault(new Locale.Builder().setLanguage("sr").setScript("Latn").build(), null).asWords(1_234) == "jedna hiljada dvesta trideset četiri"
    }

    def "getByLocaleOrDefault for Serbian Cyrillic"() {
        expect:
        getByLocaleOrDefault(new Locale.Builder().setLanguage("sr").setScript("Cyrl").build(), null).asWords(1_234) == "једна хиљада двеста тридесет четири"
    }

    def "getByLocaleOrDefault for French"() {
        expect:
        getByLocaleOrDefault(Locale.FRENCH, null).asWords(1_234) == "mille deux cent trente-quatre"
    }

    def "getByLocaleOrDefault for Turkish"() {
        expect:
        getByLocaleOrDefault(new Locale("tr"), null).asWords(1_234) == "Bin İki Yüz Otuz Dört"
    }

    def "getByLocaleOrDefault: should throw exception when null given"() {
        when:
        getByLocaleOrDefault(null, null).asWords(null)

        then:
        thrown(VerifyException)
    }

    def "getByLanguageCodeOrDefault: should throw exception when null language code given"() {
        when:
        getByLanguageCodeOrDefault(null, null).asWords(null)

        then:
        thrown(VerifyException)
    }

    def "getByLocaleOrDefault: should throw exception when empty language code given"() {
        when:
        getByLocaleOrDefault(new Locale(""), null).asWords(null)

        then:
        thrown(VerifyException)
    }

    def "getByLocaleOrDefault: test for default converter"() {
        expect:
        getByLocaleOrDefault(new Locale("zh"), FRENCH_INTEGER) == FRENCH_INTEGER
    }

}
