package pl.allegro.finance.tradukisto.internal.languages.croatian

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.croatianContainer

class CroatianLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = croatianContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000            : "pet milijardi",

            1_000_000_000_000        : "jedan bilijun",
            2_000_000_000_000        : "dva bilijuna",
            5_000_000_000_000        : "pet bilijuna",

            1_000_000_000_000_000    : "jedna bilijarda",
            2_000_000_000_000_000    : "dvije bilijarde",
            5_000_000_000_000_000    : "pet bilijardi",

            1_000_000_000_000_000_000: "jedan trilijun",
            2_000_000_000_000_000_000: "dva trilijuna",
            (Long.MAX_VALUE)         : "devet trilijuna dvjesto dvadeset tri bilijarde tristo sedamdeset dva bilijuna trideset šest milijardi osamsto pedeset četiri milijuna sedamsto sedamdeset pet tisuća osamsto sedam"
    ]
}
