package pl.allegro.finance.tradukisto;

import pl.allegro.finance.tradukisto.internal.Container;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.support.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public enum ValueConverters {

    BRAZILIAN_PORTUGUESE_INTEGER(Container.brazilianPortugueseContainer().getIntegerConverter(), Arrays.asList("pt", "pt-br")),
    ENGLISH_INTEGER(Container.englishContainer().getIntegerConverter(), "en"),
    GERMAN_INTEGER(Container.germanContainer().getIntegerConverter(), "de"),
    RUSSIAN_INTEGER(Container.russianContainer().getIntegerConverter(), "ru"),
    ITALIAN_INTEGER(Container.italianContainer().getIntegerConverter(), "it"),
    POLISH_INTEGER(Container.polishContainer().getIntegerConverter(), "pl"),
    CROATIAN_INTEGER(Container.croatianContainer().getIntegerConverter(), "hr"),
    CZECH_INTEGER(Container.czechContainer().getIntegerConverter(), "cs"),
    SLOVAK_INTEGER(Container.slovakContainer().getIntegerConverter(), "sk"),
    LATVIAN_INTEGER(Container.latvianContainer().getIntegerConverter(), "lv"),
    KAZAKH_INTEGER(Container.kazakhContainer().getIntegerConverter(), "kk"),
    KYRGYZ_INTEGER(Container.kyrgyzContainer().getIntegerConverter(), "ky"),
    UKRAINIAN_INTEGER(Container.ukrainianContainer().getIntegerConverter(), "uk"),
    SERBIAN_INTEGER(Container.serbianContainer().getIntegerConverter(), Arrays.asList("sr", getLanguageCodeFor("sr", "Latn"))),
    SERBIAN_CYRILLIC_INTEGER(Container.serbianCyrillicContainer().getIntegerConverter(), getLanguageCodeFor("sr", "Cyrl")),
    BULGARIAN_INTEGER(Container.bulgarianContainer().getIntegerConverter(), "bg"),
    FRENCH_INTEGER(Container.frenchContainer().getIntegerConverter(), "fr"),
    TURKISH_INTEGER(Container.turkishContainer().getIntegerConverter(), "tr"),
    DUTCH_INTEGER(Container.dutchContainer().getIntegerConverter(), "nl"),
    SLOVENE_INTEGER(Container.sloveneContainer().getIntegerConverter(), "sl"),
    SPANISH_INTEGER(Container.spanishContainer().getIntegerConverter(), "es"),
    HINDI_INTEGER(Container.hindiContainer().getIntegerConverter(), "hi"),
    SWEDISH_INTEGER(Container.swedishContainer().getIntegerConverter(), "sv"),
    JAPANESE_INTEGER(Container.japaneseKanjiContainer().getIntegerConverter(), "ja");

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
