package pl.allegro.finance.tradukisto.internal.languages.ukrainian;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class UkrainianValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "нуль")
                .put(1, genderForms("один", "одна", "одну"))
                .put(2, genderForms("два", "дві", "дві"))
                .put(3, "три")
                .put(4, "чотири")
                .put(5, "п'ять")
                .put(6, "шість")
                .put(7, "сім")
                .put(8, "вісім")
                .put(9, "дев'ять")
                .put(10, "десять")
                .put(11, "одинадцять")
                .put(12, "дванадцять")
                .put(13, "тринадцять")
                .put(14, "чотирнадцять")
                .put(15, "п'ятнадцять")
                .put(16, "шістнадцять")
                .put(17, "сімнадцять")
                .put(18, "вісімнадцять")
                .put(19, "дев'ятнадцять")
                .put(20, "двадцять")
                .put(30, "тридцять")
                .put(40, "сорок")
                .put(50, "пятдесят")
                .put(60, "шістдесят")
                .put(70, "сімдесят")
                .put(80, "вісімдесят")
                .put(90, "дев'яносто")
                .put(100, "сто")
                .put(200, "двісті")
                .put(300, "триста")
                .put(400, "чотириста")
                .put(500, "п'ятсот")
                .put(600, "шістсот")
                .put(700, "сімсот")
                .put(800, "вісімсот")
                .put(900, "дев'ятсот")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new UkrainianPluralForms("", "", "", GenderType.MASCULINE),
                new UkrainianPluralForms("тисяча", "тисячі", "тисяч", GenderType.FEMININE),
                new UkrainianPluralForms("мільйон", "мільйони", "мільйонів", GenderType.MASCULINE),
                new UkrainianPluralForms("мільярд", "мільярди", "мільярдів", GenderType.MASCULINE));
    }

    @Override
    public String currency() {
        return "₴";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }

}
