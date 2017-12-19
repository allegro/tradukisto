package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.converters.BigDecimalToBankingMoneyConverter;
import pl.allegro.finance.tradukisto.internal.converters.HundredsToWordsConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValues;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValuesForSmallNumbers;
import pl.allegro.finance.tradukisto.internal.languages.english.EnglishValues;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanValues;
import pl.allegro.finance.tradukisto.internal.languages.polish.PolishValues;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.BrazilianPortugueseValues;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseIntegerToWordsConverterAdapter;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.russian.RussianValues;
import pl.allegro.finance.tradukisto.internal.languages.spanish.SpanishIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.spanish.SpanishIntegerToWordsConverterAdapter;
import pl.allegro.finance.tradukisto.internal.languages.spanish.SpanishThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.spanish.SpanishValues;

public final class Container {

    public static Container polishContainer() {
        return new Container(new PolishValues());
    }

    public static Container russianContainer() {
        return new Container(new RussianValues());
    }

    public static Container czechContainer() {
        CzechValues czechValues = new CzechValues();
        Container containerForBigNumbers = new Container(czechValues);
        Container containerForSmallNumbers = new Container(new CzechValuesForSmallNumbers());

        IntegerToStringConverter integerConverter = new CzechIntegerToWordsConverter(
                containerForBigNumbers.getNumbersConverter(), containerForSmallNumbers.getNumbersConverter(),
                czechValues.exceptions()
        );
        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                czechValues.currency());

        return new Container(integerConverter, bigDecimalBankingMoneyValueConverter);
    }

    public static Container englishContainer() {
        return new Container(new EnglishValues());
    }

    public static Container germanContainer() {

        GermanValues values = new GermanValues();

        GermanThousandToWordsConverter germanThousandToWordsConverter = new GermanThousandToWordsConverter(
                values.baseNumbers());

        IntegerToStringConverter converter = new GermanIntegerToWordsConverter(
                new IntegerToWordsConverter(germanThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                germanThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, bigDecimalBankingMoneyValueConverter);
    }

    public static Container brazilianPortugueseContainer() {
        BrazilianPortugueseValues values = new BrazilianPortugueseValues();

        PortugueseThousandToWordsConverter portugueseThousandToWordsConverter = new PortugueseThousandToWordsConverter(
                values.baseNumbers(), values.exceptions());

        IntegerToStringConverter converter = new PortugueseIntegerToWordsConverter(
                new PortugueseIntegerToWordsConverterAdapter(portugueseThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                portugueseThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, bigDecimalBankingMoneyValueConverter);
    }

    public static Container spanishContainer() {
        SpanishValues values = new SpanishValues();

        SpanishThousandToWordsConverter spanishThousandToWordsConverter = new SpanishThousandToWordsConverter(
                values.baseNumbers(), values.exceptions());

        IntegerToStringConverter converter = new SpanishIntegerToWordsConverter(
                new SpanishIntegerToWordsConverterAdapter(spanishThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                spanishThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, bigDecimalBankingMoneyValueConverter);
    }

    private final IntegerToStringConverter integerConverter;
    private final BigDecimalToStringConverter bigDecimalConverter;

    private Container(BaseValues baseValues) {
        HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(baseValues.baseNumbers(),
                baseValues.twoDigitsNumberSeparator());

        integerConverter = new IntegerToWordsConverter(
                hundredsToStringConverter,
                baseValues.pluralForms());
        bigDecimalConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                baseValues.currency());
    }

    private Container(IntegerToStringConverter integerConverter,
                      BigDecimalToStringConverter bigDecimalConverter) {
        this.integerConverter = integerConverter;
        this.bigDecimalConverter = bigDecimalConverter;
    }

    public IntegerToStringConverter getNumbersConverter() {
        return integerConverter;
    }

    public BigDecimalToStringConverter getBankingMoneyConverter() {
        return bigDecimalConverter;
    }
}