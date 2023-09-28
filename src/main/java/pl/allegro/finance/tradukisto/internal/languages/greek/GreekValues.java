package pl.allegro.finance.tradukisto.internal.languages.greek;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;
import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
public class GreekValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "μηδέν")
                .put(1, "ένα")
                .put(2, "δύο")
                .put(3, genderForms("τρία","τρεις","τρία"))
                .put(4, genderForms("τέσσερα","τέσσερις","τέσσερα"))
                .put(5, "πέντε")
                .put(6, "έξι")
                .put(7, "επτά")
                .put(8, "οκτώ")
                .put(9, "εννιά")
                .put(10, "δέκα")
                .put(11, "έντεκα")
                .put(12, "δώδεκα")
                .put(13, "δεκατρία")
                .put(14, "δεκατέσσερα")
                .put(15, "δεκαπέντε")
                .put(16, "δεκαέξι")
                .put(17, "δεκαεφτά")
                .put(18, "δεκαοκτώ")
                .put(19, "δέκαεννιά")
                .put(20, "είκοσι")
                .put(30, "τριάντα")
                .put(40, "σαράντα")
                .put(50, "πενήντα")
                .put(60, "εξήντα")
                .put(70, "εβδομήντα")
                .put(80, "ογδόντα")
                .put(90, "ενενήντα")
                .put(100, "εκατό")
                .put(200, "διακοσιά")
                .put(300, "τριακόσια")
                .put(400, "τετρακόσια")
                .put(500, "πεντακόσια")
                .put(600, "εξακόσια")
                .put(700, "εφτακόσια")
                .put(800, "οκτακόσια")
                .put(900, "ενιακόσια")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new GreekPluralForms("","","",GenderType.NON_APPLICABLE),
                new GreekPluralForms("χίλια","χιλιάδες","χίλια",GenderType.FEMININE),
                new RegularPluralForms("εκατομμύρια","εκατομμύρια"),
                new RegularPluralForms("δισεκατομμύρια","δισεκατομμύρια"),
                new RegularPluralForms("τρισεκατομμύρια","τρισεκατομμύρια"),
                new RegularPluralForms("τετράκις εκατομμύρια","τετράκις εκατομμύρια"),
                new RegularPluralForms("πεντάκις εκατομμύρια","πεντάκις εκατομμύρια"),
                new RegularPluralForms("τρία", "τρεις"),
                new RegularPluralForms("εκατό", "εκατόν"),
                new RegularPluralForms("διακόσια", "διακόσιες"),
                new RegularPluralForms("τριακόσια", "τριακόσιες"),
                new RegularPluralForms("τετρακόσια", "τετρακόσιες"),
                new RegularPluralForms("πεντακόσια", "πεντακόσιες"),
                new RegularPluralForms("εξακόσια", "εξακόσιες"),
                new RegularPluralForms("επτακόσια", "επτακόσιες"),
                new RegularPluralForms("οκτακόσια", "οκτακόσιες"),
                new RegularPluralForms("ενιακόσια", "ενιακόσιες")
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
}
