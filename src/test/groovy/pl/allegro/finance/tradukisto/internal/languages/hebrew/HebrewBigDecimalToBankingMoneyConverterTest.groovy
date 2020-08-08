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
package pl.allegro.finance.tradukisto.internal.languages.hebrew

import pl.allegro.finance.tradukisto.MoneyConverters
import pl.allegro.finance.tradukisto.ValueConverters
import spock.lang.Specification
import spock.lang.Unroll

/**
 * The class HebrewBigDecimalToBankingMoneyConverterTest is a test case for the functionality of the HebrewBigDecimalToBankingMoneyConverter
 *  
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.8.1
 * @since 1.8.1 
 */
class HebrewBigDecimalToBankingMoneyConverterTest extends Specification {

    static converter = MoneyConverters.HEBREW_BANKING_MONEY_VALUE;

    @Unroll
    def "should convert whole numbers monetary #value to '#words' in Hebrew"() {
        expect:
        converter.asWords(value) == words

        where:
        value | words
        0     | "\u20aa \u05d0\u05e4\u05e1"
        1     | "\u20aa \u05d0\u05d7\u05d3"
        1234  | "\u20aa \u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4"
        1000  | "\u20aa \u05d0\u05dc\u05e3"
        10000 | "\u20aa \u05e2\u05e9\u05e8\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd"
    }

    @Unroll
    def "should convert 1 digit monetary #value to '#words' in Hebrew"() {
        expect:
        converter.asWords(value) == words

        where:
        value | words
        1.4   | "\u05d0\u05d7\u05d3 \u20aa \u05d5\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1.44  | "\u05d0\u05d7\u05d3 \u20aa \u05d5\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1.46  | "\u05d0\u05d7\u05d3 \u20aa \u05d5\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
    }

    @Unroll
    def "should convert 4 digits monetary #value to '#words' in Hebrew"() {
        expect:
        converter.asWords(value) == words

        where:
        value      | words
        1234.56    | "\u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4 \u20aa \u05d5\u05d7\u05de\u05d9\u05e9\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1234.564   | "\u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4 \u20aa \u05d5\u05d7\u05de\u05d9\u05e9\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1234.565   | "\u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4 \u20aa \u05d5\u05d7\u05de\u05d9\u05e9\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1234.566   | "\u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4 \u20aa \u05d5\u05d7\u05de\u05d9\u05e9\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
        1234.56666 | "\u05d0\u05dc\u05e3 \u05de\u05d0\u05ea\u05d9\u05d9\u05dd \u05e9\u05dc\u05d5\u05e9\u05d9\u05dd \u05d5\u05d0\u05e8\u05d1\u05e2\u05d4 \u20aa \u05d5\u05d7\u05de\u05d9\u05e9\u05d9\u05dd \u05d5\u05e9\u05e9 \u05d0\u05d2\u05d5\u05e8\u05d5\u05ea"
    }
    
    @Unroll
    def "should throw exception when value is grater than INTEGER.MAX_VALUE"() {
        when:
        converter.asWords(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE))

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform numbers greater than Integer.MAX_VALUE for value 2147483648.00"
    }
    
    @Unroll
    def "should throw exception when value is negative"() {
        when:
        converter.asWords(new BigDecimal(-1))

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "can't transform negative numbers for value -1.00"
    }
}

