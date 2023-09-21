package pl.allegro.finance.tradukisto

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.ValueConverters.BRAZILIAN_PORTUGUESE_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.BULGARIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.CZECH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.ENGLISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.FRENCH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.GERMAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.HINDI_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.ITALIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.KAZAKH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.LATVIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.POLISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.RUSSIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.SERBIAN_CYRILLIC_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.SERBIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.SLOVAK_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.SLOVENE_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.TURKISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.UKRAINIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.DUTCH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.getByLanguageCodeOrDefault
import static pl.allegro.finance.tradukisto.ValueConverters.getByLocaleOrDefault

class ValueConvertersTest extends Specification {

    @Unroll
    def "should convert numbers in #language"() {
        expect:
        converter.asWords(1_234) == number

        where:
        language               | converter                    || number
        "Brazilian Portuguese" | BRAZILIAN_PORTUGUESE_INTEGER || "mil duzentos e trinta e quatro"
        "Bulgarian"            | BULGARIAN_INTEGER            || "хиляда двеста тридесет четири"
        "Czech"                | CZECH_INTEGER                || "jeden tisíc dvě stě třicet čtyři"
        "Dutch"                | DUTCH_INTEGER                || "duizendtweehonderdvierendertig"
        "English"              | ENGLISH_INTEGER              || "one thousand two hundred thirty-four"
        "French"               | FRENCH_INTEGER               || "mille deux cent trente-quatre"
        "German"               | GERMAN_INTEGER               || "eintausendzweihundertvierunddreißig"
        "Italian"              | ITALIAN_INTEGER              || "milleduecentotrentaquattro"
        "Kazakh"               | KAZAKH_INTEGER               || "бір мың екі жүз отыз төрт"
        "Latvian"              | LATVIAN_INTEGER              || "viens tūkstotis divi simti trīsdesmit četri"
        "Polish"               | POLISH_INTEGER               || "jeden tysiąc dwieście trzydzieści cztery"
        "Serbian Cyrillic"     | SERBIAN_CYRILLIC_INTEGER     || "једна хиљада двеста тридесет четири"
        "Serbian Latin"        | SERBIAN_INTEGER              || "jedna hiljada dvesta trideset četiri"
        "Slovak"               | SLOVAK_INTEGER               || "jeden tisíc dvesto tridsať štyri"
        "Slovene"              | SLOVENE_INTEGER              || "ena tisoč dvesto štiriintrideset"
        "Russian"              | RUSSIAN_INTEGER              || "одна тысяча двести тридцать четыре"
        "Turkish"              | TURKISH_INTEGER              || "Bin İki Yüz Otuz Dört"
        "Ukrainian"            | UKRAINIAN_INTEGER            || "одна тисяча двісті тридцять чотири"
        "Hindi"                | HINDI_INTEGER                || "एक हजार दो सौ चौंतीस"
    }

    def "should throw exception when null value given"() {
        when:
        converter.asWords(null)

        then:
        thrown(NullPointerException)

        where:
        converter << ValueConverters.values()
    }

    @Unroll
    def "should return #converter for locale #locale"() {
        expect:
        getByLocaleOrDefault(locale, null) == converter

        where:
        locale                                                           || converter
        new Locale("pt-br")                                              || BRAZILIAN_PORTUGUESE_INTEGER
        new Locale("pt")                                                 || BRAZILIAN_PORTUGUESE_INTEGER
        new Locale("bg")                                                 || BULGARIAN_INTEGER
        new Locale("cs")                                                 || CZECH_INTEGER
        Locale.ENGLISH                                                   || ENGLISH_INTEGER
        Locale.US                                                        || ENGLISH_INTEGER
        Locale.FRENCH                                                    || FRENCH_INTEGER
        new Locale("it")                                                 || ITALIAN_INTEGER
        Locale.ITALIAN                                                   || ITALIAN_INTEGER
        new Locale("de")                                                 || GERMAN_INTEGER
        Locale.GERMANY                                                   || GERMAN_INTEGER
        new Locale("kk")                                                 || KAZAKH_INTEGER
        new Locale("lv")                                                 || LATVIAN_INTEGER
        new Locale("pl")                                                 || POLISH_INTEGER
        new Locale("ru")                                                 || RUSSIAN_INTEGER
        new Locale.Builder().setLanguage("sr").setScript("Cyrl").build() || SERBIAN_CYRILLIC_INTEGER
        new Locale("sr")                                                 || SERBIAN_INTEGER
        new Locale.Builder().setLanguage("sr").setScript("Latn").build() || SERBIAN_INTEGER
        new Locale("sk")                                                 || SLOVAK_INTEGER
        new Locale("sl")                                                 || SLOVENE_INTEGER
        new Locale("tr")                                                 || TURKISH_INTEGER
        new Locale("uk")                                                 || UKRAINIAN_INTEGER
        new Locale("nl")                                                 || DUTCH_INTEGER
        new Locale("hi")                                                 || HINDI_INTEGER
    }

    def "should return supplied default converter when locale is unknown"() {
        given:
        def defaultConverter = FRENCH_INTEGER
        def unknownLocale = new Locale("zh")

        expect:
        getByLocaleOrDefault(unknownLocale, defaultConverter) == defaultConverter
    }

    def "should throw exception when null locale given"() {
        when:
        getByLocaleOrDefault(null, null)

        then:
        thrown(NullPointerException)
    }

    @Unroll
    def "should return #converter for language code #languageCode"() {
        expect:
        getByLanguageCodeOrDefault(languageCode, null) == converter

        where:
        languageCode || converter
        "pt-br"      || BRAZILIAN_PORTUGUESE_INTEGER
        "pt"         || BRAZILIAN_PORTUGUESE_INTEGER
        "bg"         || BULGARIAN_INTEGER
        "cs"         || CZECH_INTEGER
        "nl"         || DUTCH_INTEGER
        "en"         || ENGLISH_INTEGER
        "fr"         || FRENCH_INTEGER
        "it"         || ITALIAN_INTEGER
        "de"         || GERMAN_INTEGER
        "kk"         || KAZAKH_INTEGER
        "lv"         || LATVIAN_INTEGER
        "pl"         || POLISH_INTEGER
        "ru"         || RUSSIAN_INTEGER
        "sr__#Cyrl"  || SERBIAN_CYRILLIC_INTEGER
        "sr"         || SERBIAN_INTEGER
        "sr__#Latn"  || SERBIAN_INTEGER
        "sk"         || SLOVAK_INTEGER
        "sl"         || SLOVENE_INTEGER
        "tr"         || TURKISH_INTEGER
        "uk"         || UKRAINIAN_INTEGER
        "hi"         || HINDI_INTEGER
    }

    def "should return supplied default converter when languageCode is unknown"() {
        given:
        def defaultConverter = FRENCH_INTEGER
        def unknownLanguageCode = "zh"

        expect:
        getByLanguageCodeOrDefault(unknownLanguageCode, defaultConverter) == defaultConverter
    }

    def "should throw exception when null language code given"() {
        when:
        getByLanguageCodeOrDefault(null, null)

        then:
        thrown(NullPointerException)
    }

    def "should throw exception when empty language code given"() {
        when:
        getByLocaleOrDefault(new Locale(""), null)

        then:
        thrown(IllegalArgumentException)
    }
}
