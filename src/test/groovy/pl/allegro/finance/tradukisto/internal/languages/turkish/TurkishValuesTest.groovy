package pl.allegro.finance.tradukisto.internal.languages.turkish

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.turkishContainer

class TurkishValuesTest extends Specification {

    static converter = turkishContainer().getNumbersConverter()

    @Unroll
    def "should convert #value to '#words' in Turkish"() {
        expect:
        converter.asWords(value) == words

        where:
        value         | words
        0             | "Sıfır"
        1             | "Bir"
        2             | "İki"
        3             | "Üç"
        4             | "Dört"
        5             | "Beş"
        6             | "Altı"
        7             | "Yedi"
        8             | "Sekiz"
        9             | "Dokuz"

        11            | "On Bir"
        12            | "On İki"
        13            | "On Üç"
        14            | "On Dört"
        15            | "On Beş"
        16            | "On Altı"
        17            | "On Yedi"
        18            | "On Sekiz"
        19            | "On Dokuz"

        10            | "On"
        20            | "Yirmi"
        30            | "Otuz"
        40            | "Kırk"
        50            | "Elli"
        60            | "Altmış"
        70            | "Yetmiş"
        80            | "Seksen"
        90            | "Doksan"

        21            | "Yirmi Bir"
        37            | "Otuz Yedi"
        43            | "Kırk Üç"
        58            | "Elli Sekiz"
        69            | "Altmış Dokuz"
        76            | "Yetmiş Altı"
        82            | "Seksen İki"
        95            | "Doksan Beş"

        100           | "Yüz"
        200           | "İki Yüz"
        300           | "Üç Yüz"
        400           | "Dört Yüz"
        500           | "Beş Yüz"
        600           | "Altı Yüz"
        700           | "Yedi Yüz"
        800           | "Sekiz Yüz"
        900           | "Dokuz Yüz"

        111           | "Yüz On Bir"
        272           | "İki Yüz Yetmiş İki"
        387           | "Üç Yüz Seksen Yedi"
        448           | "Dört Yüz Kırk Sekiz"
        569           | "Beş Yüz Altmış Dokuz"
        625           | "Altı Yüz Yirmi Beş"
        782           | "Yedi Yüz Seksen İki"
        895           | "Sekiz Yüz Doksan Beş"
        999           | "Dokuz Yüz Doksan Dokuz"

        1_000         | "Bin"
        1_234         | "Bin İki Yüz Otuz Dört"
        2_000         | "İki Bin"
        3_000         | "Üç Bin"
        4_000         | "Dört Bin"
        5_000         | "Beş Bin"
        7_634         | "Yedi Bin Altı Yüz Otuz Dört"
        11_000        | "On Bir Bin"
        15_000        | "On Beş Bin"
        21_000        | "Yirmi Bir Bin"
        24_190        | "Yirmi Dört Bin Yüz Doksan"
        653_000       | "Altı Yüz Elli Üç Bin"
        123_454       | "Yüz Yirmi Üç Bin Dört Yüz Elli Dört"
        700_000       | "Yedi Yüz Bin"
        999_999       | "Dokuz Yüz Doksan Dokuz Bin Dokuz Yüz Doksan Dokuz"

        1_000_000     | "Bir Milyon"
        2_000_000     | "İki Milyon"
        5_000_000     | "Beş Milyon"
        23_437_219    | "Yirmi Üç Milyon Dört Yüz Otuz Yedi Bin İki Yüz On Dokuz"
        100_000_000   | "Yüz Milyon"
        123_456_789   | "Yüz Yirmi Üç Milyon Dört Yüz Elli Altı Bin Yedi Yüz Seksen Dokuz"
        322_089_890   | "Üç Yüz Yirmi İki Milyon Seksen Dokuz Bin Sekiz Yüz Doksan"

        1_000_000_000 | "Bir Milyar"
        2_147_483_647 | "İki Milyar Yüz Kırk Yedi Milyon Dört Yüz Seksen Üç Bin Altı Yüz Kırk Yedi"
    }
}
