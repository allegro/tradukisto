package pl.allegro.finance.tradukisto.internal.languages.turkish;

import com.google.common.collect.ImmutableMap;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class TurkishValues {

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
                .put(11, "OnBir")
                .put(12, "Onİki")
                .put(13, "OnÜç")
                .put(14, "OnDört")
                .put(15, "OnBeş")
                .put(16, "OnAltı")
                .put(17, "OnYedi")
                .put(18, "OnSekiz")
                .put(19, "OnDokuz")
                .put(20, "Yirmi")
                .put(30, "Otuz")
                .put(40, "Kırk")
                .put(50, "Elli")
                .put(60, "Altmış")
                .put(70, "Yetmiş")
                .put(80, "Seksen")
                .put(90, "Doksan")
                .put(100, "Yüz")
                .put(200, "İkiYüz")
                .put(300, "ÜçYüz")
                .put(400, "DörtYüz")
                .put(500, "BeşYüz")
                .put(600, "AltıYüz")
                .put(700, "YediYüz")
                .put(800, "SekizYüz")
                .put(900, "DokuzYüz")
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

    public String subunitSymbol() {
        return "Kr.";
    }

    public Map<Integer, String> exceptions() {
        return ImmutableMap.<Integer, String>builder().put(1, "Bir").build();
    }
}
