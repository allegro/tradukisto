/*
 * Copyright 2013-2020 Allegro Group
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.allegro.finance.tradukisto.internal.languages.hebrew;

import static java.lang.String.format;

import java.util.Map;

import com.google.common.collect.Range;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

/**
 * The class HebrewIntegerToWordsConverter is a hebrew specialization of
 * IntegerToWordsConverter
 * 
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.8.1
 * @since 1.8.1
 * 
 */
public class HebrewIntegerToWordsConverter extends IntegerToWordsConverter {

	private final HebrewValues hebrewValues;
	private final Map<Integer, String> exceptions;
	private final Map<Integer, GenderForms> baseNumbers;
	private final String WORD_FOR_MILLION, WORD_FOR_THOUSAND;
	private final Integer THOUSAND = 1000;
	private final Integer MILLION = THOUSAND * THOUSAND;
	private final Integer BILLION = MILLION * THOUSAND;

	public HebrewIntegerToWordsConverter(GenderAwareIntegerToStringConverter genderAwareintegerToStringConverter,
			HebrewValues hebrewValues) {
		super(genderAwareintegerToStringConverter, hebrewValues.pluralForms());
		this.hebrewValues = hebrewValues;
		this.exceptions = hebrewValues.exceptions();
		this.baseNumbers = hebrewValues.baseNumbers();
		WORD_FOR_MILLION = baseNumbers.get(MILLION).formFor(GenderType.MASCULINE);
		WORD_FOR_THOUSAND = baseNumbers.get(THOUSAND).formFor(GenderType.MASCULINE);
	}

	@Override
	public String asWords(Integer value) {
		if (exceptions.containsKey(value))
			return exceptions.get(value);
		if (Range.closed(1000, 19999).contains(value))
			return thousandAsString(value);
		if (Range.closed(20000, 999999).contains(value))
			return thousandsAsString(value);
		if (Range.closed(1000000, 10999999).contains(value))
			return millionAsString(value);
		if (Range.closed(11000000, 999999999).contains(value))
			return millionsAsString(value);
		if (Range.closed(1000000000, Integer.MAX_VALUE).contains(value))
			return billionsAsString(value);
		// System.out.printf("HebrewIntegerToWordsConverter.asWords() SUPER value:
		// %s%n", value);
		return super.asWords(value);
	}

	private String thousandAsString(Integer value) {
		// System.out.printf("HebrewIntegerToWordsConverter.thousandAsString() SINGLE
		// THOUSANDS value: %s%n", value);
		Integer thousands = value / THOUSAND;
		Integer remain = value % THOUSAND;
		String word = baseNumbers.get(thousands * THOUSAND).formFor(GenderType.MASCULINE);
		// System.out.printf("HebrewIntegerToWordsConverter.thousandAsString() VALUE: %s
		// THOUSANDS: %s REMAIN: %s%n", value, thousands, remain);
		if (nothingComesAfter(remain))
			return word;
		if (Range.closed(1, 19).contains(remain))
			return format("%s %s%s", word, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
		return format("%s %s", word, asWords(remain));
	}

	private String thousandsAsString(Integer value) {
		// System.out.printf("HebrewIntegerToWordsConverter.thousandsAsString() MULTI
		// THOUSANDS value: %s%n", value);
		Integer thousands = value / THOUSAND;
		Integer remain = value % THOUSAND;
		String word = hundredsToWordsConverter.asWords(thousands, GenderType.MASCULINE);
		// System.out.printf("HebrewIntegerToWordsConverter.thousandsAsString()
		// THOUSANDS: %s REMAIN: %s THO_WORD: %s%n", thousands, remain,word);
		if (nothingComesAfter(remain))
			return format("%s %s", word, WORD_FOR_THOUSAND);
		if ((remain <= 100 && remain % 10 == 0) || Range.closed(1, 19).contains(remain))
			return format("%s %s %s%s", word, WORD_FOR_THOUSAND, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
		return format("%s %s %s", word, WORD_FOR_THOUSAND, asWords(remain));
	}

	private String millionAsString(Integer value) {
		// System.out.printf("HebrewIntegerToWordsConverter.millionAsString() SINGLE
		// MILLION value: %s%n", value);
		Integer millions = value / MILLION;
		Integer remain = value % MILLION;
		String word = baseNumbers.get(millions * MILLION).formFor(GenderType.MASCULINE);
		// System.out.printf("HebrewIntegerToWordsConverter.millionAsString() MILLIONS:
		// %s REMAIN: %s WORD: %s%n", millions, remain, word);
		if (nothingComesAfter(remain))
			return word;
		if (remain % 100 == 0 || Range.closed(1, 19).contains(remain))
			return format("%s %s%s", word, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
		return format("%s %s", word, asWords(remain));
	}

	private String millionsAsString(Integer value) {
		// hebrewValues.pluralForms().add(new RegularPluralForms("", "",
		// GenderType.MASCULINE));
		// System.out.printf("HebrewIntegerToWordsConverter.millionsAsString() MULTI
		// MILLION value: %s%n", value);
		Integer millions = value / MILLION;
		Integer remain = value % MILLION;
		String word = hundredsToWordsConverter.asWords(millions, GenderType.MASCULINE);
		// System.out.printf("HebrewIntegerToWordsConverter.millionsAsString() MILLIONS:
		// %s REMAIN: %s WORD: %s%n", millions, remain, word);
		if (nothingComesAfter(remain))
			return format("%s %s", word, WORD_FOR_MILLION);
		if ((remain <= 100 && remain % 10 == 0) || Range.closed(1, 19).contains(remain))
			return format("%s %s %s%s", word, WORD_FOR_MILLION, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
		return format("%s %s %s", word, WORD_FOR_MILLION, asWords(remain));
	}

	private String billionsAsString(Integer value) {
		// System.out.printf("HebrewIntegerToWordsConverter.billionsAsString() BILLIONS
		// value: %s%n", value);
		Integer billions = value / BILLION;
		Integer remain = value % BILLION;
		String word = baseNumbers.get(billions * BILLION).formFor(GenderType.MASCULINE);
		if (nothingComesAfter(remain))
			return word;
		if (Range.closed(1, 19).contains(remain))
			return format("%s %s%s", word, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
		return format("%s %s", word, asWords(remain));
	}

	private boolean nothingComesAfter(Integer other) {
		return other == 0;
	}

	protected HebrewValues hebrewValues() {
		return hebrewValues;
	}
}
