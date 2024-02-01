package pl.allegro.finance.tradukisto.internal.languages.greek;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechPluralForms;
import pl.allegro.finance.tradukisto.internal.languages.czech.CzechValues;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm;

public class GreekValuesForSmallNumbers implements BaseValues {
    private final GreekValues originalValues = new GreekValues();

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        Map<Integer, GenderForms> baseNumbers = originalValues.baseNumbers();
        baseNumbers.put(1, genderForm(baseNumbers.get(1).formFor(GenderType.MASCULINE)));
        baseNumbers.put(3, genderForm(baseNumbers.get(3).formFor(GenderType.MASCULINE)));
        baseNumbers.put(4, genderForm(baseNumbers.get(4).formFor(GenderType.MASCULINE)));
        return baseNumbers;
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(new GreekPluralForms("", "", "", GenderType.NON_APPLICABLE));
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
