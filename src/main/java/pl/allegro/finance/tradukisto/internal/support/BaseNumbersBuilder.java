package pl.allegro.finance.tradukisto.internal.support;

import pl.allegro.finance.tradukisto.internal.languages.GenderForms;

import java.util.HashMap;
import java.util.Map;

public class BaseNumbersBuilder {

    private Map<Integer, GenderForms> result = new HashMap<>();

    public static BaseNumbersBuilder baseNumbersBuilder() {
        return new BaseNumbersBuilder();
    }

    public BaseNumbersBuilder put(Integer number, GenderForms forms) {
        result.put(number, forms);
        return this;
    }

    public BaseNumbersBuilder put(Integer number, String form) {
        result.put(number, new GenderForms(form));
        return this;
    }

    public Map<Integer, GenderForms> build() {
        return result;
    }
}
