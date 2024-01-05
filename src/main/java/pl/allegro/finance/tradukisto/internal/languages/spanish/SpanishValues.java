package pl.allegro.finance.tradukisto.internal.languages.spanish;

import pl.allegro.finance.tradukisto.internal.BaseValues;
import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pl.allegro.finance.tradukisto.internal.languages.GenderForms.genderForms;
import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;
import static pl.allegro.finance.tradukisto.internal.support.MapSupport.unmodifiableEntry;
import static pl.allegro.finance.tradukisto.internal.support.MapSupport.unmodifiableMapOf;

public class SpanishValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "cero")
                .put(1, genderForms("uno", "una", "un"))
                .put(2, "dos")
                .put(3, "tres")
                .put(4, "cuatro")
                .put(5, "cinco")
                .put(6, "seis")
                .put(7, "siete")
                .put(8, "ocho")
                .put(9, "nueve")
                .put(10, "diez")
                .put(11, "once")
                .put(12, "doce")
                .put(13, "trece")
                .put(14, "catorce")
                .put(15, "quince")
                .put(16, "dieciséis")
                .put(17, "diecisiete")
                .put(18, "dieciocho")
                .put(19, "diecinueve")
                .put(20, "veinte")
                .put(21, genderForms("veintiuno", "veintiuna", "veintiun"))
                .put(22, "veintidós")
                .put(23, "veintitrés")
                .put(24, "veinticuatro")
                .put(25, "veinticinco")
                .put(26, "veintiséis")
                .put(27, "veintisiete")
                .put(28, "veintiocho")
                .put(29, "veintinueve")
                .put(30, "treinta")
                .put(40, "cuarenta")
                .put(50, "cincuenta")
                .put(60, "sesenta")
                .put(70, "setenta")
                .put(80, "ochenta")
                .put(90, "noventa")
                .put(200, genderForms("doscientos", "doscientas", "doscientos"))
                .put(300, genderForms("trescientos", "trescientas", "trescientos"))
                .put(400, genderForms("cuatrocientos", "cuatrocientas", "cuatrocientos"))
                .put(500, genderForms("quinientos", "quinientas", "quinientos"))
                .put(600, genderForms("seiscientos", "seiscientas", "seiscientos"))
                .put(700, genderForms("setecientos", "setecientas", "setecientos"))
                .put(800, genderForms("ochocientos", "ochocientas", "ochocientos"))
                .put(900, genderForms("novecientos", "novecientas", "novecientos"))
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
            new RegularPluralForms("millón", "millones"),
            new RegularPluralForms("mil millones", "mil millones")
        );

    }

    @Override
    public String currency() {
        return "€";
    }


    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }

    public Map<Integer, MultiFormNumber> exceptions() {
        return unmodifiableMapOf(
                unmodifiableEntry(1, new MultiFormNumber("uno", "un")),
                unmodifiableEntry(100, new MultiFormNumber("cien", "ciento")),
                unmodifiableEntry(100000000, new MultiFormNumber("cien millones", "ciento millones"))
        );

    }
}
