package pl.allegro.finance.tradukisto.internal.support

import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder

class BaseNumbersBuilderTest extends Specification {

    def builder = baseNumbersBuilder()

    def 'should throw NumberAlreadyMappedException when trying to remap a number'() {
        given:
            builder.put(1, "some form")
        when:
            builder.put(1, "some other form")
        then:
            thrown(NumberAlreadyMappedException)
    }
}
