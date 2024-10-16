package pl.allegro.finance.tradukisto.internal.languages.dutch;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import static java.util.Collections.singletonMap;


public class DutchValues {

    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nul")
                .put(1, "één")
                .put(2, "twee")
                .put(3, "drie")
                .put(4, "vier")
                .put(5, "vijf")
                .put(6, "zes")
                .put(7, "zeven")
                .put(8, "acht")
                .put(9, "negen")
                .put(10, "tien")
                .put(11, "elf")
                .put(12, "twaalf")
                .put(13, "dertien")
                .put(14, "veertien")
                .put(15, "vijftien")
                .put(16, "zestien")
                .put(17, "zeventien")
                .put(18, "achttien")
                .put(19, "negentien")
                .put(20, "twintig")
                .put(30, "dertig")
                .put(40, "veertig")
                .put(50, "vijftig")
                .put(60, "zestig")
                .put(70, "zeventig")
                .put(80, "tachtig")
                .put(90, "negentig")
                .put(100, "honderd")
                .put(200, "tweehonderd")
                .put(300, "driehonderd")
                .put(400, "vierhonderd")
                .put(500, "vijfhonderd")
                .put(600, "zeshonderd")
                .put(700, "zevenhonderd")
                .put(800, "achthonderd")
                .put(900, "negenhonderd")
                .build();
    }

    public Map<Integer, String> exceptions() {
        return singletonMap(1000, "duizend");
    }

    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new DutchPluralForms("miljoen"),
            new DutchPluralForms("miljard"),
            new DutchPluralForms("biljoen"),
            new DutchPluralForms("biljard"),
            new DutchPluralForms("triljoen")
        );
    }

    public String currency() {
        return "€";
    }
}
