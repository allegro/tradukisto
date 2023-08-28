package pl.allegro.finance.tradukisto.internal.languages.hindi;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.english.EnglishPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class HindiValues implements BaseValues {
    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "शून्य")
                .put(1, "एक")
                .put(2, "दो")
                .put(3, "तीन")
                .put(4, "चार")
                .put(5, "पाँच")
                .put(6, "छ:")
                .put(7, "सात")
                .put(8, "आठ")
                .put(9, "नौ")
                .put(10, "दस")
                .put(11, "ग्यारह")
                .put(12, "बारह")
                .put(13, "तेरह")
                .put(14, "चौदह")
                .put(15, "पंद्रह")
                .put(16, "सोलह")
                .put(17, "सत्रह")
                .put(18, "आट्ठारह")
                .put(19, "उन्निस")
                .put(20, "बीस")
                .put(21,"इक्कीस")
                .put(22,"बाईस")
                .put(23,"तेईस")
                .put(24,"चौबीस")
                .put(25,"पच्चीस")
                .put(26,"छब्बीस")
                .put(27,"सत्ताईस")
                .put(28,"अट्ठाईस")
                .put(29,"उनतीस")
                .put(30,"तीस")

                .put(31,"इकत्तीस")
                .put(32,"बत्तीस")
                .put(33,"तेंतीस")
                .put(34,"चौंतीस")
                .put(35,"पैंतीस")
                .put(36,"छत्तीस")
                .put(37,"सैंतीस")
                .put(38,"अड़तीस")
                .put(39,"उनतालीस")
                .put(40,"चालीस")

                .put(41,"एकतालीस")
                .put(42,"बायलीस")
                .put(43,"तैंतालीस")
                .put(44,"चौवालीस")
                .put(45,"पैंतालिस")
                .put(46,"छियालीस")
                .put(47,"सैंतालीस")
                .put(48,"अड़तालीस")
                .put(49,"उनचास")
                .put(50,"पचास")

                .put(51,"इक्यबन")
                .put(52,"बावन")
                .put(53,"तिरपन")
                .put(54,"चौवन")
                .put(55,"पचपन")
                .put(56,"छप्पन")
                .put(57,"सत्तावन")
                .put(58,"अट्ठावन")
                .put(59,"उनसठ")
                .put(60,"साठ")
                .put(61,"इकसठ")
                .put(62,"बासठ")
                .put(63,"तिरसठ")
                .put(64,"चौंसठ")
                .put(65,"पैंसठ")
                .put(66,"छियासठ")
                .put(67,"सड़सठ")
                .put(68,"सड़सठ")
                .put(69,"उनहत्तर")
                .put(70,"सत्तर")

                .put(71,"इकहत्तर")
                .put(72,"बहत्तर")
                .put(73,"तिहत्तर")
                .put(74,"चौहत्तर")
                .put(75,"पचहत्तर")
                .put(76,"छीहत्तर")
                .put(77,"सतहत्तर")
                .put(78,"अठहत्तर")
                .put(79,"उनासी")
                .put(80,"असी")
                .put(81,"इक्यासी")
                .put(82,"बयासी")
                .put(83,"तिरासी")
                .put(84,"चौरासी")
                .put(85,"पचासी")
                .put(86,"छियासी")
                .put(87,"सतासी")
                .put(88,"अट्ठासी")
                .put(89,"नवासी")
                .put(90,"नब्बे")

                .put(91,"इक्यानवे")
                .put(92,"बानवे")
                .put(93,"तिरानवे")
                .put(94,"चौरानवे")
                .put(95,"पचानवे")
                .put(96,"छियानवे")
                .put(97,"सतानवे")
                .put(98,"अट्ठानवे")
                .put(99,"निन्यानवे")

                .put(100, "एक सौ")
                .put(200, "दो सौ")
                .put(300, "तीन सौ")
                .put(400, "चार सौ")
                .put(500, "पाँच सौ")
                .put(600, "छ: सौ")
                .put(700, "सात सौ")
                .put(800, "आठ सौ")
                .put(900, "नौ सौ")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new EnglishPluralForms(""),
                new EnglishPluralForms("हजार"),
                new EnglishPluralForms("लाख"),
                new EnglishPluralForms("करोड़"),
                new EnglishPluralForms("अरब"),
                new EnglishPluralForms("खरब"),
                new EnglishPluralForms("नील"),
                new EnglishPluralForms("पद्म"),
                new EnglishPluralForms("शंख"),
                new EnglishPluralForms("महाशंख"));
    }

    @Override
    public String currency() {
        return "₹";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return 0;
    }

    public String paiseSymbol(){
        return "p";
    }
}
