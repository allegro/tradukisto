package pl.allegro.utils.tradukisto.internal.languages.polish;

import pl.allegro.utils.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.utils.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.utils.tradukisto.internal.NumberChunking;

public final class PolishContainer {

    public static final PolishContainer INSTANCE = new PolishContainer();

    public static PolishContainer polishContainer() {
        return INSTANCE;
    }

    private IntegerToStringConverter integerConverter;
    private BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter;

    private PolishContainer() {
        integerConverter = new IntegerToPolishConverter(new HundredsToPolishConverter(), new NumberChunking());
        bigDecimalBankingMoneyValueConverter = new BigDecimalToPolishBankingMoneyValueConverter(integerConverter);
    }

    public IntegerToStringConverter getNumbersConverter() {
        return integerConverter;
    }

    public BigDecimalToStringConverter getBankingMoneyConverter() {
        return bigDecimalBankingMoneyValueConverter;
    }
}
