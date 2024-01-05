package pl.allegro.finance.tradukisto.internal.languages.spanish;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.BigDecimalToBankingMoneyConverter;

import java.math.BigDecimal;

import static java.lang.String.format;

public class SpanishBigDecimalToBankingMoneyConverter extends BigDecimalToBankingMoneyConverter {
    private static final String FORMAT = "%s %s %02d/100";
    private final IntegerToStringConverter converter;

    public SpanishBigDecimalToBankingMoneyConverter(IntegerToStringConverter converter, String currencySymbol) {
        super(converter, currencySymbol);
        this.converter = converter;
    }

    @Override
    public String asWords(BigDecimal value, String currencySymbol) {
        validate(value);
        Integer units = value.intValue();
        Integer subunits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        String words = converter.asWords(units);

        // bugfix - ugly hack for ending with "1" :( numerals + nouns needs to have specific gender form
        // for example "51 euros" - it is needed to use "cincuenta y un" instead of "cincuenta y uno"
        // converter itself does not have context if it is formatting for "standalone" form or with noun
        if (words.endsWith("uno")) {
            words = words.replaceAll("uno$","un");
        }
        return format(FORMAT, words, currencySymbol, subunits);
    }

}
