package pl.allegro.finance.tradukisto.internal.languages.english;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class EnglishValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "zero")
                .put(1, "one")
                .put(2, "two")
                .put(3, "three")
                .put(4, "four")
                .put(5, "five")
                .put(6, "six")
                .put(7, "seven")
                .put(8, "eight")
                .put(9, "nine")
                .put(10, "ten")
                .put(11, "eleven")
                .put(12, "twelve")
                .put(13, "thirteen")
                .put(14, "fourteen")
                .put(15, "fifteen")
                .put(16, "sixteen")
                .put(17, "seventeen")
                .put(18, "eighteen")
                .put(19, "nineteen")
                .put(20, "twenty")
                .put(30, "thirty")
                .put(40, "forty")
                .put(50, "fifty")
                .put(60, "sixty")
                .put(70, "seventy")
                .put(80, "eighty")
                .put(90, "ninety")
                .put(100, "one hundred")
                .put(200, "two hundred")
                .put(300, "three hundred")
                .put(400, "four hundred")
                .put(500, "five hundred")
                .put(600, "six hundred")
                .put(700, "seven hundred")
                .put(800, "eight hundred")
                .put(900, "nine hundred")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new EnglishPluralForms(""),
            new EnglishPluralForms("thousand"),
            new EnglishPluralForms("million"),
            new EnglishPluralForms("billion"),
            new EnglishPluralForms("trillion"),
            new EnglishPluralForms("quadrillion"),
            new EnglishPluralForms("quintillion")
        );
    }

    @Override
    public String currency() {
        return "£";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return '-';
    }
}
