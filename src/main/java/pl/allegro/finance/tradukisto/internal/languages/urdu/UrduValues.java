package pl.allegro.finance.tradukisto.internal.languages.urdu;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.english.EnglishPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class UrduValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
            .put(0, "صفر")
            .put(1, "ایک")
            .put(2, "دو")
            .put(3, "تین")
            .put(4, "چار")
            .put(5, "پانچ")
            .put(6, "چھ")
            .put(7, "سات")
            .put(8, "آٹھ")
            .put(9, "نو")

            .put(10, "دس")
            .put(11, "گیارہ")
            .put(12, "بارہ")
            .put(13, "تیرہ")
            .put(14, "چودہ")
            .put(15, "پندرہ")
            .put(16, "سولہ")
            .put(17, "سترہ")
            .put(18, "اٹھارہ")
            .put(19, "انیس")
            .put(20, "بیس")

            .put(21, "اکیس")
            .put(22, "بائیس")
            .put(23, "تئیس")
            .put(24, "چوبیس")
            .put(25, "پچیس")
            .put(26, "چھببیس")
            .put(27, "ستائیس")
            .put(28, "اٹھائیس")
            .put(29, "انتیس")
            .put(30, "تیس")

            .put(31, "اکتیس")
            .put(32, "بتیس")
            .put(33, "تینتیس")
            .put(34, "چونتیس")
            .put(35, "پینتیس")
            .put(36, "چھتیس")
            .put(37, "سینتیس")
            .put(38, "اڑتیس")
            .put(39, "انتالیس")
            .put(40, "چالیس")

            .put(41, "اکتالیس")
            .put(42, "بیالیس")
            .put(43, "تینتالیس")
            .put(44, "چوالیس")
            .put(45, "پینتالیس")
            .put(46, "چھیالیس")
            .put(47, "سینتالیس")
            .put(48, "اڑتالیس")
            .put(49, "انچاس")
            .put(50, "پچاس")

            .put(51, "اکیاون")
            .put(52, "باون")
            .put(53, "ترپن")
            .put(54, "چون")
            .put(55, "پچپن")
            .put(56, "چھپن")
            .put(57, "ستاون")
            .put(58, "اٹھاون")
            .put(59, "انسٹھ")
            .put(60, "ساٹھ")

            .put(61, "اکسٹھ")
            .put(62, "باسٹھ")
            .put(63, "ترسٹھ")
            .put(64, "چوسٹھ")
            .put(65, "پینسٹھ")
            .put(66, "چھیاسٹھ")
            .put(67, "سڑسٹھ")
            .put(68, "اٹھسٹھ")
            .put(69, "انہتر")
            .put(70, "ستر")

            .put(71, "اکہتر")
            .put(72, "بہتر")
            .put(73, "تہتر")
            .put(74, "چوہتر")
            .put(75, "پچہتر")
            .put(76, "چھہتر")
            .put(77, "ستتر")
            .put(78, "اٹھہتر")
            .put(79, "اناسی")
            .put(80, "اسی")

            .put(81, "اکیاسی")
            .put(82, "بیاسی")
            .put(83, "تراسی")
            .put(84, "چوراسی")
            .put(85, "پچاسی")
            .put(86, "چھیاسی")
            .put(87, "ستاسی")
            .put(88, "اٹھاسی")
            .put(89, "نواسی")
            .put(90, "نوے")

            .put(91, "اکانوے")
            .put(92, "بانوے")
            .put(93, "ترانوے")
            .put(94, "چورانوے")
            .put(95, "پچانوے")
            .put(96, "چھیانوے")
            .put(97, "ستانوے")
            .put(98, "اٹھانوے")
            .put(99, "ننانوے")

            .put(100, "ایک سو")
            .put(200, "دو سو")
            .put(300, "تین سو")
            .put(400, "چار سو")
            .put(500, "پانچ سو")
            .put(600, "چھ سو")
            .put(700, "سات سو")
            .put(800, "آٹھ سو")
            .put(900, "نو سو")
            .build();

    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new EnglishPluralForms(""),
            new EnglishPluralForms("ہزار"),
            new EnglishPluralForms("لاکھ"),
            new EnglishPluralForms("کروڑ"),
            new EnglishPluralForms("ارب"),
            new EnglishPluralForms("کھرب")
        );
    }

    @Override
    public String currency() {
        return "\uD83B\uDC71";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return '\u200C';
    }

    public String paiseSymbol() {
        return "p";
    }
}
