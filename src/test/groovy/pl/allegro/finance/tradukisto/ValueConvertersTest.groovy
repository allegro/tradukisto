package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.ValueConverters.BRAZILIAN_PORTUGUESE_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.CZECH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.ENGLISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.FRENCH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.GERMAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.ITALIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.KAZAKH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.LATVIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.POLISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.RUSSIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.SERBIAN_CYRILLIC_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.SERBIAN_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.SLOVAK_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.TURKISH_INTEGER
import static pl.allegro.finance.tradukisto.ValueConverters.UKRAINIAN_INTEGER

class ValueConvertersTest extends Specification {

    @Unroll
    def "should convert numbers in #language"() {
        expect:
        converter.asWords(1_234) == number

        where:
        language               | converter                    || number
        "Brazilian Portuguese" | BRAZILIAN_PORTUGUESE_INTEGER || "mil duzentos e trinta e quatro"
        "Czech"                | CZECH_INTEGER                || "jeden tisíc dvě stě třicet čtyři"
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
        "Russian"              | RUSSIAN_INTEGER              || "одна тысяча двести тридцать четыре"
        "Turkish"              | TURKISH_INTEGER              || "Bin İki Yüz Otuz Dört"
        "Ukrainian"            | UKRAINIAN_INTEGER            || "одна тисяча двісті тридцять чотири"
    }

    def "should throw exception when null given"() {
        when:
        converter.asWords(null)

        then:
        thrown(VerifyException)

        where:
        converter << ValueConverters.values()
    }
}
