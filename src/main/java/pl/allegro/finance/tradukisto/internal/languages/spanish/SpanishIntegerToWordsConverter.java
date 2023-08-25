package pl.allegro.finance.tradukisto.internal.languages.spanish;

import java.util.Map;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.NumberProcessor;
import pl.allegro.finance.tradukisto.internal.support.Range;

public class SpanishIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, MultiFormNumber> exceptions;
    private final IntegerToStringConverter smallNumbersConverter;

    public SpanishIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                          Map<Integer, MultiFormNumber> exceptions,
                                          IntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        String numberProcessor;
        if (exceptions.containsKey(value)) {
            return exceptions.get(value).getAloneForm();
        }

        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        numberProcessor = new NumberProcessor(bigNumbersConverter, smallNumbersConverter).process(bigNumber, smallNumber);

        if (value.toString().endsWith("1") && !value.toString().endsWith("11")) {
            numberProcessor = numberProcessor + "o";
        }
        if (Range.closed(1_000_000_000, 1_999_999_999).contains(value)) {
            if (value == 1_000_000_000) {
                numberProcessor = "mil millones";
            } else if (value >= 1_000_000_000) {
                numberProcessor = numberProcessor.replace("un mil millones", "mil");
            }
        }
        if (Range.closed(2_000_000_000, Integer.MAX_VALUE).contains(value)) {
            if (value == 2_000_000_000) {
                numberProcessor = "dos mil millones";
            } else if (value >= 2_000_000_000) {
                numberProcessor = numberProcessor.replace("un millón", "un millones")
                        .replace("dos mil millones", "dos mil");
            }
        }
        return numberProcessor;
    }
}