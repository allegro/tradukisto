package pl.allegro.finance.tradukisto.internal.converters
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter
import pl.allegro.finance.tradukisto.internal.languages.GenderType
import pl.allegro.finance.tradukisto.internal.languages.polish.PolishValues
import spock.lang.Specification

class IntegerToWordsConverterTest extends Specification {

    def hundredsToWordsConverter = Stub(GenderAwareIntegerToStringConverter)
    def converter = new IntegerToWordsConverter(hundredsToWordsConverter, new PolishValues().pluralForms())

    def setup() {
        hundredsToWordsConverter.asWords(0, GenderType.NON_APPLICABLE) >> "zero"
        hundredsToWordsConverter.asWords(1, GenderType.NON_APPLICABLE) >> "jeden"
        hundredsToWordsConverter.asWords(2, GenderType.NON_APPLICABLE) >> "dwa"
        hundredsToWordsConverter.asWords(3, GenderType.NON_APPLICABLE) >> "trzy"
    }

    def "should convert 0"() {
        expect:
        converter.asWords(0) == "zero"
    }

    def "should convert simply value"() {
        expect:
        converter.asWords(1) == "jeden"
    }

    def "should convert complex value"() {
        expect:
        converter.asWords(1002003) == "jeden milion dwa tysiące trzy"
    }

    def "should throw IllegalArgumentException when hundredsToWordsConverter can't convert given value"() {
        given:
        hundredsToWordsConverter.asWords(4, GenderType.NON_APPLICABLE) >> { throw new IllegalArgumentException() }

        when:
        converter.asWords(1002004)

        then:
        thrown(IllegalArgumentException)
    }
}
