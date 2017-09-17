package pl.allegro.finance.tradukisto.internal.languages.persian;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

/**
 * @author omidp
 *
 */
public class PersianValues implements BaseValues
{

    @Override
    public Map<Integer, GenderForms> baseNumbers()
    {
        return baseNumbersBuilder().put(0, "\u0635\u0641\u0631").put(1, "\u06CC\u06A9").put(2, "\u062F\u0648").put(3, "\u0633\u0647")
                .put(4, "\u0686\u0647\u0627\u0631").put(5, "\u067E\u0646\u062C").put(6, "\u0634\u0634").put(7, "\u0647\u0641\u062A")
                .put(8, "\u0647\u0634\u062A").put(9, "\u0646\u0647").put(10, "\u062F\u0647").put(11, "\u06CC\u0627\u0632\u062F\u0647")
                .put(12, "\u062F\u0648\u0627\u0632\u062F\u0647").put(13, "\u0633\u06CC\u0632\u062F\u0647")
                .put(14, "\u0686\u0647\u0627\u0631\u062F\u0647").put(15, "\u067E\u0627\u0646\u0632\u062F\u0647")
                .put(16, "\u0634\u0627\u0646\u0632\u062F\u0647").put(17, "\u0647\u0641\u062F\u0647").put(18, "\u0647\u062C\u062F\u0647")
                .put(19, "\u0646\u0648\u0632\u062F\u0647").put(20, "\u0628\u06CC\u0633\u062A").put(30, "\u0633\u06CC")
                .put(40, "\u0686\u0647\u0644").put(50, "\u067E\u0646\u062C\u0627\u0647").put(60, "\u0634\u0635\u062A")
                .put(70, "\u0647\u0641\u062A\u0627\u062F").put(80, "\u0647\u0634\u062A\u0627\u062F").put(90, "\u0646\u0648\u062F")
                .put(100, "\u0635\u062F").put(200, "\u062F\u0648\u06CC\u0633\u062A").put(300, "\u0633\u06CC\u0635\u062F")
                .put(400, "\u0686\u0647\u0627\u0631\u0635\u062F").put(500, "\u067E\u0627\u0646\u0635\u062F")
                .put(600, "\u0634\u0634\u0635\u062F").put(700, "\u0647\u0641\u062A\u0635\u062F").put(800, "\u0647\u0634\u062A\u0635\u062F")
                .put(900, "\u0646\u0647\u0635\u062F").build();
    }

    @Override
    public List<PluralForms> pluralForms()
    {
        return Arrays.asList(new PersianPluralForms(""), new PersianPluralForms("\u0647\u0632\u0627\u0631"),
                new PersianPluralForms("\u0645\u06CC\u0644\u06CC\u0648\u0646"),
                new PersianPluralForms("\u0645\u06CC\u0644\u06CC\u0627\u0631\u062F"));
    }

    @Override
    public String currency()
    {
        return "";
    }

    @Override
    public char twoDigitsNumberSeparator()
    {
        return ' ';
    }

   
}
