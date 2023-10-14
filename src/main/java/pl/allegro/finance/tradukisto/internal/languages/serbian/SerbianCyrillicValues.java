package pl.allegro.finance.tradukisto.internal.languages.serbian;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.SlavicPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class SerbianCyrillicValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "нула")
                .put(1, genderForms("један", "једна", "један", "један"))
                .put(2, genderForms("два", "две", "две", "два"))
                .put(3, "три")
                .put(4, "четири")
                .put(5, "пет")
                .put(6, "шест")
                .put(7, "седам")
                .put(8, "осам")
                .put(9, "девет")
                .put(10, "десет")
                .put(11, "једанаест")
                .put(12, "дванаест")
                .put(13, "тринаест")
                .put(14, "четрнаест")
                .put(15, "петнаест")
                .put(16, "шеснаест")
                .put(17, "седамнаест")
                .put(18, "осамнаест")
                .put(19, "деветнаест")
                .put(20, "двадесет")
                .put(30, "тридесет")
                .put(40, "четрдесет")
                .put(50, "педесет")
                .put(60, "шездесет")
                .put(70, "седамдесет")
                .put(80, "осамдесет")
                .put(90, "деведесет")
                .put(100, "сто")
                .put(200, "двеста")
                .put(300, "триста")
                .put(400, "четиристо")
                .put(500, "петсто")
                .put(600, "шестсто")
                .put(700, "седамсто")
                .put(800, "осамсто")
                .put(900, "деветсто")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new SlavicPluralForms("", "", "", GenderType.MASCULINE),
                new SlavicPluralForms("хиљада", "хиљаде", "хиљада", GenderType.FEMININE),
                new SlavicPluralForms("милион", "милиона", "милиона", GenderType.MASCULINE),
                new SlavicPluralForms("милијарда", "милијарде", "милијарди", GenderType.FEMININE));
    }

    @Override
    public String currency() {
        return "РСД";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
