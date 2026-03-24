package pl.allegro.finance.tradukisto.internal.languages.uzbek;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class UzbekValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nol")
                .put(1, "bir")
                .put(2, "ikki")
                .put(3, "uch")
                .put(4, "to'rt")
                .put(5, "besh")
                .put(6, "olti")
                .put(7, "yetti")
                .put(8, "sakkiz")
                .put(9, "to'qqiz")
                .put(10, "o'n")
                .put(11, "o'n bir")
                .put(12, "o'n ikki")
                .put(13, "o'n uch")
                .put(14, "o'n to'rt")
                .put(15, "o'n besh")
                .put(16, "o'n olti")
                .put(17, "o'n yetti")
                .put(18, "o'n sakkiz")
                .put(19, "o'n to'qqiz")
                .put(20, "yigirma")
                .put(30, "o'ttiz")
                .put(40, "qirq")
                .put(50, "ellik")
                .put(60, "oltmish")
                .put(70, "yetmish")
                .put(80, "sakson")
                .put(90, "to'qson")
                .put(100, "bir yuz")
                .put(200, "ikki yuz")
                .put(300, "uch yuz")
                .put(400, "to'rt yuz")
                .put(500, "besh yuz")
                .put(600, "olti yuz")
                .put(700, "yetti yuz")
                .put(800, "sakkiz yuz")
                .put(900, "to'qqiz yuz")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new UzbekPluralForms(""),
                new UzbekPluralForms("ming"),
                new UzbekPluralForms("million"),
                new UzbekPluralForms("milliard"),
                new UzbekPluralForms("trillion"),
                new UzbekPluralForms("kvadrillion"),
                new UzbekPluralForms("kvintillion")
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
