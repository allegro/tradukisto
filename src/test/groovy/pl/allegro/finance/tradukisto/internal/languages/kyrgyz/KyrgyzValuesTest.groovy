package pl.allegro.finance.tradukisto.internal.languages.kyrgyz

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.kyrgyzContainer

class KyrgyzValuesTest extends Specification {

    static intConverter = kyrgyzContainer().getIntegerConverter()
    static longConverter = kyrgyzContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Kazakh"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value         | words

        0             | "нөл"
        1             | "бир"
        2             | "эки"
        3             | "үч"
        4             | "төрт"
        5             | "беш"
        6             | "алты"
        7             | "жети"
        8             | "сегиз"
        9             | "тогуз"
        10            | "он"

        11            | "он бир"
        12            | "он эки"
        13            | "он үч"
        14            | "он төрт"
        15            | "он беш"
        16            | "он алты"
        17            | "он жети"
        18            | "он сегиз"
        19            | "он тогуз"

        20            | "жыйырма"
        30            | "отуз"
        40            | "кырк"
        50            | "элүү"
        60            | "алтымыш"
        70            | "жетимиш"
        80            | "сексен"
        90            | "токсон"
        100           | "жүз"

        21            | "жыйырма бир"
        25            | "жыйырма беш"
        34            | "отуз төрт"
        37            | "отуз жети"
        43            | "кырк үч"
        51            | "элүү бир"
        58            | "элүү сегиз"
        69            | "алтымыш тогуз"
        76            | "жетимиш алты"
        82            | "сексен эки"
        89            | "сексен тогуз"
        95            | "токсон беш"
        
        200           | "эки жүз"
        300           | "үч жүз"
        400           | "төрт жүз"
        500           | "беш жүз"
        600           | "алты жүз"
        700           | "жети жүз"
        800           | "сегиз жүз"
        900           | "тогуз жүз"
        1000          | "бир миң"

        111           | "жүз он бир"
        144           | "жүз кырк төрт"
        233           | "эки жүз отуз үч"
        272           | "эки жүз жетимиш эки"
        377           | "үч жүз жетимиш жети"
        387           | "үч жүз сексен жети"
        448           | "төрт жүз кырк сегиз"
        569           | "беш жүз алтымыш тогуз"
        610           | "алты жүз он"
        625           | "алты жүз жыйырма беш"
        777           | "жети жүз жетимиш жети"
        782           | "жети жүз сексен эки"
        895           | "сегиз жүз токсон беш"
        987           | "тогуз жүз сексен жети"
        999           | "тогуз жүз токсон тогуз"
        
        1_597         | "бир миң беш жүз токсон жети"
        2_584         | "эки миң беш жүз сексен төрт"
        4_181         | "төрт миң жүз сексен бир"
        6_765         | "алты миң жети жүз алтымыш беш"
        10_946        | "он миң тогуз жүз кырк алты"
        17_711        | "он жети миң жети жүз он бир"
        28_657        | "жыйырма сегиз миң алты жүз элүү жети"
        46_368        | "кырк алты миң үч жүз алтымыш сегиз"
        75_025        | "жетимиш беш миң жыйырма беш"
        121_393       | "жүз жыйырма бир миң үч жүз токсон үч"
        196_418       | "жүз токсон алты миң төрт жүз он сегиз"
        317_811       | "үч жүз он жети миң сегиз жүз он бир"
        514_229       | "беш жүз он төрт миң эки жүз жыйырма тогуз"
        832_040       | "сегиз жүз отуз эки миң кырк"
        
        1_000_000     | "бир миллион"
        2_000_000     | "эки миллион"
        5_000_000     | "беш миллион"

        1_346_269     | "бир миллион үч жүз кырк алты миң эки жүз алтымыш тогуз"
        2_178_309     | "эки миллион жүз жетимиш сегиз миң үч жүз тогуз"
        7_211_000     | "жети миллион эки жүз он бир миң"
        23_437_219    | "жыйырма үч миллион төрт жүз отуз жети миң эки жүз он тогуз"
        100_000_000   | "жүз миллион"
        123_456_789   | "жүз жыйырма үч миллион төрт жүз элүү алты миң жети жүз сексен тогуз"
        322_089_890   | "үч жүз жыйырма эки миллион сексен тогуз миң сегиз жүз токсон"

        1_000_000_000 | "бир миллиард"
        1_836_311_903 | "бир миллиард сегиз жүз отуз алты миллион үч жүз он бир миң тогуз жүз үч"
        2_147_483_647 | "эки миллиард жүз кырк жети миллион төрт жүз сексен үч миң алты жүз кырк жети"
    }

    @Ignore("Needs kyrgyz long converter and values for trillion, quadrillion, quintillion")
    @Unroll
    def "should convert long #value to '#words' in Kyrgyz"() {
        expect:
        longConverter.asWords(value) == words

        where:
        value                     | words
        5_000_000_000             | ""

        1_000_000_000_000         | ""
        2_000_000_000_000         | ""
        5_000_000_000_000         | ""

        1_000_000_000_000_000     | ""
        2_000_000_000_000_000     | ""
        5_000_000_000_000_000     | ""

        1_000_000_000_000_000_000 | ""
        2_000_000_000_000_000_000 | ""
        Long.MAX_VALUE            | ""
    }
}
