package pl.allegro.finance.tradukisto.internal.languages.hungarian;

import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class HungarianValues {

    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nulla")
                .put(1, "egy")
                .put(2, "kettő")
                .put(3, "három")
                .put(4, "négy")
                .put(5, "öt")
                .put(6, "hat")
                .put(7, "hét")
                .put(8, "nyolc")
                .put(9, "kilenc")
                .put(10, "tíz")
                .put(11, "tizenegy")
                .put(12, "tizenkettő")
                .put(13, "tizenhárom")
                .put(14, "tizennégy")
                .put(15, "tizenöt")
                .put(16, "tizenhat")
                .put(17, "tizenhét")
                .put(18, "tizennyolc")
                .put(19, "tizenkilenc")
                .put(20, "húsz")
                .put(30, "harminc")
                .put(40, "negyven")
                .put(50, "ötven")
                .put(60, "hatvan")
                .put(70, "hetven")
                .put(80, "nyolcvan")
                .put(90, "kilencven")
                .put(100, "száz")
                .put(200, "kétszáz")
                .put(300, "háromszáz")
                .put(400, "négyszáz")
                .put(500, "ötszáz")
                .put(600, "hatszáz")
                .put(700, "hétszáz")
                .put(800, "nyolcszáz")
                .put(900, "kilencszáz")
                .build();
    }

    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new RegularPluralForms("millió", "millió", GenderType.NON_APPLICABLE),
            new RegularPluralForms("milliárd", "milliárd", GenderType.NON_APPLICABLE)
        );
    }

    public String currency() {
        return "Ft";
    }
}
