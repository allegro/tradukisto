package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.converters.BigDecimalToBankingMoneyConverter;
import pl.allegro.finance.tradukisto.internal.converters.HundredsToWordsConverter;
import pl.allegro.finance.tradukisto.internal.converters.NumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.bulgarian.BulgarianIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.bulgarian.BulgarianValues;
import pl.allegro.finance.tradukisto.internal.languages.croatian.CroatianValues;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValues;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValuesForSmallNumbers;
import pl.allegro.finance.tradukisto.internal.languages.dutch.DutchIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.dutch.DutchThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.dutch.DutchValues;
import pl.allegro.finance.tradukisto.internal.languages.english.AmericanEnglishValues;
import pl.allegro.finance.tradukisto.internal.languages.english.EnglishValues;
import pl.allegro.finance.tradukisto.internal.languages.french.FrenchNumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.french.FrenchValues;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanValues;
import pl.allegro.finance.tradukisto.internal.languages.hindi.HindiBigDecimalToBankingMoneyConverter;
import pl.allegro.finance.tradukisto.internal.languages.hindi.HindiValues;
import pl.allegro.finance.tradukisto.internal.languages.hindi.IndianNumberToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.italian.ItalianIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.italian.ItalianThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.italian.ItalianValues;
import pl.allegro.finance.tradukisto.internal.languages.kazakh.KazakhValues;
import pl.allegro.finance.tradukisto.internal.languages.latvian.LatvianValues;
import pl.allegro.finance.tradukisto.internal.languages.polish.PolishValues;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.BrazilianPortugueseValues;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseNumberToWordsConverterAdapter;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.russian.RussianValues;
import pl.allegro.finance.tradukisto.internal.languages.serbian.SerbianCyrillicValues;
import pl.allegro.finance.tradukisto.internal.languages.serbian.SerbianValues;
import pl.allegro.finance.tradukisto.internal.languages.slovak.SlovakValues;
import pl.allegro.finance.tradukisto.internal.languages.slovak.SlovakValuesForSmallNumbers;
import pl.allegro.finance.tradukisto.internal.languages.turkish.TurkishBigDecimalToBankingMoneyConverter;
import pl.allegro.finance.tradukisto.internal.languages.turkish.TurkishIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.turkish.TurkishSmallNumbersToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.turkish.TurkishValues;
import pl.allegro.finance.tradukisto.internal.languages.ukrainian.UkrainianValues;

public final class Container {

    public static Container polishContainer() {
        return new Container(new PolishValues());
    }

    public static Container russianContainer() {
        return new Container(new RussianValues());
    }

    public static Container serbianContainer() {
        return new Container(new SerbianValues());
    }

    public static Container serbianCyrillicContainer() {
        return new Container(new SerbianCyrillicValues());
    }

    public static Container bulgarianContainer() {
        BulgarianValues bulgarianValues = new BulgarianValues();

        HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(bulgarianValues.baseNumbers(),
                bulgarianValues.twoDigitsNumberSeparator());

        IntegerToStringConverter integerToStringConverter = new BulgarianIntegerToWordsConverter(
                hundredsToStringConverter,
                bulgarianValues.pluralForms(),
                bulgarianValues.oneThousandException());

        BigDecimalToStringConverter bigDecimalConverter = new BigDecimalToBankingMoneyConverter(
                integerToStringConverter,
                bulgarianValues.currency());

        return new Container(integerToStringConverter, null, bigDecimalConverter);
    }

    public static Container ukrainianContainer() {
        return new Container(new UkrainianValues());
    }

    public static Container croatianContainer() {
        return new Container(new CroatianValues());
    }

    public static Container czechContainer() {
        CzechValues czechValues = new CzechValues();
        Container containerForBigNumbers = new Container(czechValues);
        Container containerForSmallNumbers = new Container(new CzechValuesForSmallNumbers());

        IntegerToStringConverter integerConverter = new CzechIntegerToWordsConverter(
                containerForBigNumbers.getIntegerConverter(), containerForSmallNumbers.getIntegerConverter(),
                czechValues.exceptions()
        );
        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                czechValues.currency());

