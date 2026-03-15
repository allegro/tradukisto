package pl.allegro.finance.tradukisto.internal.languages.uzbek;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class UzbekCyrillicValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "нол")
                .put(1, "бир")
                .put(2, "икки")
                .put(3, "уч")
                .put(4, "тўрт")
                .put(5, "беш")
                .put(6, "олти")
                .put(7, "етти")
                .put(8, "саккиз")
                .put(9, "тўққиз")
                .put(10, "ўн")
                .put(11, "ўн бир")
                .put(12, "ўн икки")
                .put(13, "ўн уч")
                .put(14, "ўн тўрт")
                .put(15, "ўн беш")
                .put(16, "ўн олти")
                .put(17, "ўн етти")
                .put(18, "ўн саккиз")
                .put(19, "ўн тўққиз")
                .put(20, "йигирма")
                .put(30, "ўттиз")
                .put(40, "қирқ")
                .put(50, "эллик")
                .put(60, "олтмиш")
                .put(70, "етмиш")
                .put(80, "саксон")
                .put(90, "тўқсон")
                .put(100, "бир юз")
                .put(200, "икки юз")
                .put(300, "уч юз")
                .put(400, "тўрт юз")
                .put(500, "беш юз")
                .put(600, "олти юз")
                .put(700, "етти юз")
                .put(800, "саккиз юз")
                .put(900, "тўққиз юз")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new UzbekPluralForms(""),
                new UzbekPluralForms("минг"),
                new UzbekPluralForms("миллион"),
                new UzbekPluralForms("миллиард"),
                new UzbekPluralForms("триллион"),
                new UzbekPluralForms("квадриллион"),
                new UzbekPluralForms("квинтиллион")
        );
    }

    @Override
    public String currency() {
        return "UZS";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
