package pl.allegro.finance.tradukisto.internal.languages.czech;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForm;

public class CzechValuesForSmallNumbers implements BaseValues {

    private final CzechValues originalValues = new CzechValues();

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        Map<Integer, GenderForms> baseNumbers = originalValues.baseNumbers();
        baseNumbers.put(1, genderForm(baseNumbers.get(1).formFor(GenderType.FEMININE)));
        baseNumbers.put(2, genderForm(baseNumbers.get(2).formFor(GenderType.MASCULINE)));
        return baseNumbers;
    }

    @Override
    public List<? extends PluralForms> pluralForms() {
        return asList(
                new CzechPluralForms("", "", "", GenderType.NON_APPLICABLE));
    }

    @Override
    public String currency() {
        return originalValues.currency();
    }
}
