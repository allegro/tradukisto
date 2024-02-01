package pl.allegro.finance.tradukisto.internal.languages.greek;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class GreekValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "μηδέν")
                .put(1, genderForms("ένα", "μία", "ένας", "μία"))
                .put(2, "δύο")
                .put(3, genderForms("τρία", "τρεις", "τρεις", "τρεις"))
                .put(4, genderForms("τέσσερα", "τέσσερεις", "τέσσερεις", "τέσσερεις"))
                .put(5, "πέντε")
                .put(6, "έξι")
                .put(7, "επτά")
                .put(8, "οκτώ")
                .put(9, "εννέα")
                .put(10, "δέκα")
                .put(11, "έντεκα")
                .put(12, "δώδεκα")
                .put(13, "δεκατρία")
                .put(14, "δεκατέσσερα")
                .put(15, "δεκαπέντε")
                .put(16, "δεκαέξι")
                .put(17, "δεκαεπτά")
                .put(18, "δεκαοκτώ")
                .put(19, "δεκαεννέα")
                .put(20, "είκοσι")
                .put(30, "τριάντα")
                .put(40, "σαράντα")
                .put(50, "πενήντα")
                .put(60, "εξήντα")
                .put(70, "εβδομήντα")
                .put(80, "ογδόντα")
                .put(90, "ενενήντα")
                .put(100, genderForms("εκατό", "εκατόν", "εκατόν", "εκατόν"))
                .put(200, genderForms("διακόσια", "διακόσιες", "διακόσιες", "διακόσια"))
                .put(300, genderForms("τριακόσια", "τριακόσιες", "τριακόσιες", "τριακόσια"))
                .put(400, genderForms("τετρακόσια", "τετρακόσιες", "τετρακόσιες", "τετρακόσια"))
                .put(500, genderForms("πεντακόσια", "πεντακόσιες", "πεντακόσιες", "πεντακόσια"))
                .put(600, genderForms("εξακόσια", "εξακόσιες", "εξακόσιες", "εξακόσια"))
                .put(700, genderForms("επτακόσια", "επτακόσιες", "επτακόσιες", "επτακόσια"))
                .put(800, genderForms("οκτακόσια", "οκτακόσιες", "οκτακόσιες", "οκτακόσια"))
                .put(900, genderForms("εννιακόσια", "εννιακόσιες", "εννιακόσιες", "εννιακόσια"))
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new GreekPluralForms("χίλια", "χιλιάδες", "χιλιάδες", GenderType.FEMININE),
            new GreekPluralForms("εκατομμύριο", "εκατομμύρια", "εκατομμύρια", GenderType.MASCULINE),
            new GreekPluralForms("δισεκατομμύριο", "δισεκατομμύρια", "εκατομμύρια", GenderType.MASCULINE),
            new GreekPluralForms("τρισεκατομμύριο", "τρισεκατομμύρια", "εκατομμύρια", GenderType.MASCULINE),
            new GreekPluralForms("τετράκις εκατομμύριο", "τετράκις εκατομμύρια", "τετράκις εκατομμύρια", GenderType.MASCULINE),
            new GreekPluralForms("πεντάκις εκατομμύριο", "πεντάκις εκατομμύρια", "πεντάκις εκατομμύρια", GenderType.MASCULINE)
        );
    }

    @Override
    public String currency() {
        return "€";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }

    public Map<Integer, String> exceptions() {
        Map<Integer, String> result = new HashMap<>();
        result.put(100, "εκατό");
        result.put(1000, "χίλια");
        return result;
    }
}
