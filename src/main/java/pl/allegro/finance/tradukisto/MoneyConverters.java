package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;

import java.math.BigDecimal;

import static com.google.common.base.Verify.verifyNotNull;
import static pl.allegro.finance.tradukisto.internal.Container.*;

public enum MoneyConverters {

    BRAZILIAN_PORTUGUESE_BANKING_MONEY_VALUE(brazilianPortugueseContainer().getBankingMoneyConverter()),
    ENGLISH_BANKING_MONEY_VALUE(englishContainer().getBankingMoneyConverter()),
    GERMAN_BANKING_MONEY_VALUE(germanContainer().getBankingMoneyConverter()),
    RUSSIAN_BANKING_MONEY_VALUE(russianContainer().getBankingMoneyConverter()),
    POLISH_BANKING_MONEY_VALUE(polishContainer().getBankingMoneyConverter()),
    ITALIAN_BANKING_MONEY_VALUE(italianContainer().getBankingMoneyConverter()),
    CZECH_BANKING_MONEY_VALUE(czechContainer().getBankingMoneyConverter()),
    SLOVAK_BANKING_MONEY_VALUE(slovakContainer().getBankingMoneyConverter()),
    LATVIAN_BANKING_MONEY_VALUE(latvianContainer().getBankingMoneyConverter()),
    KAZAKH_BANKING_MONEY_VALUE(kazakhContainer().getBankingMoneyConverter()),
    UKRAINIAN_BANKING_MONEY_VALUE(ukrainianContainer().getBankingMoneyConverter()),
    TURKISH_BANKING_MONEY_VALUE(turkishContainer().getBankingMoneyConverter()),
    SERBIAN_BANKING_MONEY_VALUE(serbianContainer().getBankingMoneyConverter()),
    FRENCH_BANKING_MONEY_VALUE(frenchContainer().getBankingMoneyConverter()),
    KYRGYZ_BANKING_MONEY_VALUE(kyrgyzContainer().getBankingMoneyConverter());

    private final BigDecimalToStringConverter converter;

    MoneyConverters(BigDecimalToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(BigDecimal value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
