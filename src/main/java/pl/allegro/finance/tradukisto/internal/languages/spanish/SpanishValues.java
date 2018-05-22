/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package pl.allegro.finance.tradukisto.internal.languages.spanish;

import static pl.allegro.finance.tradukisto.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import pl.allegro.finance.tradukisto.internal.MultiFormNumber;
import pl.allegro.finance.tradukisto.internal.languages.GenderForms;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.languages.RegularPluralForms;

public class SpanishValues {

    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "cero")
                .put(1, "uno")
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
                .put(21, "veintiuno")
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
                .put(200, "doscientos")
                .put(300, "trescientos")
                .put(400, "cuatrocientos")
                .put(500, "quinientos")
                .put(600, "seiscientos")
                .put(700, "setecientos")
                .put(800, "ochocientos")
                .put(900, "novecientos")
                .put(1000000, "un millón")
                .build();
    }

    public Map<Integer, MultiFormNumber> exceptions() {
        return ImmutableMap.<Integer, MultiFormNumber>builder()
                .put(100, new MultiFormNumber("cien", "ciento"))
                .build();
    }

    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new RegularPluralForms("millón", "millones"));
    }

    public String currency() {
        return "€";
    }

}
