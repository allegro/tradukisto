package pl.allegro.finance.tradukisto.internal.languages.kazakh;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class KazakhValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "нөл")
                .put(1, "бір")
                .put(2, "екі")
                .put(3, "үш")
                .put(4, "төрт")
                .put(5, "бес")
                .put(6, "алты")
                .put(7, "жеті")
                .put(8, "сегіз")
                .put(9, "тоғыз")
                .put(10, "он")
                .put(11, "он бір")
                .put(12, "он екі")
                .put(13, "он үш")
                .put(14, "он төрт")
                .put(15, "он бес")
                .put(16, "он алты")
                .put(17, "он жеті")
                .put(18, "он сегіз")
                .put(19, "он тоғыз")
                .put(20, "жиырма")
                .put(30, "отыз")
                .put(40, "қырық")
                .put(50, "елу")
                .put(60, "алпыс")
                .put(70, "жетпіс")
                .put(80, "сексен")
                .put(90, "тоқсан")
                .put(100, "жүз")
                .put(200, "екі жүз")
                .put(300, "үш жүз")
                .put(400, "төрт жүз")
                .put(500, "бес жүз")
                .put(600, "алты жүз")
                .put(700, "жеті жүз")
                .put(800, "сегіз жүз")
                .put(900, "тоғыз жүз")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new KazakhPluralForms(""),
            new KazakhPluralForms("мың"),
            new KazakhPluralForms("миллион"),
            new KazakhPluralForms("миллиард")
        );
    }

    @Override
    public String currency() {
        return "KZT";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
