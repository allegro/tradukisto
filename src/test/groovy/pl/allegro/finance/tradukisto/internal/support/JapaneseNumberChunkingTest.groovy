package pl.allegro.finance.tradukisto.internal.support

import spock.lang.Specification

class JapaneseNumberChunkingTest extends Specification {

    def splitter = new JapaneseNumberChunking()

    def "should split number to four digit parts as per japanese standards"() {
        expect:
        splitter.chunk(value) == chunks

        where:
        value          | chunks
        0              | []
        123            | [123]
        1234           | [1234]
        123000789      | [1, 2300, 789]
        123456789      | [1, 2345, 6789]
        123000000      | [1, 2300, 0000]
        12300000       | [1230, 0000]
        Long.MAX_VALUE | [922, 3372, 368, 5477, 5807]
    }
}
