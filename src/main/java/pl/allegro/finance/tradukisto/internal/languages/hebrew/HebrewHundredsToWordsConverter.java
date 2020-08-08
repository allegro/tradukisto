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
 * WITHOUT WARRANTcurrencyIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.allegro.finance.tradukisto.internal.languages.hebrew;

import static java.lang.String.format;

import java.util.Map;

import com.google.common.collect.Range;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

/**
 * The class HebrewHundredsToWordsConverter is a Hebrew langauge specific
 * implementation of {@link GenderAwareIntegerToStringConverter}
 *
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.8.1
 * @since 1.8.1
 *
 */
public class HebrewHundredsToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseNumbers;
    private final char twoDigitsNumberSeparator;
    private final Integer ten = 10;
    private final Integer hundred = 100;

    public HebrewHundredsToWordsConverter(HebrewValues hebrewValues) {
        this.baseNumbers = hebrewValues.baseNumbers();
        this.twoDigitsNumberSeparator = hebrewValues.twoDigitsNumberSeparator();
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        // System.out.printf("HebrewHundredsToWordsConverter.asWords() %s,%d%n",
        // genderType, value);
        if (baseNumbers.containsKey(value)) {
            return baseNumbers.get(value).formFor(genderType);
        } else if (Range.closed(10, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        } else if (Range.closed(100, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        }
        throw new IllegalArgumentException(format("Can't convert %s", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        // System.out.printf("HebrewHundredsToWordsConverter.twoDigitsNumberAsString()
        // %s,%d%n", genderType, value);
        Integer units = value % ten;
        Integer tens = value - units;
        // System.out.printf("HebrewHundredsToWordsConverter.twoDigitsNumberAsString()
        // TENS %s UNITS %d%n", tens, units);
        return format("%s %s%s", asWords(tens, genderType), twoDigitsNumberSeparator, asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        // System.out.printf("HebrewHundredsToWordsConverter.threeDigitsNumberAsString()
        // %s,%d%n", genderType, value);
        Integer tensWithUnits = value % hundred;
        Integer hundreds = value - tensWithUnits;
        // System.out.printf("HebrewHundredsToWordsConverter.threeDigitsNumberAsString()
        // HUNDREDS %s TENS WITH UNITS %d%n", hundreds,tensWithUnits);
        if (tensWithUnits % ten == 0 || Range.closed(1, 19).contains(tensWithUnits)) {
            return String
                    .format("%s %s%s", asWords(hundreds, genderType), twoDigitsNumberSeparator, asWords(tensWithUnits, genderType));
        }
        return String.format("%s %s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }
}
