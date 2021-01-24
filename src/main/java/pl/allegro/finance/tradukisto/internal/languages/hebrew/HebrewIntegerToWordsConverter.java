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

public class HebrewIntegerToWordsConverter extends IntegerToWordsConverter {

    private final HebrewValues hebrewValues;
    private final Map<Integer, String> exceptions;
    private final Map<Integer, GenderForms> baseNumbers;
    private final String wordForMillion, wordForThousand;
    private final Integer thousand = 1000;
    private final Integer million = thousand * thousand;
    private final Integer billion = million * thousand;

    public HebrewIntegerToWordsConverter(GenderAwareIntegerToStringConverter genderAwareintegerToStringConverter,
            HebrewValues hebrewValues) {
        super(genderAwareintegerToStringConverter, hebrewValues.pluralForms());
        this.hebrewValues = hebrewValues;
        this.exceptions = hebrewValues.exceptions();
        this.baseNumbers = hebrewValues.baseNumbers();
        wordForMillion = baseNumbers.get(million).formFor(GenderType.MASCULINE);
        wordForThousand = baseNumbers.get(thousand).formFor(GenderType.MASCULINE);
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }
        if (Range.closed(1000, 19999).contains(value)) {
            return thousandAsString(value);
        }
        if (Range.closed(20000, 999999).contains(value)) {
            return thousandsAsString(value);
        }
        if (Range.closed(1000000, 10999999).contains(value)) {
            return millionAsString(value);
        }
        if (Range.closed(11000000, 999999999).contains(value)) {
            return millionsAsString(value);
        }
        if (Range.closed(1000000000, Integer.MAX_VALUE).contains(value)) {
            return billionsAsString(value);
        }
        return super.asWords(value);
    }

    private String thousandAsString(Integer value) {
        Integer thousands = value / thousand;
        Integer remain = value % thousand;
        String word = baseNumbers.get(thousands * thousand).formFor(GenderType.MASCULINE);
        if (nothingComesAfter(remain)) {
            return word;
        }
        if (Range.closed(1, 19).contains(remain)) {
            return format("%s %s%s", word, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
        }
        return format("%s %s", word, asWords(remain));
    }

    private String thousandsAsString(Integer value) {
        Integer thousands = value / thousand;
        Integer remain = value % thousand;
        String word = hundredsToWordsConverter.asWords(thousands, GenderType.MASCULINE);
        if (nothingComesAfter(remain)) {
            return format("%s %s", word, wordForThousand);
        }
        if ((remain <= 100 && remain % 10 == 0) || Range.closed(1, 19).contains(remain)) {
            return format("%s %s %s%s", word, wordForThousand, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
        }
        return format("%s %s %s", word, wordForThousand, asWords(remain));
    }

    private String millionAsString(Integer value) {
        Integer millions = value / million;
        Integer remain = value % million;
        String word = baseNumbers.get(millions * million).formFor(GenderType.MASCULINE);
        if (nothingComesAfter(remain)) {
            return word;
        }
        if (remain % 100 == 0 || Range.closed(1, 19).contains(remain)) {
            return format("%s %s%s", word, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
        }
        return format("%s %s", word, asWords(remain));
    }

    private String millionsAsString(Integer value) {
        Integer millions = value / million;
        Integer remain = value % million;
        String word = hundredsToWordsConverter.asWords(millions, GenderType.MASCULINE);
        if (nothingComesAfter(remain)) {
            return format("%s %s", word, wordForMillion);
        }
        if ((remain <= 100 && remain % 10 == 0) || Range.closed(1, 19).contains(remain)) {
            return format("%s %s %s%s", word, wordForMillion, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
        }
        return format("%s %s %s", word, wordForMillion, asWords(remain));
    }

    private String billionsAsString(Integer value) {
        Integer billions = value / billion;
        Integer remain = value % billion;
        String word = baseNumbers.get(billions * billion).formFor(GenderType.MASCULINE);
        if (nothingComesAfter(remain)) {
            return word;
        }
        if (Range.closed(1, 19).contains(remain)) {
            return format("%s %s%s", word, hebrewValues.twoDigitsNumberSeparator(), asWords(remain));
        }
        return format("%s %s", word, asWords(remain));
    }

    private boolean nothingComesAfter(Integer other) {
        return other == 0;
    }

    protected HebrewValues hebrewValues() {
        return hebrewValues;
    }

    protected HebrewHundredsToWordsConverter hundredsToWordsConverter() {
        return (HebrewHundredsToWordsConverter) this.hundredsToWordsConverter;
    }
}
