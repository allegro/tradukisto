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

public class SerbianValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nula")
                .put(1, genderForms("jedan", "jedna", "jedan", "jedan"))
                .put(2, genderForms("dva", "dve", "dve", "dva"))
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
                .put(16, "šestnaest")
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
                .put(200, "dvesta")
                .put(300, "trista")
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
            new SlavicPluralForms("hiljada", "hiljade", "hiljada", GenderType.FEMININE),
            new SlavicPluralForms("milion", "miliona", "miliona", GenderType.MASCULINE),
            new SlavicPluralForms("milijarda", "milijarde", "milijardi", GenderType.FEMININE)
        );
    }

    @Override
    public String currency() {
        return "RSD";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
