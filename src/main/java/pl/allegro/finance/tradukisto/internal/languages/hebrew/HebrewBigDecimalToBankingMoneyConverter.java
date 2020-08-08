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

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;

import java.math.BigDecimal;

import pl.allegro.finance.tradukisto.internal.BigDecimalToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;

/**
 * The class HebrewBigDecimalToBankingMoneyConverter converts monetary values to
 * hebrew words
 *
 * @apiNote values are rounded down to 2 decimal places
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.8.1
 * @since 1.8.1
 *
 */
public class HebrewBigDecimalToBankingMoneyConverter implements BigDecimalToStringConverter {
    private final String prefix, suffix, currency;

    private final HebrewIntegerToWordsConverter converter;

    public HebrewBigDecimalToBankingMoneyConverter(HebrewIntegerToWordsConverter converter, HebrewValues values) {
        this.converter = converter;
        values.setPluralForms(GenderType.MASCULINE);
        prefix = values.decimalPrefix();
        suffix = values.decimalSuffix();
        currency = values.currency();
    }

    @Override
    public String asWords(BigDecimal value) {
        BigDecimal scaled = value.setScale(2, BigDecimal.ROUND_DOWN);
        validate(scaled);
        Integer units = scaled.intValue();
        int decimal = scaled.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();
        if (decimal <= 0) {
            return format("%s %s", currency, asWord(units, GenderType.MASCULINE));
        }
        return format("%s %s %s%s %s", asWord(units, GenderType.MASCULINE), currency, prefix, asWord(decimal, GenderType.FEMININE),
                suffix);
    }

    private void validate(BigDecimal value) {
        // checkArgument(value.scale() <= MAX_DECIMAL_PLACES, "can't transform more than
        // %s decimal places for value %s",MAX_DECIMAL_PLACES, value);
        checkArgument(valueLessThanIntMax(value), "can't transform numbers greater than Integer.MAX_VALUE for value %s", value);
        checkArgument(valueGreaterThanOrEqualToZero(value), "can't transform negative numbers for value %s", value);
    }

    private boolean valueLessThanIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) == -1;
    }

    private boolean valueGreaterThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }

    private String asWord(Integer value, GenderType genderType) {
        converter.hebrewValues().setPluralForms(genderType);
        String word = converter.asWords(value);
        converter.hebrewValues().setPluralForms(GenderType.FEMININE);
        return word;
    }
}
