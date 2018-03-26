package pl.allegro.finance.tradukisto.internal.languages.latvian;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class LatvianValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nulle")
                .put(1, genderForms("viens", "viena", "viens"))
                .put(2, "divi")
                .put(3, "trīs")
                .put(4, "četri")
                .put(5, "pieci")
                .put(6, "seši")
                .put(7, "septiņi")
                .put(8, "astoņi")
                .put(9, "deviņi")
                .put(10, "desmit")
                .put(11, "vienpadsmit")
                .put(12, "divpadsmit")
                .put(13, "trīspadsmit")
                .put(14, "četrpadsmit")
                .put(15, "piecpadsmit")
                .put(16, "sešpadsmit")
                .put(17, "septiņpadsmit")
                .put(18, "astoņpadsmit")
                .put(19, "deviņpadsmit")
                .put(20, "divdesmit")
                .put(30, "trīsdesmit")
                .put(40, "četrdesmit")
                .put(50, "piecdesmit")
                .put(60, "sešdesmit")
                .put(70, "septiņdesmit")
                .put(80, "astoņdesmit")
                .put(90, "deviņdesmit")
                .put(100, "viens simts")
                .put(200, "divi simti")
                .put(300, "trīs simti")
                .put(400, "četri simti")
                .put(500, "pieci simti")
                .put(600, "seši simti")
                .put(700, "septiņi simti")
                .put(800, "astoņi simti")
                .put(900, "deviņi simti")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new LatvianPluralForms("", "", GenderType.MASCULINE),
                new LatvianPluralForms("tūkstotis", "tūkstoši", GenderType.MASCULINE),
                new LatvianPluralForms("miljons", "miljoni", GenderType.MASCULINE),
                new LatvianPluralForms("miljards", "miljardi", GenderType.MASCULINE));
    }

    @Override
    public String currency() {
        return "EUR";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
