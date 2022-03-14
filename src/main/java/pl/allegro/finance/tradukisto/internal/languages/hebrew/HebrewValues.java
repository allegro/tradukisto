package pl.allegro.finance.tradukisto.internal.languages.hebrew;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

/**
 * @author <a href="mailto:tnsilver@gmail.com">T.N.Silverman</a>
 * @version 1.11.0
 * @since 1.11.0
 */
public class HebrewValues implements BaseValues {

    private final List<PluralForms> pluralForms;

    public HebrewValues() {
        super();
        pluralForms = new ArrayList<>();
        pluralForms.add(new RegularPluralForms("", "", GenderType.FEMININE));
    }

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, new GenderForms("\u05d0\u05e4\u05e1", "\u05d0\u05e4\u05e1", "\u05d0\u05e4\u05e1", "\u05d0\u05e4\u05e1"))
                .put(1, new GenderForms("\u05d0\u05d7\u05d3", "\u05d0\u05d7\u05ea", "\u05d0\u05d7\u05d3", "\u05d0\u05d7\u05d3"))
                .put(2, new GenderForms("\u05b9\u05e9\u05e0\u05d9\u05d9\u05dd",
                        "\u05e9\u05ea\u05d9\u05d9\u05dd",
                        "\u05b9\u05e9\u05e0\u05d9\u05d9\u05dd",
                        "\u05b9\u05e9\u05e0\u05d9\u05d9\u05dd"))
                .put(3, new GenderForms("\u05e9\u05dc\u05d5\u05e9\u05d4",
                        "\u05e9\u05dc\u05d5\u05e9",
                        "\u05e9\u05dc\u05d5\u05e9\u05d4",
                        "\u05e9\u05dc\u05d5\u05e9\u05d4"))
                .put(4, new GenderForms("\u05d0\u05e8\u05d1\u05e2\u05d4",
                        "\u05d0\u05e8\u05d1\u05e2",
                        "\u05d0\u05e8\u05d1\u05e2\u05d4",
                        "\u05d0\u05e8\u05d1\u05e2\u05d4"))
                .put(5, new GenderForms("\u05d7\u05de\u05d9\u05e9\u05d4",
                        "\u05d7\u05de\u05e9",
                        "\u05d7\u05de\u05d9\u05e9\u05d4",
                        "\u05d7\u05de\u05d9\u05e9\u05d4"))
                .put(6, new GenderForms("\u05e9\u05d9\u05e9\u05d4",
                        "\u05e9\u05e9",
                        "\u05e9\u05d9\u05e9\u05d4",
                        "\u05e9\u05d9\u05e9\u05d4"))
                .put(7, new GenderForms("\u05e9\u05d1\u05e2\u05d4",
                        "\u05e9\u05d1\u05e2",
                        "\u05e9\u05d1\u05e2\u05d4",
                        "\u05e9\u05d1\u05e2\u05d4"))
                .put(8, new GenderForms("\u05e9\u05de\u05d5\u05e0\u05d4",
                        "\u05e9\u05de\u05d5\u05e0\u05d4",
                        "\u05e9\u05de\u05d5\u05e0\u05d4",
                        "\u05e9\u05de\u05d5\u05e0\u05d4"))
                .put(9, new GenderForms("\u05ea\u05e9\u05e2\u05d4",
                        "\u05ea\u05e9\u05e2",
                        "\u05ea\u05e9\u05e2\u05d4",
                        "\u05ea\u05e9\u05e2\u05d4"))
                .put(10, new GenderForms("\u05e2\u05e9\u05e8\u05d4",
                        "\u05e2\u05e9\u05e8",
                        "\u05e2\u05e9\u05e8\u05d4",
                        "\u05e2\u05e9\u05e8\u05d4"))
                .put(11, new GenderForms("\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8",
                        "\u05d0\u05d7\u05ea \u05e2\u05e9\u05e8\u05d4",
                        "\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8",
                        "\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8"))
                .put(12, new GenderForms("\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8",
                        "\u05e9\u05ea\u05d9\u05dd \u05e2\u05e9\u05e8\u05d4",
                        "\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8",
                        "\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8"))
                .put(13, new GenderForms("\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05dc\u05d5\u05e9 \u05e2\u05e9\u05e8\u05d4",
                        "\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8"))
                .put(14, new GenderForms("\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8",
                        "\u05d0\u05e8\u05d1\u05e2 \u05e2\u05e9\u05e8\u05d4",
                        "\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8",
                        "\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8"))
                .put(15, new GenderForms("\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8",
                        "\u05d7\u05de\u05e9 \u05e2\u05e9\u05e8\u05d4",
                        "\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8",
                        "\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8"))
                .put(16, new GenderForms("\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05e9 \u05e2\u05e9\u05e8\u05d4",
                        "\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8"))
                .put(17, new GenderForms("\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05d1\u05e2 \u05e2\u05e9\u05e8\u05d4",
                        "\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8"))
                .put(18, new GenderForms("\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8\u05d4",
                        "\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8",
                        "\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8"))
                .put(19, new GenderForms("\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8",
                        "\u05ea\u05e9\u05e2 \u05e2\u05e9\u05e8\u05d4",
                        "\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8",
                        "\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8"))
                .put(20, "\u05e2\u05e9\u05e8\u05d9\u05dd")
                .put(30, "\u05e9\u05dc\u05d5\u05e9\u05d9\u05dd")
                .put(40, "\u05d0\u05e8\u05d1\u05e2\u05d9\u05dd")
                .put(50, "\u05d7\u05de\u05d9\u05e9\u05d9\u05dd")
                .put(60, "\u05e9\u05d9\u05e9\u05d9\u05dd")
                .put(70, "\u05e9\u05d1\u05e2\u05d9\u05dd")
                .put(80, "\u05e9\u05de\u05d5\u05e0\u05d9\u05dd")
                .put(90, "\u05ea\u05e9\u05e2\u05d9\u05dd")
                .put(100, "\u05de\u05d0\u05d4")
                .put(200, "\u05de\u05d0\u05ea\u05d9\u05d9\u05dd")
                .put(300, "\u05e9\u05dc\u05d5\u05e9 \u05de\u05d0\u05d5\u05ea")
                .put(400, "\u05d0\u05e8\u05d1\u05e2 \u05de\u05d0\u05d5\u05ea")
                .put(500, "\u05d7\u05de\u05e9 \u05de\u05d0\u05d5\u05ea")
                .put(600, "\u05e9\u05e9 \u05de\u05d0\u05d5\u05ea")
                .put(700, "\u05e9\u05d1\u05e2 \u05de\u05d0\u05d5\u05ea")
                .put(800, "\u05e9\u05de\u05d5\u05e0\u05d4 \u05de\u05d0\u05d5\u05ea")
                .put(900, "\u05ea\u05e9\u05e2 \u05de\u05d0\u05d5\u05ea")
                .put(1000, new GenderForms("\u05d0\u05dc\u05e3", "\u05d0\u05dc\u05e3", "\u05d0\u05dc\u05e3", "\u05d0\u05dc\u05e3"))
                .put(2000, "\u05d0\u05dc\u05e4\u05d9\u05d9\u05dd")
                .put(3000, "\u05e9\u05dc\u05d5\u05e9\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(4000, "\u05d0\u05e8\u05d1\u05e2\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(5000, "\u05d7\u05de\u05e9\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(6000, "\u05e9\u05e9\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(7000, "\u05e9\u05d1\u05e2\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(8000, "\u05e9\u05de\u05d5\u05e0\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(9000, "\u05ea\u05e9\u05e2\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(10000, "\u05e2\u05e9\u05e8\u05ea \u05d0\u05dc\u05e4\u05d9\u05dd")
                .put(11000, "\u05d0\u05d7\u05d3 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(12000, "\u05e9\u05e0\u05d9\u05dd \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(13000, "\u05e9\u05dc\u05d5\u05e9\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(14000, "\u05d0\u05e8\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(15000, "\u05d7\u05de\u05d9\u05e9\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(16000, "\u05e9\u05d9\u05e9\u05d4 \u05e2\u05e8 \u05d0\u05dc\u05e3")
                .put(17000, "\u05e9\u05d1\u05e2\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(18000, "\u05e9\u05de\u05d5\u05e0\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(19000, "\u05ea\u05e9\u05e2\u05d4 \u05e2\u05e9\u05e8 \u05d0\u05dc\u05e3")
                .put(1000000,
                        new GenderForms("\u05de\u05d9\u05dc\u05d9\u05d5\u05df",
                                "\u05de\u05d9\u05dc\u05d9\u05d5\u05df",
                                "\u05de\u05d9\u05dc\u05d9\u05d5\u05df",
                                "\u05de\u05d9\u05dc\u05d9\u05d5\u05df"))
                .put(2000000, "\u05e9\u05e0\u05d9 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(3000000, "\u05e9\u05dc\u05d5\u05e9\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(4000000, "\u05d0\u05e8\u05d1\u05e2\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(5000000, "\u05d7\u05de\u05d9\u05e9\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(6000000, "\u05e9\u05d9\u05e9\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(7000000, "\u05e9\u05d1\u05e2\u05d4 \u05de\u05dc\u05d9\u05d5\u05df")
                .put(8000000, "\u05e9\u05de\u05d5\u05e0\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(9000000, "\u05ea\u05e9\u05e2\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(10000000, "\u05e2\u05e9\u05e8\u05d4 \u05de\u05d9\u05dc\u05d9\u05d5\u05df")
                .put(1000000000, "\u05de\u05d9\u05dc\u05d9\u05d0\u05e8\u05d3")
                .put(2000000000, "\u05e9\u05e0\u05d9 \u05de\u05d9\u05dc\u05d9\u05d0\u05e8\u05d3")
                .build();

    }

    @Override
    public List<PluralForms> pluralForms() {
        return pluralForms;
    }

    public void setPluralForms(GenderType genderType) {
        pluralForms.clear();
        pluralForms.add(new RegularPluralForms("", "", genderType));
    }

    @Override
    public String currency() {
        return "\u20aa";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return '\u05d5';
    }

    public Map<Integer, String> exceptions() {
        return ImmutableMap.<Integer, String>builder().put(1000, "\u05d0\u05dc\u05e3").build();
    }

    public String decimalPrefix() {
        return "\u05d5";
    }

    public String decimalSuffix() {
        return "\u05d0\u05d2\u05d5\u05e8\u05d5\u05ea";
    }
}
