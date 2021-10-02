package pl.allegro.finance.tradukisto.internal.languages.french;

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

public class FrenchValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "zéro")
                .put(1, "un")
                .put(2, "deux")
                .put(3, "trois")
                .put(4, "quatre")
                .put(5, "cinq")
                .put(6, "six")
                .put(7, "sept")
                .put(8, "huit")
                .put(9, "neuf")
                .put(10, "dix")
                .put(11, "onze")
                .put(12, "douze")
                .put(13, "treize")
                .put(14, "quatorze")
                .put(15, "quinze")
                .put(16, "seize")
                .put(17, "dix-sept")
                .put(18, "dix-huit")
                .put(19, "dix-neuf")
                .put(20, "vingt")
                .put(21, "vingt-et-un")
                .put(30, "trente")
                .put(31, "trente-et-un")
                .put(40, "quarante")
                .put(41, "quarante-et-un")
                .put(50, "cinquante")
                .put(51, "cinquante-et-un")
                .put(60, "soixante")
                .put(61, "soixante-et-un")
                .put(70, "soixante-dix")
                .put(71, "soixante-et-onze")
                .put(72, "soixante-douze")
                .put(73, "soixante-treize")
                .put(74, "soixante-quatorze")
                .put(75, "soixante-quinze")
                .put(76, "soixante-seize")
                .put(77, "soixante-dix-sept")
                .put(78, "soixante-dix-huit")
                .put(79, "soixante-dix-neuf")
                .put(80, "quatre-vingts")
                .put(81, "quatre-vingt-un")
                .put(82, "quatre-vingt-deux")
                .put(83, "quatre-vingt-trois")
                .put(84, "quatre-vingt-quatre")
                .put(85, "quatre-vingt-cinq")
                .put(86, "quatre-vingt-six")
                .put(87, "quatre-vingt-sept")
                .put(88, "quatre-vingt-huit")
                .put(89, "quatre-vingt-neuf")
                .put(90, "quatre-vingt-dix")
                .put(91, "quatre-vingt-onze")
                .put(92, "quatre-vingt-douze")
                .put(93, "quatre-vingt-treize")
                .put(94, "quatre-vingt-quatorze")
                .put(95, "quatre-vingt-quinze")
                .put(96, "quatre-vingt-seize")
                .put(97, "quatre-vingt-dix-sept")
                .put(98, "quatre-vingt-dix-huit")
                .put(99, "quatre-vingt-dix-neuf")
                .put(100, "cent")
                .put(200, "deux cent")
                .put(300, "trois cent")
                .put(400, "quatre cent")
                .put(500, "cinq cent")
                .put(600, "six cent")
                .put(700, "sept cent")
                .put(800, "huit cent")
                .put(900, "neuf cent")
                .put(1000, "mille")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new RegularPluralForms("", "", GenderType.MASCULINE),
                new RegularPluralForms("mille", "mille" , GenderType.MASCULINE),
                new RegularPluralForms("million", "millions", GenderType.MASCULINE),
                new RegularPluralForms("milliard", "milliards", GenderType.MASCULINE)
        );
    }

    @Override
    public String currency() {
        return "€";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return '-';
    }

    public Map<Integer, String> exceptions() {
        return ImmutableMap.<Integer, String>builder()
                                .put(200, "deux cents")
                                .put(300, "trois cents")
                                .put(400, "quatre cents")
                                .put(500, "cinq cents")
                                .put(600, "six cents")
                                .put(700, "sept cents")
                                .put(800, "huit cents")
                                .put(900, "neuf cents")
                                .put(1000, "mille").build();
    }
}

