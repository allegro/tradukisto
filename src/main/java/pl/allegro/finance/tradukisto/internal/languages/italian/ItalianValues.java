package pl.allegro.finance.tradukisto.internal.languages.italian;

import com.google.common.collect.ImmutableMap;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class ItalianValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "zero")
                .put(1, "uno")
                .put(2, "due")
                .put(3, "tre")
                .put(4, "quattro")
                .put(5, "cinque")
                .put(6, "sei")
                .put(7, "sette")
                .put(8, "otto")
                .put(9, "nove")
                .put(10, "dieci")
                .put(11, "undici")
                .put(12, "dodici")
                .put(13, "tredici")
                .put(14, "quattordici")
                .put(15, "quindici")
                .put(16, "sedici")
                .put(17, "diciassette")
                .put(18, "diciotto")
                .put(19, "diciannove")
                .put(20, "venti")
                .put(21, "ventuno")
                .put(28, "ventotto")
                .put(30, "trenta")
                .put(31, "trentuno")
                .put(38, "trentotto")
                .put(40, "quaranta")
                .put(41, "quarantuno")
                .put(48, "quarantotto")
                .put(50, "cinquanta")
                .put(51, "cinquantuno")
                .put(58, "cinquantotto")
                .put(60, "sessanta")
                .put(61, "sessantuno")
                .put(68, "sessantotto")
                .put(70, "settanta")
                .put(71, "settantuno")
                .put(78, "settantotto")
                .put(80, "ottanta")
                .put(81, "ottantuno")
                .put(68, "ottantotto")
                .put(90, "novanta")
                .put(91, "novantuno")
                .put(98, "novantotto")
                .put(100, "cento")
                .put(200, "duecento")
                .put(300, "trecento")
                .put(400, "quattrocento")
                .put(500, "cinquecento")
                .put(600, "seicento")
                .put(700, "settecento")
                .put(800, "ottocento")
                .put(900, "novecento")
                .put(1000000, "unmilione")
                .put(1000000000, "unmiliardo")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new RegularPluralForms("", "", GenderType.MASCULINE),
                new RegularPluralForms("mille", "mila", GenderType.MASCULINE),
                new RegularPluralForms("milione", "milioni", GenderType.MASCULINE),
                new RegularPluralForms("miliardo", "miliardi", GenderType.MASCULINE));
    }

    @Override
    public String currency() {
        return "€";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }

    public Map<Integer, String> exceptions() {
        return ImmutableMap.<Integer, String>builder().put(1000, "mille").build();
    }
}
