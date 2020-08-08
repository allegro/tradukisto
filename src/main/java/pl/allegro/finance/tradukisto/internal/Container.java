package pl.allegro.finance.tradukisto.internal;

import pl.allegro.finance.tradukisto.internal.converters.BigDecimalToBankingMoneyConverter;
import pl.allegro.finance.tradukisto.internal.converters.HundredsToWordsConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValues;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValuesForSmallNumbers;
import pl.allegro.finance.tradukisto.internal.languages.english.EnglishValues;
import pl.allegro.finance.tradukisto.internal.languages.french.FrenchIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.french.FrenchValues;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.german.GermanValues;
import pl.allegro.finance.tradukisto.internal.languages.hebrew.HebrewBigDecimalToBankingMoneyConverter;
import pl.allegro.finance.tradukisto.internal.languages.hebrew.HebrewHundredsToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.hebrew.HebrewIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.hebrew.HebrewValues;
import pl.allegro.finance.tradukisto.internal.languages.italian.ItalianIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.italian.ItalianThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.italian.ItalianValues;
import pl.allegro.finance.tradukisto.internal.languages.kazakh.KazakhValues;
import pl.allegro.finance.tradukisto.internal.languages.latvian.LatvianValues;
import pl.allegro.finance.tradukisto.internal.languages.polish.PolishValues;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.BrazilianPortugueseValues;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseIntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseIntegerToWordsConverterAdapter;
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseThousandToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.russian.RussianValues;
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

	public static Container ukrainianContainer() {
		return new Container(new UkrainianValues());
	}

	public static Container czechContainer() {
		CzechValues czechValues = new CzechValues();
		Container containerForBigNumbers = new Container(czechValues);
		Container containerForSmallNumbers = new Container(new CzechValuesForSmallNumbers());

		IntegerToStringConverter integerConverter = new CzechIntegerToWordsConverter(containerForBigNumbers.getNumbersConverter(),
			containerForSmallNumbers.getNumbersConverter(),
			czechValues.exceptions());
		BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(integerConverter,
			czechValues.currency());

		return new Container(integerConverter, bigDecimalBankingMoneyValueConverter);
	}

	public static Container slovakContainer() {
		SlovakValues slovakValues = new SlovakValues();
		Container containerForBigNumbers = new Container(slovakValues);
		Container containerForSmallNumbers = new Container(new SlovakValuesForSmallNumbers());

		IntegerToStringConverter integerConverter = new CzechIntegerToWordsConverter(containerForBigNumbers.getNumbersConverter(),
			containerForSmallNumbers.getNumbersConverter(),
			slovakValues.exceptions());
		BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(integerConverter,
			slovakValues.currency());

		return new Container(integerConverter, bigDecimalBankingMoneyValueConverter);
	}

	public static Container englishContainer() {
		return new Container(new EnglishValues());
	}

	public static Container frenchContainer() {

		FrenchValues values = new FrenchValues();

		HundredsToWordsConverter hundredsToWordsConverter = new HundredsToWordsConverter(values.baseNumbers(),
			values.twoDigitsNumberSeparator());
		IntegerToWordsConverter frenchIntegerToWordsConverter = new IntegerToWordsConverter(hundredsToWordsConverter, values.pluralForms());
		IntegerToStringConverter converter = new FrenchIntegerToWordsConverter(frenchIntegerToWordsConverter,
			values.exceptions(),
			values.pluralForms());

		BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(converter,
			values.currency());

		return new Container(converter, bigDecimalBankingMoneyValueConverter);
	}

	/**
	 *  adds Hebrew language support
	 *  
	 *  @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
	 *  @since 1.8.1
	 */
	public static Container hebrewContainer() {
		HebrewValues conversionValues = new HebrewValues();
		HebrewValues monetaryValues = new HebrewValues();
	
		HebrewHundredsToWordsConverter hundredsToWordsConverter = new HebrewHundredsToWordsConverter(conversionValues);
		HebrewIntegerToWordsConverter intToWordsConverter = new HebrewIntegerToWordsConverter(hundredsToWordsConverter, conversionValues);
		
		HebrewIntegerToWordsConverter decimalToWordConverter = new HebrewIntegerToWordsConverter(hundredsToWordsConverter, monetaryValues);
		BigDecimalToStringConverter monetaryValueConverter = new HebrewBigDecimalToBankingMoneyConverter(decimalToWordConverter, monetaryValues);
		
		return new Container(intToWordsConverter, monetaryValueConverter);
	}

	public static Container germanContainer() {

		GermanValues values = new GermanValues();

		GermanThousandToWordsConverter germanThousandToWordsConverter = new GermanThousandToWordsConverter(values.baseNumbers());

		IntegerToStringConverter converter = new GermanIntegerToWordsConverter(new IntegerToWordsConverter(germanThousandToWordsConverter,
			values.pluralForms()), values.exceptions(), germanThousandToWordsConverter);

		BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(converter,
			values.currency());

		return new Container(converter, bigDecimalBankingMoneyValueConverter);
	}

	public static Container italianContainer() {
		ItalianValues values = new ItalianValues();

		ItalianThousandToWordsConverter italianThousandToWordsConverter = new ItalianThousandToWordsConverter(values.baseNumbers());

		IntegerToStringConverter converter = new ItalianIntegerToWordsConverter(new IntegerToWordsConverter(italianThousandToWordsConverter,
			values.pluralForms()), values.exceptions(), italianThousandToWordsConverter);

		BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(converter,
			values.currency());

		return new Container(converter, bigDecimalBankingMoneyValueConverter);
	}

	public static Container latvianContainer() {
		return new Container(new LatvianValues());
	}

	public static Container brazilianPortugueseContainer() {
		BrazilianPortugueseValues values = new BrazilianPortugueseValues();

		PortugueseThousandToWordsConverter portugueseThousandToWordsConverter = new PortugueseThousandToWordsConverter(values.baseNumbers(),
			values.exceptions());

		IntegerToStringConverter converter = new PortugueseIntegerToWordsConverter(
			new PortugueseIntegerToWordsConverterAdapter(portugueseThousandToWordsConverter, values.pluralForms()),
			values.exceptions(),
			portugueseThousandToWordsConverter);

		BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(converter,
			values.currency());

		return new Container(converter, bigDecimalBankingMoneyValueConverter);
	}

	public static Container turkishContainer() {
		TurkishValues values = new TurkishValues();

		TurkishSmallNumbersToWordsConverter smallNumbersConverter = new TurkishSmallNumbersToWordsConverter(values);
		IntegerToWordsConverter bigNumbersConverter = new IntegerToWordsConverter(smallNumbersConverter, values.pluralForms());
		IntegerToStringConverter converter = new TurkishIntegerToWordsConverter(bigNumbersConverter, smallNumbersConverter);
		BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new TurkishBigDecimalToBankingMoneyConverter(converter, values);

		return new Container(converter, bigDecimalBankingMoneyValueConverter);
	}

	public static Container kazakhContainer() {
		KazakhValues kazakhValues = new KazakhValues();
		return new Container(kazakhValues);
	}

	private final IntegerToStringConverter integerConverter;
	private final BigDecimalToStringConverter bigDecimalConverter;

	private Container(BaseValues baseValues) {
		HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(baseValues.baseNumbers(),
			baseValues.twoDigitsNumberSeparator());

		integerConverter = new IntegerToWordsConverter(hundredsToStringConverter, baseValues.pluralForms());
		bigDecimalConverter = new BigDecimalToBankingMoneyConverter(integerConverter, baseValues.currency());
	}

	private Container(IntegerToStringConverter integerConverter, BigDecimalToStringConverter bigDecimalConverter) {
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
