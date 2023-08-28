package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.Container;

import java.math.BigDecimal;
import java.util.Objects;

import static pl.allegro.finance.tradukisto.internal.Container.americanEnglishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.brazilianPortugueseContainer;
import static pl.allegro.finance.tradukisto.internal.Container.croatianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.czechContainer;
import static pl.allegro.finance.tradukisto.internal.Container.englishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.frenchContainer;
import static pl.allegro.finance.tradukisto.internal.Container.germanContainer;
import static pl.allegro.finance.tradukisto.internal.Container.italianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.kazakhContainer;
import static pl.allegro.finance.tradukisto.internal.Container.latvianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.russianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.serbianCyrillicContainer;
import static pl.allegro.finance.tradukisto.internal.Container.serbianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.slovakContainer;
import static pl.allegro.finance.tradukisto.internal.Container.turkishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.ukrainianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.bulgarianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.dutchContainer;
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
    UKRAINIAN_BANKING_MONEY_VALUE(ukrainianContainer().getBankingMoneyConverter()),
    TURKISH_BANKING_MONEY_VALUE(turkishContainer().getBankingMoneyConverter()),
    SERBIAN_BANKING_MONEY_VALUE(serbianContainer().getBankingMoneyConverter()),
    SERBIAN_CYRILLIC_BANKING_MONEY_VALUE(serbianCyrillicContainer().getBankingMoneyConverter()),
    FRENCH_BANKING_MONEY_VALUE(frenchContainer().getBankingMoneyConverter()),
    BULGARIAN_BANKING_MONEY_VALUE(bulgarianContainer().getBankingMoneyConverter()),
    DUTCH_BANKING_MONEY_VALUE(dutchContainer().getBankingMoneyConverter()),
    HINDI_BANKING_MONEY_VALUE(Container.hindiContainer().getBankingMoneyConverter());

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
