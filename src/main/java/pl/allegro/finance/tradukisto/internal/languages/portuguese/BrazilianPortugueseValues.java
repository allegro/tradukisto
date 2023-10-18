package pl.allegro.finance.tradukisto.internal.languages.portuguese;

import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class BrazilianPortugueseValues  {

    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "zero")
                .put(1, "um")
                .put(2, "dois")
                .put(3, "três")
                .put(4, "quatro")
                .put(5, "cinco")
                .put(6, "seis")
                .put(7, "sete")
                .put(8, "oito")
                .put(9, "nove")
                .put(10, "dez")
                .put(11, "onze")
                .put(12, "doze")
                .put(13, "treze")
                .put(14, "catorze")
                .put(15, "quinze")
                .put(16, "dezesseis")
                .put(17, "dezessete")
                .put(18, "dezoito")
                .put(19, "dezenove")
                .put(20, "vinte")
                .put(30, "trinta")
                .put(40, "quarenta")
                .put(50, "cinquenta")
                .put(60, "sessenta")
                .put(70, "setenta")
                .put(80, "oitenta")
                .put(90, "noventa")
                .put(200, "duzentos")
                .put(300, "trezentos")
                .put(400, "quatrocentos")
                .put(500, "quinhentos")
                .put(600, "seiscentos")
                .put(700, "setecentos")
                .put(800, "oitocentos")
                .put(900, "novecentos")
                .build();
    }

    public Map<Integer, MultiFormNumber> exceptions() {
        return singletonMap(100, new MultiFormNumber("cem", "cento"));
    }

    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new RegularPluralForms("milhão", "milhões"),
            new RegularPluralForms("bilhão", "bilhões")
        );
    }

    public String currency() {
        return "R$";
    }

}
