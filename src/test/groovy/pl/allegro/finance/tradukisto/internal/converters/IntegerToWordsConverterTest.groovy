package pl.allegro.finance.tradukisto.internal.converters
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter
import pl.allegro.finance.tradukisto.internal.languages.english.EnglishValues
import spock.lang.Specification

class IntegerToWordsConverterTest extends Specification {

    def hundredsToWordsConverter = Stub(GenderAwareIntegerToStringConverter)
    def converter = new IntegerToWordsConverter(hundredsToWordsConverter, new EnglishValues().pluralForms())

    def setup() {
        hundredsToWordsConverter.asWords(0, _) >> "zero"
        hundredsToWordsConverter.asWords(1, _) >> "one"
        hundredsToWordsConverter.asWords(2, _) >> "two"
        hundredsToWordsConverter.asWords(3, _) >> "three"
    }

    def "should convert 0"() {
        expect:
        converter.asWords(0) == "zero"
    }

    def "should convert simply value"() {
        expect:
        converter.asWords(1) == "one"
    }

    def "should convert complex value"() {
        expect:
        converter.asWords(1002003) == "one million two thousand three"
    }

    def "should throw IllegalArgumentException when hundredsToWordsConverter can't convert given value"() {
        given:
        hundredsToWordsConverter.asWords(4, _) >> { throw new IllegalArgumentException() }

        when:
        converter.asWords(1002004)

        then:
        thrown(IllegalArgumentException)
    }

    def "should throw IllegalArgumentException when value is negative"() {
        when:
        converter.asWords(-1)

        then:
        thrown(IllegalArgumentException)
    }
}
