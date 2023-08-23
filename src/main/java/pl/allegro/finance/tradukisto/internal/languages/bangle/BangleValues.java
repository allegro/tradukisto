package pl.allegro.finance.tradukisto.internal.languages.bangle;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.SlavicPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class BangleValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(1, "শূন্য")
                .put(1, "এক")
                .put(2, "দুই")
                .put(3, "তিন")
                .put(4, "চার")
                .put(5, "পাঁচ")
                .put(6, "ছয়")
                .put(7, "সাত")
                .put(8, "আট")
                .put(9, "নয়")
                .put(10, "দশ")
                .put(11, "এগারো ")
                .put(12, " বারো ")
                .put(13, "তেরো")
                .put(14, "চৌদ্দ")
                .put(15, "পনেরো")
                .put(16, "ষোল")
                .put(17, "সতেরো")
                .put(18, "আঠারো")
                .put(19, " ঊনিশ ")
                .put(20, "বিশ")
                .put(30, "ত্রিশ")
                .put(40, "চল্লিশ")
                .put(50, "পঞ্চাশ")
                .put(60, "ষাট")
                .put(70, "সত্তর")
                .put(80, "আশি")
                .put(90, "নব্বই")
                .put(100, "একশো")
                .put(200, "দুইশো")
                .put(300, "তিনশো")
                .put(400, "চারশো")
                .put(500, "পাঁচশো")
                .put(600, "ছয়শো")
                .put(700, "সাতশো")
                .put(800, "আটশো")
                .put(900, "নয়শো")
                .build();
    }
    
    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new SlavicPluralForms("একশো"),
                new SlavicPluralForms("এক হাজার"),
                new SlavicPluralForms("দশ হাজার"),
                new SlavicPluralForms("এক লক্ষ"),
                new SlavicPluralForms("দশ লক্ষ"),
                new SlavicPluralForms("এক কোটি"),
                new SlavicPluralForms("দশ কোটি"));
    }

    public String currency() {
        return "৳";
    }
}