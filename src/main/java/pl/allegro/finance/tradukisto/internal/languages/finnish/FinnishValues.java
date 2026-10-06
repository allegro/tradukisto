package pl.allegro.finance.tradukisto.internal.languages.finnish;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class FinnishValues implements BaseValues {

    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nolla")
                .put(1, "yksi")
                .put(2, "kaksi")
                .put(3, "kolme")
                .put(4, "neljä")
                .put(5, "viisi")
                .put(6, "kuusi")
                .put(7, "seitsemän")
                .put(8, "kahdeksan")
                .put(9, "yhdeksän")
                .put(10, "kymmenen")
                .put(11, "yksitoista")
                .put(12, "kaksitoista")
                .put(13, "kolmetoista")
                .put(14, "neljätoista")
                .put(15, "viisitoista")
                .put(16, "kuusitoista")
                .put(17, "seitsemäntoista")
                .put(18, "kahdeksantoista")
                .put(19, "yhdeksäntoista")
                .put(20, "kaksikymmentä")
                .put(30, "kolmekymmentä")
                .put(40, "neljäkymmentä")
                .put(50, "viisikymmentä")
                .put(60, "kuusikymmentä")
                .put(70, "seitsemänkymmentä")
                .put(80, "kahdeksankymmentä")
                .put(90, "yhdeksänkymmentä")
                .put(100, "sata")
                .put(200, "kaksisataa")
                .put(300, "kolmesataa")
                .put(400, "neljäsataa")
                .put(500, "viisisataa")
                .put(600, "kuusisataa")
                .put(700, "seitsemänsataa")
                .put(800, "kahdeksansataa")
                .put(900, "yhdeksänsataa")
                .build();
    }

    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new RegularPluralForms("miljoona", "miljoonaa", GenderType.NON_APPLICABLE),
                new RegularPluralForms("miljardi", "miljardia", GenderType.NON_APPLICABLE),
                new RegularPluralForms("biljoona", "biljoonaa"),
                new RegularPluralForms("triljoona", "triljoonaa"));
    }

    public String currency() {
        return "€";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return '\0';
    }
}
