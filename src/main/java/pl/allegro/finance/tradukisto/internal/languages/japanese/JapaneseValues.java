package pl.allegro.finance.tradukisto.internal.languages.japanese;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class JapaneseValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "零")
                .put(1, "一")
                .put(2, "二")
                .put(3, "三")
                .put(4, "四")
                .put(5, "五")
                .put(6, "六")
                .put(7, "七")
                .put(8, "八")
                .put(9, "九")
                .put(10, "十")
                .put(20, "二十")
                .put(30, "三十")
                .put(40, "四十")
                .put(50, "五十")
                .put(60, "六十")
                .put(70, "七十")
                .put(80, "八十")
                .put(90, "九十")
                .put(100, "百")
                .put(200, "二百")
                .put(300, "三百")
                .put(400, "四百")
                .put(500, "五百")
                .put(600, "六百")
                .put(700, "七百")
                .put(800, "八百")
                .put(900, "九百")
                .put(1000, "千")
                .put(2000, "二千")
                .put(3000, "三千")
                .put(4000, "四千")
                .put(5000, "五千")
                .put(6000, "六千")
                .put(7000, "七千")
                .put(8000, "八千")
                .put(9000, "九千")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new JapanesePluralForms(""),
            new JapanesePluralForms("万"),
            new JapanesePluralForms("億"),
            new JapanesePluralForms("兆"),
            new JapanesePluralForms("京")
        );
    }

    @Override
    public String currency() {
        return "\\";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
