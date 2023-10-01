package pl.allegro.finance.tradukisto.internal.languages.swedish;

import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class SwedishValues {

    // Note: Swedish uses 'common' and 'neuter' gender types, but these seem to transfer nicely for numbers to existing
    // masculine and feminine gender types for common, and neuter and non-applicable gender types for neuter.
    // Regarding base numbers, only 1 has multiple gender types: 1 and 100 being neuter ('ett'), otherwise common ('en')
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "noll")
                .put(1, genderForms("en", "en", "ett", "ett"))
                .put(2, "två")
                .put(3, "tre")
                .put(4, "fyra")
                .put(5, "fem")
                .put(6, "sex")
                .put(7, "sju")
                .put(8, "åtta")
                .put(9, "nio")
                .put(10, "tio")
                .put(11, "elva")
                .put(12, "tolv")
                .put(13, "tretton")
                .put(14, "fjorton")
                .put(15, "femton")
                .put(16, "sexton")
                .put(17, "sjutton")
                .put(18, "arton")
                .put(19, "nitton")
                .put(20, "tjugo")
                .put(30, "trettio")
                .put(40, "fyrtio")
                .put(50, "femtio")
                .put(60, "sextio")
                .put(70, "sjuttio")
                .put(80, "åttio")
                .put(90, "nittio")
                .put(100, "ett hundra")
                .put(200, "två hundra")
                .put(300, "tre hundra")
                .put(400, "fyra hundra")
                .put(500, "fem hundra")
                .put(600, "sex hundra")
                .put(700, "sju hundra")
                .put(800, "åtta hundra")
                .put(900, "nio hundra")
                .build();
    }

    public List<PluralForms> pluralForms() {
        // Note: in Swedish there are common and neuter gender types. In this case, common is equivalent to feminine
        return Arrays.asList(
                new RegularPluralForms("miljon", "miljoner", GenderType.FEMININE), // million
                new RegularPluralForms("miljard", "miljarder", GenderType.FEMININE), // billion
                new RegularPluralForms("biljon", "biljoner", GenderType.FEMININE), // trillion
                new RegularPluralForms("biljard", "biljarder", GenderType.FEMININE), // quadrillion
                new RegularPluralForms("triljon", "triljoner", GenderType.FEMININE)); // quintillion
    }

    public String currency() {
        return "kr";
    }
}
