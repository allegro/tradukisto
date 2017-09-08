package pl.allegro.finance.tradukisto.internal.languages.slovak;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm;

public class SlovakValuesForSmallNumbers implements BaseValues {

    private final SlovakValues originalValues = new SlovakValues();

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        Map<Integer, GenderForms> baseNumbers = originalValues.baseNumbers();
        baseNumbers.put(1, genderForm(baseNumbers.get(1).formFor(GenderType.FEMININE)));
        baseNumbers.put(2, genderForm(baseNumbers.get(2).formFor(GenderType.MASCULINE)));
        return baseNumbers;
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(new SlovakPluralForms());
    }

    @Override
    public String currency() {
        return originalValues.currency();
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
