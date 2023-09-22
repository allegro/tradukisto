package pl.allegro.finance.tradukisto.internal.languages.slovene;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.SlovenePluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class SloveneValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nič")
                .put(1, genderForms("en", "ena", "ena", "ena"))
                .put(2, genderForms("dva", "dve", "dve", "dva"))
                .put(3, genderForms("trije", "tri", "tri", "tri"))
                .put(4, genderForms("štirije", "štiri", "štiri", "štiri"))
                .put(5, "pet")
                .put(6, "šest")
                .put(7, "sedem")
                .put(8, "osem")
                .put(9, "devet")
                .put(10, "deset")
                .put(11, "enajst")
                .put(12, "dvanajst")
                .put(13, "trinajst")
                .put(14, "štirinajst")
                .put(15, "petnajst")
                .put(16, "šestnajst")
                .put(17, "sedemnajst")
                .put(18, "osemnajst")
                .put(19, "devetnajst")
                .put(20, "dvajset")
                .put(30, "trideset")
                .put(40, "štirideset")
                .put(50, "petdeset")
                .put(60, "šestdeset")
                .put(70, "sedemdeset")
                .put(80, "osemdeset")
                .put(90, "devetdeset")
                .put(100, "sto")
                .put(200, "dvesto")
                .put(300, "tristo")
                .put(400, "štiristo")
                .put(500, "petsto")
                .put(600, "šeststo")
                .put(700, "sedemsto")
                .put(800, "osemsto")
                .put(900, "devetsto")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new SlovenePluralForms("", "", "", "", GenderType.NEUTER),
                new SlovenePluralForms("tisoč", "tisoč", "tisoč", "tisoč", GenderType.NEUTER),
                new SlovenePluralForms("milijon", "milijona", "milijone", "milijonov", GenderType.MASCULINE),
                new SlovenePluralForms("milijarda", "milijardi", "milijarde", "milijard", GenderType.FEMININE));
    }

    @Override
    public String currency() {
        return "€";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
