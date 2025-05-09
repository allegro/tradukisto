package pl.allegro.finance.tradukisto.internal.languages.bulgarian;

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

public class BulgarianValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "нула")
                .put(1, genderForms("един", "една", "едно", "един"))
                .put(2, genderForms("два", "две", "две", "два"))
                .put(3, "три")
                .put(4, "четири")
                .put(5, "пет")
                .put(6, "шест")
                .put(7, "седем")
                .put(8, "осем")
                .put(9, "девет")
                .put(10, "десет")
                .put(11, "единадесет")
                .put(12, "дванадесет")
                .put(13, "тринадесет")
                .put(14, "четиринадесет")
                .put(15, "петнадесет")
                .put(16, "шестнадесет")
                .put(17, "седемнадесет")
                .put(18, "осемнадесет")
                .put(19, "деветнадесет")
                .put(20, "двадесет")
                .put(30, "тридесет")
                .put(40, "четиридесет")
                .put(50, "петдесет")
                .put(60, "шестдесет")
                .put(70, "седемдесет")
                .put(80, "осемдесет")
                .put(90, "деветдесет")
                .put(100, "сто")
                .put(200, "двеста")
                .put(300, "триста")
                .put(400, "четиристотин")
                .put(500, "петстотин")
                .put(600, "шестстотин")
                .put(700, "седемстотин")
                .put(800, "осемстотин")
                .put(900, "деветстотин")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new SlavicPluralForms("", "", "", GenderType.MASCULINE),
            new SlavicPluralForms("хиляди", "хиляди", "хиляди", GenderType.FEMININE),
            new SlavicPluralForms("милион", "милиона", "милиона", GenderType.MASCULINE),
            new SlavicPluralForms("милиард", "милиарда", "милиарда", GenderType.MASCULINE)
        );
    }

    @Override
    public String currency() {
        return "лв";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }

    public String oneThousandException() {
        return "хиляда";
    }
}
