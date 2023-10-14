package pl.allegro.finance.tradukisto.internal.languages.croatian;

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

public class CroatianValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nula")
                .put(1, genderForms("jedan", "jedna", "jedan", "jedan"))
                .put(2, genderForms("dva", "dvije", "dva", "dva"))
                .put(3, "tri")
                .put(4, "četiri")
                .put(5, "pet")
                .put(6, "šest")
                .put(7, "sedam")
                .put(8, "osam")
                .put(9, "devet")
                .put(10, "deset")
                .put(11, "jedanaest")
                .put(12, "dvanaest")
                .put(13, "trinaest")
                .put(14, "četrnaest")
                .put(15, "petnaest")
                .put(16, "šesnaest")
                .put(17, "sedamnaest")
                .put(18, "osamnaest")
                .put(19, "devetnaest")
                .put(20, "dvadeset")
                .put(30, "trideset")
                .put(40, "četrdeset")
                .put(50, "pedeset")
                .put(60, "šezdeset")
                .put(70, "sedamdeset")
                .put(80, "osamdeset")
                .put(90, "devedeset")
                .put(100, "sto")
                .put(200, "dvjesto")
                .put(300, "tristo")
                .put(400, "četiristo")
                .put(500, "petsto")
                .put(600, "šeststo")
                .put(700, "sedamsto")
                .put(800, "osamsto")
                .put(900, "devetsto")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new SlavicPluralForms("", "", "", GenderType.MASCULINE),
                new SlavicPluralForms("tisuća", "tisuće", "tisuća", GenderType.FEMININE),
                new SlavicPluralForms("milijun", "milijuna", "milijuna", GenderType.MASCULINE),
                new SlavicPluralForms("milijarda", "milijarde", "milijardi", GenderType.FEMININE),
                new SlavicPluralForms("bilijun", "bilijuna", "bilijuna", GenderType.MASCULINE),
                new SlavicPluralForms("bilijarda", "bilijarde", "bilijardi", GenderType.FEMININE),
                new SlavicPluralForms("trilijun", "trilijuna", "trilijuna", GenderType.MASCULINE));
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
