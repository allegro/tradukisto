package pl.allegro.finance.tradukisto

import com.google.common.base.VerifyException
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.MoneyConverters.AMERICAN_ENGLISH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.BRAZILIAN_PORTUGUESE_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.BULGARIAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.CZECH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.ENGLISH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.FRENCH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.GERMAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.ITALIAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.KAZAKH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.LATVIAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.POLISH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.RUSSIAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.SERBIAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.SERBIAN_CYRILLIC_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.SLOVAK_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.TURKISH_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.UKRAINIAN_BANKING_MONEY_VALUE
import static pl.allegro.finance.tradukisto.MoneyConverters.DUTCH_BANKING_MONEY_VALUE

class MoneyConvertersTest extends Specification {

    @Unroll
    def "should convert money in #language"() {
        expect:
        converter.asWords(1_234.56) == money

        where:
        language               | converter                                || money
        "American English"     | AMERICAN_ENGLISH_BANKING_MONEY_VALUE     || "one thousand two hundred thirty-four \$ 56/100"
        "Brazilian Portuguese" | BRAZILIAN_PORTUGUESE_BANKING_MONEY_VALUE || "mil duzentos e trinta e quatro R\$ 56/100"
        "Bulgarian"            | BULGARIAN_BANKING_MONEY_VALUE            || "хиляда двеста тридесет четири лв 56/100"
        "Czech"                | CZECH_BANKING_MONEY_VALUE                || "jeden tisíc dvě stě třicet čtyři Kč 56/100"
        "Dutch"                | DUTCH_BANKING_MONEY_VALUE                || "duizendtweehonderdvierendertig € 56/100"
        "English"              | ENGLISH_BANKING_MONEY_VALUE              || "one thousand two hundred thirty-four £ 56/100"
        "French"               | FRENCH_BANKING_MONEY_VALUE               || "mille deux cent trente-quatre € 56/100"
        "German"               | GERMAN_BANKING_MONEY_VALUE               || "eintausendzweihundertvierunddreißig € 56/100"
        "Italian"              | ITALIAN_BANKING_MONEY_VALUE              || "milleduecentotrentaquattro € 56/100"
        "Kazakh"               | KAZAKH_BANKING_MONEY_VALUE               || "бір мың екі жүз отыз төрт KZT 56/100"
        "Latvian"              | LATVIAN_BANKING_MONEY_VALUE              || "viens tūkstotis divi simti trīsdesmit četri EUR 56/100"
        "Polish"               | POLISH_BANKING_MONEY_VALUE               || "jeden tysiąc dwieście trzydzieści cztery PLN 56/100"
        "Serbian Cyrillic"     | SERBIAN_CYRILLIC_BANKING_MONEY_VALUE     || "једна хиљада двеста тридесет четири РСД 56/100"
        "Serbian Latin"        | SERBIAN_BANKING_MONEY_VALUE              || "jedna hiljada dvesta trideset četiri RSD 56/100"
        "Slovak"               | SLOVAK_BANKING_MONEY_VALUE               || "jeden tisíc dvesto tridsať štyri € 56/100"
        "Russian"              | RUSSIAN_BANKING_MONEY_VALUE              || "одна тысяча двести тридцать четыре руб. 56/100"
        "Turkish"              | TURKISH_BANKING_MONEY_VALUE              || "BinİkiYüzOtuzDörtTL,ElliAltıKr."
        "Ukrainian"            | UKRAINIAN_BANKING_MONEY_VALUE            || "одна тисяча двісті тридцять чотири ₴ 56/100"
    }

    def "should throw exception when null given"() {
        when:
        converter.asWords(null)

        then:
        thrown(VerifyException)

        where:
        converter << MoneyConverters.values()
    }

    def "should convert value with currency symbol provided"() {
        expect:
        POLISH_BANKING_MONEY_VALUE.asWords(1_234.56, "EUR") == "jeden tysiąc dwieście trzydzieści cztery EUR 56/100"
    }

    def "should throw exception when null currency given"() {
        when:
        POLISH_BANKING_MONEY_VALUE.asWords(1_234.56, null)

        then:
        thrown(VerifyException)
    }
}
