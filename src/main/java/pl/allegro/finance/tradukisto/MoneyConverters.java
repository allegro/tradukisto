package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.Container;

import java.math.BigDecimal;
import java.util.Objects;

import static pl.allegro.finance.tradukisto.internal.Container.*;

public enum MoneyConverters {

    BRAZILIAN_PORTUGUESE_BANKING_MONEY_VALUE(brazilianPortugueseContainer().getBankingMoneyConverter()),
    ENGLISH_BANKING_MONEY_VALUE(englishContainer().getBankingMoneyConverter()),
    AMERICAN_ENGLISH_BANKING_MONEY_VALUE(americanEnglishContainer().getBankingMoneyConverter()),
    GERMAN_BANKING_MONEY_VALUE(germanContainer().getBankingMoneyConverter()),
    RUSSIAN_BANKING_MONEY_VALUE(russianContainer().getBankingMoneyConverter()),
    POLISH_BANKING_MONEY_VALUE(polishContainer().getBankingMoneyConverter()),
    ITALIAN_BANKING_MONEY_VALUE(italianContainer().getBankingMoneyConverter()),
    CROATIAN_BANKING_MONEY_VALUE(croatianContainer().getBankingMoneyConverter()),
    CZECH_BANKING_MONEY_VALUE(czechContainer().getBankingMoneyConverter()),
    SLOVAK_BANKING_MONEY_VALUE(slovakContainer().getBankingMoneyConverter()),
    LATVIAN_BANKING_MONEY_VALUE(latvianContainer().getBankingMoneyConverter()),
    KAZAKH_BANKING_MONEY_VALUE(kazakhContainer().getBankingMoneyConverter()),
    KYRGYZ_BANKING_MONEY_VALUE(kyrgyzContainer().getBankingMoneyConverter()),
    UKRAINIAN_BANKING_MONEY_VALUE(ukrainianContainer().getBankingMoneyConverter()),
    TURKISH_BANKING_MONEY_VALUE(turkishContainer().getBankingMoneyConverter()),
    SERBIAN_BANKING_MONEY_VALUE(serbianContainer().getBankingMoneyConverter()),
    SERBIAN_CYRILLIC_BANKING_MONEY_VALUE(serbianCyrillicContainer().getBankingMoneyConverter()),
    SLOVENE_BANKING_MONEY_VALUE(sloveneContainer().getBankingMoneyConverter()),
    FRENCH_BANKING_MONEY_VALUE(frenchContainer().getBankingMoneyConverter()),
    BULGARIAN_BANKING_MONEY_VALUE(bulgarianContainer().getBankingMoneyConverter()),
    DUTCH_BANKING_MONEY_VALUE(dutchContainer().getBankingMoneyConverter()),
    SPANISH_BANKING_MONEY_VALUE(spanishContainer().getBankingMoneyConverter()),
    HINDI_BANKING_MONEY_VALUE(Container.hindiContainer().getBankingMoneyConverter()),
    SWEDISH_BANKING_MONEY_VALUE(swedishContainer().getBankingMoneyConverter()),
    JAPANESE_BANKING_MONEY_VALUE(japaneseKanjiContainer().getBankingMoneyConverter());

    private final BigDecimalToStringConverter converter;

    MoneyConverters(BigDecimalToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(BigDecimal value) {
        Objects.requireNonNull(value);

        return converter.asWords(value);
    }

    public String asWords(BigDecimal value, String currencySymbol) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(currencySymbol);

        return converter.asWords(value, currencySymbol);
    }
}
