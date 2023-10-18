package pl.allegro.finance.tradukisto.internal.languages.japanese;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.english.EnglishPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class JapaneseKanjiValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "例")
                .put(1,"一")
                .put(2,"二")
                .put(3,"三")
                .put(4,"四")
                .put(5,"五")
                .put(6,"六")
                .put(7,"七")
                .put(8,"八")
                .put(9,"九")
                .put(10,"十")
                .put(11,"十一")
                .put(12,"十二")
                .put(13,"十三")
                .put(14,"十四")
                .put(15,"十五")
                .put(16,"十六")
                .put(17,"十七")
                .put(18,"十八")
                .put(19,"十九")
                .put(20,"二十")
                .put(30,"三十")
                .put(40,"四十")
                .put(50,"五十")
                .put(60,"六十")
                .put(70,"七十")
                .put(80,"八十")
                .put(90,"九十")
                .put(100,"百")
                .put(200,"二百")
                .put(300,"三百")
                .put(400,"四百")
                .put(500,"五百")
                .put(600,"六百")
                .put(700,"七百")
                .put(800,"八百")
                .put(900,"九百")
                .put(1000, "千")
                .put(10000, "万")
                .put(100000000, "億")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new EnglishPluralForms(""),
                new EnglishPluralForms("百"),
                new EnglishPluralForms("万"));
    }

    @Override
    public String currency() {
        return "円";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return '\0';
    }
}
