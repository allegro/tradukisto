package pl.allegro.finance.tradukisto.internal.support

import pl.allegro.finance.tradukisto.internal.support.NumberChunking
import spock.lang.Specification

class NumberChunkingTest extends Specification {

    def splitter = new NumberChunking()

    def "should split number to three digit parts"() {
        expect:
        splitter.chunk(value) == chunks

        where:
        value     | chunks
        0         | []
        123       | [123]
        1234      | [1, 234]
        123000789 | [123, 0, 789]
        123456789 | [123, 456, 789]
        123000000 | [123, 0, 0]
        12300000  | [12, 300, 0]
    }
}
