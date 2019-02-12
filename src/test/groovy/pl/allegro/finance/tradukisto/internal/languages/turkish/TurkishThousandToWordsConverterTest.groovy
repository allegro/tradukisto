package pl.allegro.finance.tradukisto.internal.languages.turkish

import pl.allegro.finance.tradukisto.internal.languages.GenderType
import pl.allegro.finance.tradukisto.internal.languages.german.GermanThousandToWordsConverter
import spock.lang.Specification

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm

class TurkishThousandToWordsConverterTest extends Specification {

    def "should convert value from list of base values"() {
        given:
        def converter = new TurkishThousandToWordsConverter([1: genderForm("Bir")])

        expect:
        converter.asWords(1, GenderType.NON_APPLICABLE) == "Bir"
    }

    def "should convert two digits number"() {
        given:
        def converter = new TurkishThousandToWordsConverter([20: genderForm("Yirmi"), 1: genderForm("Bir")])

        expect:
        converter.asWords(21, GenderType.NON_APPLICABLE) == "YirmiBir"
    }

    def "should convert three digits number"() {
        given:
        def converter = new TurkishThousandToWordsConverter([600: genderForm("AltıYüz"), 60: genderForm("Altmış"), 6: genderForm("Altı")])

        expect:
        converter.asWords(666, GenderType.NON_APPLICABLE) == "AltıYüzAltmışAltı"
    }

    def "should convert four digits numbers"() {
        given:
        def converter = new TurkishThousandToWordsConverter([1000: genderForm("Bin"),200: genderForm("İkiYüz"),50: genderForm("Elli"),4: genderForm("Dört")])

        expect:
        converter.asWords(1254, GenderType.NON_APPLICABLE) == "BinİkiYüzElliDört"
    }

    def "should convert four digits number that one thousand"() {
        given:
        def converter = new TurkishThousandToWordsConverter([1000: genderForm("Bin")])

        expect:
        converter.asWords(1000, GenderType.NON_APPLICABLE) == "Bin"
    }

    def "should convert more that three digits number"() {
        given:
        def converter = new TurkishThousandToWordsConverter([600: genderForm("AltıYüz"), 60: genderForm("Altmış"), 6: genderForm("Altı")])

        expect:
        converter.asWords(66666, GenderType.NON_APPLICABLE) == "AltmışAltıBinAltıYüzAltmışAltı"
    }

    def "should throw IllegalArgumentException when given number is not supported"() {
        given:
        def converter = new TurkishThousandToWordsConverter([1: genderForm("Bir")])

        when:
        converter.asWords(2, GenderType.NON_APPLICABLE)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Can't convert 2"
    }
}
