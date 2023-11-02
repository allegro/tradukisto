package pl.allegro.finance.tradukisto.internal.languages.spanish;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.NumberProcessor;

import java.util.Map;

public class SpanishIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, MultiFormNumber> exceptions;
    private final IntegerToStringConverter smallNumbersConverter;

    public SpanishIntegerToWordsConverter(
        IntegerToStringConverter bigNumbersConverter,
        Map<Integer, MultiFormNumber> exceptions,
        IntegerToStringConverter smallNumbersConverter
    ) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {

        if (exceptions.containsKey(value)) {
            return exceptions.get(value).getAloneForm();
        }

        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        String numberProcessor = new NumberProcessor(bigNumbersConverter, smallNumbersConverter).process(bigNumber, smallNumber);

        if (value.toString().endsWith("1") && !value.toString().endsWith("11")) {
            numberProcessor += "o";
        }
        if (value == 1_000_000_000) {
            numberProcessor = "mil millones";
        }
        if (value > 1_000_000_000) {
            numberProcessor = numberProcessor.replace("un mil millones", "mil");
        }
        if (value == 2_000_000_000) {
            numberProcessor = "dos mil millones";
        }
        if (value > 2_000_000_000) {
            numberProcessor = numberProcessor.replace("un millón", "un millones")
                    .replace("dos mil millones", "dos mil");
        }
        return numberProcessor;
    }
}