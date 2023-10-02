package pl.allegro.finance.tradukisto.internal.languages.swedish

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.swedishContainer

class SwedishLongValuesTest extends Specification {

    static longConverter = swedishContainer().getLongConverter()

    @Unroll
    def "should convert Long #value to '#words' in Swedish"() {
        expect:
        longConverter.asWords(value) == words

        where:
        value               | words
        2147483648          | "två miljarder ett hundra och fyrtiosju miljoner fyra hundra och åttiotre tusen sex hundra och fyrtioåtta"
        3000000000          | "tre miljarder"
        4000000000          | "fyra miljarder"
        5000000000          | "fem miljarder"
        6000000000          | "sex miljarder"
        7000000000          | "sju miljarder"
        8000000000          | "åtta miljarder"
        9000000000          | "nio miljarder"
        9999999999          | "nio miljarder nio hundra och nittionio miljoner nio hundra och nittionio tusen nio hundra och nittionio"

        1000000000000       | "en biljon"
        2000000000000       | "två biljoner"
        2222222222222       | "två biljoner två hundra och tjugotvå miljarder två hundra och tjugotvå miljoner två hundra och tjugotvå tusen två hundra och tjugotvå"
        3000000000000       | "tre biljoner"
        4000000000000       | "fyra biljoner"
        5000000000000       | "fem biljoner"
        6000000000000       | "sex biljoner"
        7000000000000       | "sju biljoner"
        8000000000000       | "åtta biljoner"
        9000000000000       | "nio biljoner"
        9999999999999       | "nio biljoner nio hundra och nittionio miljarder nio hundra och nittionio miljoner nio hundra och nittionio tusen nio hundra och nittionio"

        1000000000000000    | "en biljard"
        2000000000000000    | "två biljarder"
        3000000000000000    | "tre biljarder"
        3333333333333333    | "tre biljarder tre hundra och trettiotre biljoner tre hundra och trettiotre miljarder tre hundra och trettiotre miljoner tre hundra och trettiotre tusen tre hundra och trettiotre"
        4000000000000000    | "fyra biljarder"
        5000000000000000    | "fem biljarder"
        6000000000000000    | "sex biljarder"
        7000000000000000    | "sju biljarder"
        8000000000000000    | "åtta biljarder"
        9000000000000000    | "nio biljarder"
        9999999999999999    | "nio biljarder nio hundra och nittionio biljoner nio hundra och nittionio miljarder nio hundra och nittionio miljoner nio hundra och nittionio tusen nio hundra och nittionio"

        1000000000000000000 | "en triljon"
        2000000000000000000 | "två triljoner"
        3000000000000000000 | "tre triljoner"
        4000000000000000000 | "fyra triljoner"
        4444444444444444444 | "fyra triljoner fyra hundra och fyrtiofyra biljarder fyra hundra och fyrtiofyra biljoner fyra hundra och fyrtiofyra miljarder fyra hundra och fyrtiofyra miljoner fyra hundra och fyrtiofyra tusen fyra hundra och fyrtiofyra"
        5000000000000000000 | "fem triljoner"
        6000000000000000000 | "sex triljoner"
        7000000000000000000 | "sju triljoner"
        8000000000000000000 | "åtta triljoner"
        9000000000000000000 | "nio triljoner"
        9223272036854775807 | "nio triljoner två hundra och tjugotre biljarder två hundra och sjuttiotvå biljoner trettiosex miljarder åtta hundra och femtiofyra miljoner sju hundra och sjuttiofem tusen åtta hundra och sju"
    }
}
