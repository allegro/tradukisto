package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.support.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static pl.allegro.finance.tradukisto.internal.Container.brazilianPortugueseContainer;
import static pl.allegro.finance.tradukisto.internal.Container.bulgarianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.croatianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.czechContainer;
import static pl.allegro.finance.tradukisto.internal.Container.englishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.frenchContainer;
import static pl.allegro.finance.tradukisto.internal.Container.germanContainer;
import static pl.allegro.finance.tradukisto.internal.Container.italianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.kazakhContainer;
import static pl.allegro.finance.tradukisto.internal.Container.latvianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.russianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.serbianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.serbianCyrillicContainer;
import static pl.allegro.finance.tradukisto.internal.Container.slovakContainer;
import static pl.allegro.finance.tradukisto.internal.Container.turkishContainer;
import static pl.allegro.finance.tradukisto.internal.Container.ukrainianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.bulgarianContainer;
import static pl.allegro.finance.tradukisto.internal.Container.dutchContainer;

public enum ValueConverters {

    BRAZILIAN_PORTUGUESE_INTEGER(brazilianPortugueseContainer().getIntegerConverter(), Arrays.asList("pt", "pt-br")),
    ENGLISH_INTEGER(englishContainer().getIntegerConverter(), "en"),
    GERMAN_INTEGER(germanContainer().getIntegerConverter(), "de"),
    RUSSIAN_INTEGER(russianContainer().getIntegerConverter(), "ru"),
    ITALIAN_INTEGER(italianContainer().getIntegerConverter(), "it"),
    POLISH_INTEGER(polishContainer().getIntegerConverter(), "pl"),
    CROATIAN_INTEGER(croatianContainer().getIntegerConverter(), "hr"),
    CZECH_INTEGER(czechContainer().getIntegerConverter(), "cs"),
    SLOVAK_INTEGER(slovakContainer().getIntegerConverter(), "sk"),
    LATVIAN_INTEGER(latvianContainer().getIntegerConverter(), "lv"),
    KAZAKH_INTEGER(kazakhContainer().getIntegerConverter(), "kk"),
    UKRAINIAN_INTEGER(ukrainianContainer().getIntegerConverter(), "uk"),
    SERBIAN_INTEGER(serbianContainer().getIntegerConverter(), Arrays.asList("sr", getLanguageCodeFor("sr", "Latn"))),
    SERBIAN_CYRILLIC_INTEGER(serbianCyrillicContainer().getIntegerConverter(), getLanguageCodeFor("sr", "Cyrl")),
    BULGARIAN_INTEGER(bulgarianContainer().getIntegerConverter(), "bg"),
    FRENCH_INTEGER(frenchContainer().getIntegerConverter(), "fr"),
    TURKISH_INTEGER(turkishContainer().getIntegerConverter(), "tr"),
    DUTCH_INTEGER(dutchContainer().getIntegerConverter(), "nl");

    private final IntegerToStringConverter converter;
    private final List<String> languageCodes;

    ValueConverters(IntegerToStringConverter converter, String languageCodes) {
        this(converter, Collections.singletonList(languageCodes));
    }

    ValueConverters(IntegerToStringConverter converter, List<String> languageCodes) {
        this.converter = converter;
        this.languageCodes = languageCodes;
    }

    public static ValueConverters getByLocaleOrDefault(Locale locale, ValueConverters defaultConverter) {
        Objects.requireNonNull(locale);

        String languageCode = hasSpecifiedScript(locale)
                ? getLanguageCodeFor(locale.getLanguage(), locale.getScript())
                : locale.getLanguage();

        return getByLanguageCodeOrDefault(languageCode, defaultConverter);
    }

    public static ValueConverters getByLanguageCodeOrDefault(String languageCode, ValueConverters defaultConverter) {
        Objects.requireNonNull(languageCode);
        Assert.isFalse(languageCode.isEmpty());

        return Arrays.stream(values())
                .filter(it -> it.languageCodes.contains(languageCode))
                .findFirst()
                .orElse(defaultConverter);
    }

    private static boolean hasSpecifiedScript(Locale locale) {
        return !locale.getScript().isEmpty();
    }

    private static String getLanguageCodeFor(String language, String script) {
        return new Locale.Builder()
                .setLanguage(language)
                .setScript(script)
                .build()
                .toString();
    }

    public String asWords(Integer value) {
        Objects.requireNonNull(value);

        return converter.asWords(value);
    }
}
