package pl.allegro.finance.tradukisto.internal.languages.kyrgyz;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class KyrgyzValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "нөл")
                .put(1, "бир")
                .put(2, "эки")
                .put(3, "үч")
                .put(4, "төрт")
                .put(5, "беш")
                .put(6, "алты")
                .put(7, "жети")
                .put(8, "сегиз")
                .put(9, "тогуз")
                .put(10, "он")
                .put(11, "он бир")
                .put(12, "он эки")
                .put(13, "он үч")
                .put(14, "он төрт")
                .put(15, "он беш")
                .put(16, "он алты")
                .put(17, "он жети")
                .put(18, "он сегиз")
                .put(19, "он тогуз")
                .put(20, "жыйырма")
                .put(30, "отуз")
                .put(40, "кырк")
                .put(50, "элүү")
                .put(60, "алтымыш")
                .put(70, "жетимиш")
                .put(80, "сексен")
                .put(90, "токсон")
                .put(100, "жүз")
                .put(200, "эки жүз")
                .put(300, "үч жүз")
                .put(400, "төрт жүз")
                .put(500, "беш жүз")
                .put(600, "алты жүз")
                .put(700, "жети жүз")
                .put(800, "сегиз жүз")
                .put(900, "тогуз жүз")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new KyrgyzPluralForms(""),
                new KyrgyzPluralForms("миң"),
                new KyrgyzPluralForms("миллион"),
                new KyrgyzPluralForms("миллиард")
        );
    }

    @Override
    public String currency() {
        return "KGS";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
