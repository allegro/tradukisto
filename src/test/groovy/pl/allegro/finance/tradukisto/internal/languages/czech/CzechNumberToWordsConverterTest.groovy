package pl.allegro.finance.tradukisto.internal.languages.czech

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter
import spock.lang.Specification

class CzechNumberToWordsConverterTest extends Specification {

    def smallNumbersConverter = Stub(IntegerToStringConverter)
    def bigNumbersConverter = Stub(IntegerToStringConverter)
    def exceptions = [2: "dvě"]
    def converter

    def setup() {
        bigNumbersConverter.asWords(123456) >> "sto dvacet tři milionů čtyři sta padesát ąest tisíc"
        smallNumbersConverter.asWords(789) >> "sedm set osmdesát devět"
        smallNumbersConverter.asWords(0) >> "nula"
        converter = new CzechIntegerToWordsConverter(bigNumbersConverter, smallNumbersConverter, exceptions)
    }

    def "should convert zero"() {
        expect:
        converter.asWords(0) == "nula"
    }

    def "should convert only big number"() {
        expect:
        converter.asWords(123456000) == "sto dvacet tři milionů čtyři sta padesát ąest tisíc"
    }

    def "should convert only small number"() {
        expect:
        converter.asWords(789) == "sedm set osmdesát devět"
    }

    def "should convert complex number"() {
        expect:
        converter.asWords(123456789) == "sto dvacet tři milionů čtyři sta padesát ąest tisíc sedm set osmdesát devět"
    }

    def "should convert excluded value"() {
        expect:
        converter.asWords(2) == "dvě"
    }
}
