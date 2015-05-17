package pl.allegro.finance.tradukisto.internal.languages.czech;

import com.google.common.collect.ImmutableMap;
import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CzechValues implements BaseValues {

    @Override
    public Map<Integer, String> baseNumbers() {
        return ImmutableMap.<Integer, String>builder()
                .put(0, "nula")
                .put(1, "jedna")
                .put(2, "dva")
                .put(3, "tři")
                .put(4, "čtyři")
                .put(5, "pět")
                .put(6, "šest")
                .put(7, "sedm")
                .put(8, "osm")
                .put(9, "devět")
                .put(10, "deset")
                .put(11, "jedenáct")
                .put(12, "dvanáct")
                .put(13, "třináct")
                .put(14, "čtrnáct")
                .put(15, "patnáct")
                .put(16, "šestnáct")
                .put(17, "sedmnáct")
                .put(18, "osmnáct")
                .put(19, "devatenáct")
                .put(20, "dvacet")
                .put(30, "třicet")
                .put(40, "čtyřicet")
                .put(50, "padesát")
                .put(60, "šedesát")
                .put(70, "sedmdesát")
                .put(80, "osmdesát")
                .put(90, "devadesát")
                .put(100, "sto")
                .put(200, "dvě stě")
                .put(300, "tři sta")
                .put(400, "čtyři sta")
                .put(500, "pět set")
                .put(600, "šest set")
                .put(700, "sedm set")
                .put(800, "osm set")
                .put(900, "devět set")
                .build();
    }

    @Override
    public List<? extends PluralForms> pluralForms() {
        return Arrays.asList(
                new CzechPluralForms("", "", ""),
                new CzechPluralForms("tisíc", "tisíce", "tisíc"),
                new CzechPluralForms("milion", "miliony", "milionů"),
                new CzechPluralForms("miliarda", "miliardy", "miliard"));
    }

    @Override
    public String currency() {
        return "Kč";
    }
}
