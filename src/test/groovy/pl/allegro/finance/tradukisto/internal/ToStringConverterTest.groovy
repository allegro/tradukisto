package pl.allegro.finance.tradukisto.internal

import spock.lang.Specification
import spock.lang.Unroll
import pl.allegro.finance.tradukisto.internal.languages.portuguese.PortugueseThousandToWordsConverter
import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class ToStringConverterTest extends Specification {

    static converter = new ToStringConverter()
    static integerToStringConverter = new PortugueseThousandToWordsConverter([1: genderForm("um")], [:])

    @Unroll
    def "should convert from IntegerToStringConverter to GenderAwareIntegerToStringConverter"() {
        expect:
        converter.toGenderAwareInteger(integerToStringConverter) instanceof GenderAwareIntegerToStringConverter
    }
}