        return new Container(integerConverter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container slovakContainer() {
        SlovakValues slovakValues = new SlovakValues();
        Container containerForBigNumbers = new Container(slovakValues);
        Container containerForSmallNumbers = new Container(new SlovakValuesForSmallNumbers());

        IntegerToStringConverter integerConverter = new CzechIntegerToWordsConverter(containerForBigNumbers.getIntegerConverter(),
                containerForSmallNumbers.getIntegerConverter(), slovakValues.exceptions());
        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(integerConverter,
                slovakValues.currency());

        return new Container(integerConverter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container englishContainer() {
        return new Container(new EnglishValues());
    }

    public static Container americanEnglishContainer() {
        return new Container(new AmericanEnglishValues());
    }

    public static Container frenchContainer() {

        FrenchValues values = new FrenchValues();

        HundredsToWordsConverter hundredsToWordsConverter =
                new HundredsToWordsConverter(values.baseNumbers(), values.twoDigitsNumberSeparator());
        NumberToWordsConverter frenchNumberToWordsConverter =
                new NumberToWordsConverter(hundredsToWordsConverter, values.pluralForms());
        IntegerToStringConverter converter =
                new FrenchNumberToWordsConverter(frenchNumberToWordsConverter, values.exceptions(), values.pluralForms());

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter =
                new BigDecimalToBankingMoneyConverter(converter, values.currency());

        return new Container(converter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container germanContainer() {

        GermanValues values = new GermanValues();

        GermanThousandToWordsConverter germanThousandToWordsConverter = new GermanThousandToWordsConverter(
                values.baseNumbers());

        IntegerToStringConverter converter = new GermanIntegerToWordsConverter(
                new NumberToWordsConverter(germanThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                germanThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container dutchContainer() {

        DutchValues values = new DutchValues();

        DutchThousandToWordsConverter dutchThousandToWordsConverter = new DutchThousandToWordsConverter(
                values.baseNumbers());

        IntegerToStringConverter converter = new DutchIntegerToWordsConverter(
                new NumberToWordsConverter(dutchThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                dutchThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container italianContainer() {
        ItalianValues values = new ItalianValues();

        ItalianThousandToWordsConverter italianThousandToWordsConverter = new ItalianThousandToWordsConverter(
                values.baseNumbers());

        IntegerToStringConverter converter = new ItalianIntegerToWordsConverter(
                new NumberToWordsConverter(italianThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                italianThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container latvianContainer() {
        return new Container(new LatvianValues());
    }

    public static Container brazilianPortugueseContainer() {
        BrazilianPortugueseValues values = new BrazilianPortugueseValues();

        PortugueseThousandToWordsConverter portugueseThousandToWordsConverter = new PortugueseThousandToWordsConverter(
                values.baseNumbers(), values.exceptions());

        IntegerToStringConverter converter = new PortugueseIntegerToWordsConverter(
                new PortugueseNumberToWordsConverterAdapter(portugueseThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                portugueseThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container turkishContainer() {
        TurkishValues values = new TurkishValues();

        TurkishSmallNumbersToWordsConverter smallNumbersConverter = new TurkishSmallNumbersToWordsConverter(values);
        NumberToWordsConverter bigNumbersConverter = new NumberToWordsConverter(smallNumbersConverter, values.pluralForms());
        IntegerToStringConverter converter =
                new TurkishIntegerToWordsConverter(bigNumbersConverter, smallNumbersConverter);
        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter =
                new TurkishBigDecimalToBankingMoneyConverter(converter, values);

        return new Container(converter, null, bigDecimalBankingMoneyValueConverter);
    }

    public static Container kazakhContainer() {
        KazakhValues kazakhValues = new KazakhValues();
        return new Container(kazakhValues);
    }

    public static Container hindiContainer() {
        HindiValues hindiValues = new HindiValues();

        HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(hindiValues.baseNumbers(),
                hindiValues.twoDigitsNumberSeparator());

        IntegerToStringConverter integerToStringConverter = new IndianNumberToWordsConverter(hundredsToStringConverter, hindiValues.pluralForms());

        BigDecimalToStringConverter bigDecimalConverter = new HindiBigDecimalToBankingMoneyConverter(
                integerToStringConverter,
                hindiValues);
        LongToStringConverter longValueConverters = new IndianNumberToWordsConverter(hundredsToStringConverter, hindiValues.pluralForms());

        return new Container(integerToStringConverter, longValueConverters, bigDecimalConverter);
    }

    private final IntegerToStringConverter integerConverter;
    private final LongToStringConverter longConverter;
    private final BigDecimalToStringConverter bigDecimalConverter;

    private Container(BaseValues baseValues) {
        HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(baseValues.baseNumbers(),
                baseValues.twoDigitsNumberSeparator());

        NumberToWordsConverter numberToWordsConverter = new NumberToWordsConverter(
                hundredsToStringConverter,
                baseValues.pluralForms());
        integerConverter = numberToWordsConverter;
        longConverter = numberToWordsConverter;
        bigDecimalConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                baseValues.currency());
    }

    private Container(IntegerToStringConverter integerConverter,
                      LongToStringConverter longConverter, BigDecimalToStringConverter bigDecimalConverter) {
        this.integerConverter = integerConverter;
        this.longConverter = longConverter;
        this.bigDecimalConverter = bigDecimalConverter;
    }

    public IntegerToStringConverter getIntegerConverter() {
        return integerConverter;
    }

    public LongToStringConverter getLongConverter() {
        return longConverter;
    }

    public BigDecimalToStringConverter getBankingMoneyConverter() {
        return bigDecimalConverter;
    }
}
