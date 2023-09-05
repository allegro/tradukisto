package pl.allegro.finance.tradukisto.internal.support

import spock.lang.Specification

class IndianNumberChunkingTest extends Specification {

    def splitter = new IndianNumberChunking()

    def "should split number to three digit and 2 digit parts as per indian standards"() {
        expect:
        splitter.chunk(value) == chunks

        where:
        value          | chunks
        0              | []
        123            | [123]
        1234           | [1, 234]
        123000789      | [12, 30, 0, 789]
        123456789      | [12, 34, 56, 789]
        123000000      | [12, 30, 0, 0]
        12300000       | [1, 23, 0, 0]
        Long.MAX_VALUE | [92, 23, 37, 20, 36, 85, 47, 75, 807]
    }
}
