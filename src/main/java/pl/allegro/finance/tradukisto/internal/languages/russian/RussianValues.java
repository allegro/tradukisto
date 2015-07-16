package pl.allegro.finance.tradukisto.internal.languages.russian;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.SlavonicPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class RussianValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "ноль")
                .put(1, genderForms("один", "одна", "один"))
                .put(2, genderForms("два", "две", "два"))
                .put(3, "три")
                .put(4, "четыре")
                .put(5, "пять")
                .put(6, "шесть")
                .put(7, "семь")
                .put(8, "восемь")
                .put(9, "девять")
                .put(10, "десять")
                .put(11, "одиннадцать")
                .put(12, "двенадцать")
                .put(13, "тринадцать")
                .put(14, "четырнадцать")
                .put(15, "пятнадцать")
                .put(16, "шестнадцать")
                .put(17, "семнадцать")
                .put(18, "восемнадцать")
                .put(19, "девятнадцать")
                .put(20, "двадцать")
                .put(30, "тридцать")
                .put(40, "сорок")
                .put(50, "пятьдесят")
                .put(60, "шестьдесят")
                .put(70, "семьдесят")
                .put(80, "восемьдесят")
                .put(90, "девяносто")
                .put(100, "сто")
                .put(200, "двести")
                .put(300, "триста")
                .put(400, "четыреста")
                .put(500, "пятьсот")
                .put(600, "шестьсот")
                .put(700, "семьсот")
                .put(800, "восемьсот")
                .put(900, "девятьсот")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.<PluralForms>asList(
                new SlavonicPluralForms("", "", "", GenderType.MASCULINE),
                new SlavonicPluralForms("тысяча", "тысячи", "тысяч", GenderType.FEMININE),
                new SlavonicPluralForms("миллион", "миллиона", "миллионов", GenderType.MASCULINE),
                new SlavonicPluralForms("миллиард", "миллиарда", "миллиардов", GenderType.MASCULINE));
    }

    @Override
    public String currency() {
        return "\u20BD";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
