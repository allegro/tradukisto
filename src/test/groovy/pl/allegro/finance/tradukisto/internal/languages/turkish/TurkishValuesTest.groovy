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

        11            | "OnBir"
        12            | "Onİki"
        13            | "OnÜç"
        14            | "OnDört"
        15            | "OnBeş"
        16            | "OnAltı"
        17            | "OnYedi"
        18            | "OnSekiz"
        19            | "OnDokuz"

        10            | "On"
        20            | "Yirmi"
        30            | "Otuz"
        40            | "Kırk"
        50            | "Elli"
        60            | "Altmış"
        70            | "Yetmiş"
        80            | "Seksen"
        90            | "Doksan"

        21            | "YirmiBir"
        37            | "OtuzYedi"
        43            | "KırkÜç"
        58            | "ElliSekiz"
        69            | "AltmışDokuz"
        76            | "YetmişAltı"
        82            | "Seksenİki"
        95            | "DoksanBeş"

        100           | "Yüz"
        200           | "İkiYüz"
        300           | "ÜçYüz"
        400           | "DörtYüz"
        500           | "BeşYüz"
        600           | "AltıYüz"
        700           | "YediYüz"
        800           | "SekizYüz"
        900           | "DokuzYüz"

        111           | "YüzOnBir"
        272           | "İkiYüzYetmişİki"
        387           | "ÜçYüzSeksenYedi"
        448           | "DörtYüzKırkSekiz"
        569           | "BeşYüzAltmışDokuz"
        625           | "AltıYüzYirmiBeş"
        782           | "YediYüzSeksenİki"
        895           | "SekizYüzDoksanBeş"
        999           | "DokuzYüzDoksanDokuz"

        1_000         | "Bin"
        1_234         | "BinİkiYüzOtuzDört"
        2_000         | "İkiBin"
        3_000         | "ÜçBin"
        4_000         | "DörtBin"
        5_000         | "BeşBin"
        7_634         | "YediBinAltıYüzOtuzDört"
        11_000        | "OnBirBin"
        15_000        | "OnBeşBin"
        21_000        | "YirmiBirBin"
        24_190        | "YirmiDörtBinYüzDoksan"
        653_000       | "AltıYüzElliÜçBin"
        123_454       | "YüzYirmiÜçBinDörtYüzElliDört"
        700_000       | "YediYüzBin"
        999_999       | "DokuzYüzDoksanDokuzBinDokuzYüzDoksanDokuz"

        1_000_000     | "BirMilyon"
        2_000_000     | "İkiMilyon"
        5_000_000     | "BeşMilyon"
        23_437_219    | "YirmiÜçMilyonDörtYüzOtuzYediBinİkiYüzOnDokuz"
        100_000_000   | "YüzMilyon"
        123_456_789   | "YüzYirmiÜçMilyonDörtYüzElliAltıBinYediYüzSeksenDokuz"
        322_089_890   | "ÜçYüzYirmiİkiMilyonSeksenDokuzBinSekizYüzDoksan"

        1_000_000_000 | "BirMilyar"
        2_147_483_647 | "İkiMilyarYüzKırkYediMilyonDörtYüzSeksenÜçBinAltıYüzKırkYedi"
    }
}
