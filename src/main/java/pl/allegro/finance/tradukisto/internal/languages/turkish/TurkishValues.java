package pl.allegro.finance.tradukisto.internal.languages.turkish;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class TurkishValues implements BaseValues {

    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "Sıfır")
                .put(1, "Bir")
                .put(2, "İki")
                .put(3, "Üç")
                .put(4, "Dört")
                .put(5, "Beş")
                .put(6, "Altı")
                .put(7, "Yedi")
                .put(8, "Sekiz")
                .put(9, "Dokuz")
                .put(10, "On")
                .put(11, "On Bir")
                .put(12, "On İki")
                .put(13, "On Üç")
                .put(14, "On Dört")
                .put(15, "On Beş")
                .put(16, "On Altı")
                .put(17, "On Yedi")
                .put(18, "On Sekiz")
                .put(19, "On Dokuz")
                .put(20, "Yirmi")
                .put(30, "Otuz")
                .put(40, "Kırk")
                .put(50, "Elli")
                .put(60, "Altmış")
                .put(70, "Yetmiş")
                .put(80, "Seksen")
                .put(90, "Doksan")
                .put(100, "Yüz")
                .put(200, "İki Yüz")
                .put(300, "Üç Yüz")
                .put(400, "Dört Yüz")
                .put(500, "Beş Yüz")
                .put(600, "Altı Yüz")
                .put(700, "Yedi Yüz")
                .put(800, "Sekiz Yüz")
                .put(900, "Dokuz Yüz")
                .build();
    }

    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new TurkishPluralForms("Milyon"),
                new TurkishPluralForms("Milyar"));
    }

    public String currency() {
        return "TL";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }

    public String subunitSymbol() {
        return "Kr.";
    }
}
