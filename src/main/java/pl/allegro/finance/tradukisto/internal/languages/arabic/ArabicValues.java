package pl.allegro.finance.tradukisto.internal.languages.arabic;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class ArabicValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "صفر")
                .put(1, "واحد")
                .put(2, "اثنان")
                .put(3, "ثلاثة")
                .put(4, "أربعة")
                .put(5, "خمسة")
                .put(6, "ستة")
                .put(7, "سبعة")
                .put(8, "ثمانية")
                .put(9, "تسعة")
                .put(10, "عشرة")
                .put(11, "أحد عشر")
                .put(12, "اثنا عشر")
                .put(13, "ثلاثة عشر")
                .put(14, "أربعة عشر")
                .put(15, "خمسة عشر")
                .put(16, "ستة عشر")
                .put(17, "سبعة عشر")
                .put(18, "ثمانية عشر")
                .put(19, "تسعة عشر")
                .put(20, "عشرون")
                .put(30, "ثلاثون")
                .put(40, "أربعون")
                .put(50, "خمسون")
                .put(60, "ستون")
                .put(70, "سبعون")
                .put(80, "ثمانون")
                .put(90, "تسعون")
                .put(100, "مئة")
                .put(200, "مئتان")
                .put(300, "ثلاثمئة")
                .put(400, "أربعمئة")
                .put(500, "خمسمئة")
                .put(600, "ستمئة")
                .put(700, "سبعمئة")
                .put(800, "ثمانمئة")
                .put(900, "تسعمئة")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new ArabicPluralForms(""),
                new ArabicPluralForms("ألف", "آلاف"),
                new ArabicPluralForms("مليون", "ملايين"),
                new ArabicPluralForms("مليار", "مليارات")
        );
    }

    @Override
    public String currency() {
        return "SAR";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
