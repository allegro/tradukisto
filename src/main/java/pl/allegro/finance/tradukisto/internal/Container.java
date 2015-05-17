package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.converters.BigDecimalToBankingMoneyConverter;
import pl.allegro.finance.tradukisto.internal.converters.HundredsToWordsConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValues;
import pl.allegro.finance.tradukisto.internal.languages.polish.PolishValues;

public class Container {

    public static Container polishContainer() {
        return new Container(new PolishValues());
    }

    public static Container czechContainer() {
        return new Container(new CzechValues());
    }

    private IntegerToStringConverter integerConverter;
    private BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter;

    public Container(BaseValues baseValues) {
        HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(baseValues.baseNumbers());

        integerConverter = new IntegerToWordsConverter(
                hundredsToStringConverter,
                baseValues.pluralForms());
        bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                baseValues.currency());
    }

    public IntegerToStringConverter getNumbersConverter() {
        return integerConverter;
    }

    public BigDecimalToStringConverter getBankingMoneyConverter() {
        return bigDecimalBankingMoneyValueConverter;
    }
}
