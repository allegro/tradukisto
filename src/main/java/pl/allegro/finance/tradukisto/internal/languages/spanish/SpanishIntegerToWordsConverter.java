package pl.allegro.finance.tradukisto.internal.languages.spanish;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.MultiFormNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class SpanishIntegerToWordsConverter implements IntegerToStringConverter {

    private static final int MILLION = 1_000_000;
    private static final String VEINTIUN = "veintiún";

    private final Map<Integer, MultiFormNumber> exceptions;
    private final IntegerToStringConverter smallNumbersConverter;

    public SpanishIntegerToWordsConverter(
        Map<Integer, MultiFormNumber> exceptions,
        IntegerToStringConverter smallNumbersConverter
    ) {
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value).getAloneForm();
        }
        if (value == 0) {
            return smallNumbersConverter.asWords(value);
        }

        Integer millions = value / MILLION;
        Integer rest = value % MILLION;
        List<String> parts = new ArrayList<>();

        if (millions == 1) {
            parts.add("un millón");
        } else if (millions > 1) {
            parts.add(format("%s millones", beforeNounAsWords(millions)));
        }
        if (rest > 0) {
            parts.add(aloneAsWords(rest));
        }
        return String.join(" ", parts);
    }

    // Before a noun Spanish shortens the number: "un", "veintiún", "cien" ("veintiún millones").
    private String beforeNounAsWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value).getAloneForm();
        }
        return smallNumbersConverter.asWords(value);
    }

    // At the end of the number the full form is used: "uno", "veintiuno" ("ciento veintiuno").
    private String aloneAsWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value).getAloneForm();
        }
        String words = smallNumbersConverter.asWords(value);
        if (words.endsWith(VEINTIUN)) {
            return words.substring(0, words.length() - VEINTIUN.length()) + "veintiuno";
        }
        if (value % 10 == 1 && value % 100 != 11) {
            return words + "o";
        }
        return words;
    }
}
