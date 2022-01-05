package pl.allegro.finance.tradukisto.internal.support;

import pl.allegro.finance.tradukisto.internal.languages.GenderForms;

import java.util.HashMap;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm;

public class BaseNumbersBuilder {

    private final Map<Integer, GenderForms> result = new HashMap<>();

    public static BaseNumbersBuilder baseNumbersBuilder() {
        return new BaseNumbersBuilder();
    }

    public BaseNumbersBuilder put(Integer number, GenderForms forms) {
        if (result.containsKey(number)) {
            throw new NumberAlreadyMappedException(number);
        }
        result.put(number, forms);
        return this;
    }

    public BaseNumbersBuilder put(Integer number, String form) {
        if (result.containsKey(number)) {
            throw new NumberAlreadyMappedException(number);
        }
        result.put(number, genderForm(form));
        return this;
    }

    public Map<Integer, GenderForms> build() {
        return result;
    }
}

class NumberAlreadyMappedException extends RuntimeException {
    NumberAlreadyMappedException(Integer number) {
        super("Number " + number + " already mapped");
    }
}
