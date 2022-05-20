package pl.allegro.finance.tradukisto.internal.support

import pl.allegro.finance.tradukisto.internal.languages.GenderForms
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder

class BaseNumbersBuilderTest extends Specification {

    def builder

    void setup() {
        builder = baseNumbersBuilder()
    }

    def 'should throw NumberAlreadyMappedException when trying to remap a number with String'() {
        given:
        builder.put(1, "some form")

        when:
        builder.put(1, "some other form")

        then:
        thrown(NumberAlreadyMappedException)
    }

    def 'should throw NumberAlreadyMappedException when trying to remap a number with GenderForms'() {
        given:
            builder.put(1, new GenderForms("some form"))

        when:
            builder.put(1, new GenderForms("some other form"))

        then:
            thrown(NumberAlreadyMappedException)
    }

    def 'should throw NumberAlreadyMappedException when trying to remap a number from String to GenderForms'() {
        given:
        builder.put(1, "some form")

        when:
        builder.put(1, new GenderForms("some other form"))

        then:
        thrown(NumberAlreadyMappedException)
    }

    def 'should throw NumberAlreadyMappedException when trying to remap a number from GenderForms to String'() {
        given:
        builder.put(1, new GenderForms("some other form"))

        when:
        builder.put(1, "some form")

        then:
        thrown(NumberAlreadyMappedException)
    }
}
