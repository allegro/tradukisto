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

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import pl.allegro.finance.tradukisto.MoneyConverters;
import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

/**
 * The class HebrewValues is a Hebrew language implementation of
 * {@link BaseValues}
 *
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.8.1
 * @since 1.8.1
 *
 */
public class HebrewValues implements BaseValues {

    private List<PluralForms> pluralForms;

    public HebrewValues() {
        super();
        pluralForms = new ArrayList<PluralForms>();
        pluralForms.add(new RegularPluralForms("", "", GenderType.FEMININE));
    }

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        try {
            return baseNumbersBuilder()
                    .put(0, new GenderForms(new String("\u05d0\u05e4\u05e1".getBytes("utf-8")),
                        new String("\u05d0\u05e4\u05e1".getBytes("utf-8")),
                        new String("\u05d0\u05e4\u05e1".getBytes("utf-8")),
                        new String("\u05d0\u05e4\u05e1".getBytes("utf-8"))))
                    .put(1, new GenderForms(new String("\u05d0\u05d7\u05d3".getBytes("utf-8")),
                        new String("\u05d0\u05d7\u05ea".getBytes("utf-8")),
                        new String("\u05d0\u05d7\u05d3".getBytes("utf-8")),
                        new String("\u05d0\u05d7\u05d3".getBytes("utf-8"))))
                    .put(2, new GenderForms(new String("\u05b9\u05e9\u05e0\u05d9\u05d9\u05dd".getBytes("utf-8")),
                        new String("\u05e9\u05ea\u05d9\u05d9\u05dd".getBytes("utf-8")),
                        new String("\u05b9\u05e9\u05e0\u05d9\u05d9\u05dd".getBytes("utf-8")),
                        new String("\u05b9\u05e9\u05e0\u05d9\u05d9\u05dd".getBytes("utf-8"))))
                    .put(3, new GenderForms(new String("\u05e9\u05dc\u05d5\u05e9\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05dc\u05d5\u05e9".getBytes("utf-8")),
                        new String("\u05e9\u05dc\u05d5\u05e9\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05dc\u05d5\u05e9\u05d4".getBytes("utf-8"))))
                    .put(4, new GenderForms(new String("\u05d0\u05e8\u05d1\u05e2\u05d4".getBytes("utf-8")),
                        new String("\u05d0\u05e8\u05d1\u05e2".getBytes("utf-8")),
                        new String("\u05d0\u05e8\u05d1\u05e2\u05d4".getBytes("utf-8")),
                        new String("\u05d0\u05e8\u05d1\u05e2\u05d4".getBytes("utf-8"))))
                    .put(5, new GenderForms(new String("\u05d7\u05de\u05d9\u05e9\u05d4".getBytes("utf-8")),
                        new String("\u05d7\u05de\u05e9".getBytes("utf-8")),
                        new String("\u05d7\u05de\u05d9\u05e9\u05d4".getBytes("utf-8")),
                        new String("\u05d7\u05de\u05d9\u05e9\u05d4".getBytes("utf-8"))))
                    .put(6, new GenderForms(new String("\u05e9\u05d9\u05e9\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05e9".getBytes("utf-8")),
                        new String("\u05e9\u05d9\u05e9\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05d9\u05e9\u05d4".getBytes("utf-8"))))
                    .put(7, new GenderForms(new String("\u05e9\u05d1\u05e2\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05d1\u05e2".getBytes("utf-8")),
                        new String("\u05e9\u05d1\u05e2\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05d1\u05e2\u05d4".getBytes("utf-8"))))
                    .put(8, new GenderForms(new String("\u05e9\u05de\u05d5\u05e0\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05de\u05d5\u05e0\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05de\u05d5\u05e0\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05de\u05d5\u05e0\u05d4".getBytes("utf-8"))))
                    .put(9, new GenderForms(new String("\u05ea\u05e9\u05e2\u05d4".getBytes("utf-8")),
                        new String("\u05ea\u05e9\u05e2".getBytes("utf-8")),
                        new String("\u05ea\u05e9\u05e2\u05d4".getBytes("utf-8")),
                        new String("\u05ea\u05e9\u05e2\u05d4".getBytes("utf-8"))))
                    .put(10, new GenderForms(new String("\u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05e2\u05e9\u05e8\u05d4".getBytes("utf-8"))))
                    .put(11, new GenderForms(new String("\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05d0\u05d7\u05ea \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(12, new GenderForms(new String("\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05ea\u05d9\u05dd \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(13, new GenderForms(new String("\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05dc\u05d5\u05e9 \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(14, new GenderForms(new String("\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05d0\u05e8\u05d1\u05e2 \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(15, new GenderForms(new String("\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05d7\u05de\u05e9 \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(16, new GenderForms(new String("\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05e9 \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(17, new GenderForms(new String("\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05d1\u05e2 \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(18, new GenderForms(new String("\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(19, new GenderForms(new String("\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05ea\u05e9\u05e2 \u05e2\u05e9\u05e8\u05d4".getBytes("utf-8")),
                        new String("\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8")),
                        new String("\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8".getBytes("utf-8"))))
                    .put(20, new String("\u05e2\u05e9\u05e8\u05d9\u05dd".getBytes("utf-8")))
                    .put(30, new String("\u05e9\u05dc\u05d5\u05e9\u05d9\u05dd".getBytes("utf-8")))
                    .put(40, new String("\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd".getBytes("utf-8")))
                    .put(50, new String("\u05d7\u05de\u05d9\u05e9\u05d9\u05dd".getBytes("utf-8")))
                    .put(60, new String("\u05e9\u05d9\u05e9\u05d9\u05dd".getBytes("utf-8")))
                    .put(70, new String("\u05e9\u05d1\u05e2\u05d9\u05dd".getBytes("utf-8")))
                    .put(80, new String("\u05e9\u05de\u05d5\u05e0\u05d9\u05dd".getBytes("utf-8")))
                    .put(90, new String("\u05ea\u05e9\u05e2\u05d9\u05dd".getBytes("utf-8")))
                    .put(100, new String("\u05de\u05d0\u05d4".getBytes("utf-8")))
                    .put(200, new String("\u05de\u05d0\u05ea\u05d9\u05d9\u05dd".getBytes("utf-8")))
                    .put(300, new String("\u05e9\u05dc\u05d5\u05e9 \u05de\u05d0\u05d5\u05ea".getBytes("utf-8")))
                    .put(400, new String("\u05d0\u05e8\u05d1\u05e2 \u05de\u05d0\u05d5\u05ea".getBytes("utf-8")))
                    .put(500, new String("\u05d7\u05de\u05e9 \u05de\u05d0\u05d5\u05ea".getBytes("utf-8")))
                    .put(600, new String("\u05e9\u05e9 \u05de\u05d0\u05d5\u05ea".getBytes("utf-8")))
                    .put(700, new String("\u05e9\u05d1\u05e2 \u05de\u05d0\u05d5\u05ea".getBytes("utf-8")))
                    .put(800, new String("\u05e9\u05de\u05d5\u05e0\u05d4 \u05de\u05d0\u05d5\u05ea".getBytes("utf-8")))
                    .put(900, new String("\u05ea\u05e9\u05e2 \u05de\u05d0\u05d5\u05ea".getBytes("utf-8")))
                    .put(1000,
                            new GenderForms(new String("\u05d0\u05dc\u05e3".getBytes("utf-8")),
                                new String("\u05d0\u05dc\u05e3".getBytes("utf-8")),
                                new String("\u05d0\u05dc\u05e3".getBytes("utf-8")),
                                new String("\u05d0\u05dc\u05e3".getBytes("utf-8"))))
                    .put(2000, new String("\u05d0\u05dc\u05e4\u05d9\u05d9\u05dd".getBytes("utf-8")))
                    .put(3000, new String("\u05e9\u05dc\u05d5\u05e9\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(4000, new String("\u05d0\u05e8\u05d1\u05e2\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(5000, new String("\u05d7\u05de\u05e9\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(6000, new String("\u05e9\u05e9\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(7000, new String("\u05e9\u05d1\u05e2\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(8000, new String("\u05e9\u05de\u05d5\u05e0\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(9000, new String("\u05ea\u05e9\u05e2\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(10000, new String("\u05e2\u05e9\u05e8\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd".getBytes("utf-8")))
                    .put(11000, new String("\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(12000, new String("\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(13000, new String("\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(14000, new String("\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(15000, new String("\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(16000, new String("\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(17000, new String("\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(18000, new String("\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(19000, new String("\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3".getBytes("utf-8")))
                    .put(1000000,
                            new GenderForms(new String("\u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")),
                                new String("\u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")),
                                new String("\u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")),
                                new String("\u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8"))))
                    .put(2000000, new String("\u05e9\u05e0\u05d9 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(3000000, new String("\u05e9\u05dc\u05d5\u05e9\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(4000000, new String("\u05d0\u05e8\u05d1\u05e2\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(5000000, new String("\u05d7\u05de\u05d9\u05e9\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(6000000, new String("\u05e9\u05d9\u05e9\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(7000000, new String("\u05e9\u05d1\u05e2\u05d4 \u05de\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(8000000, new String("\u05e9\u05de\u05d5\u05e0\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(9000000, new String("\u05ea\u05e9\u05e2\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(10000000, new String("\u05e2\u05e9\u05e8\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df".getBytes("utf-8")))
                    .put(1000000000, new String("\u05de\u05d9\u05dc\u05d9\u05d0\u05e8\u05d3".getBytes("utf-8")))
                    .put(2000000000, new String("\u05e9\u05e0\u05d9 \u05de\u05d9\u05dc\u05d9\u05d0\u05e8\u05d3".getBytes("utf-8")))
                    .build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PluralForms> pluralForms() {
        return pluralForms;
    }

    public void setPluralForms(GenderType genderType) {
        pluralForms.clear();
        pluralForms.add(new RegularPluralForms("", "", genderType));
    }

    @Override
    public String currency() {
        return "\u20aa";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return '\u05d5';
    }

    public Map<Integer, String> exceptions() {
        return ImmutableMap.<Integer, String>builder().put(1000, "\u05d0\u05dc\u05e3").build();
    }

    public String decimalPrefix() {
        return "\u05d5";
    }

    public String decimalSuffix() {
        return "\u05d0\u05d2\u05d5\u05e8\u05d5\u05ea";
    }

    public static void main(String[] args) {
        MoneyConverters converter = MoneyConverters.HEBREW_BANKING_MONEY_VALUE;
        System.out.println(converter.asWords(new BigDecimal("1.57")));
    }
}
