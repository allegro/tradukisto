package pl.allegro.finance.tradukisto.internal.languages.dutch

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.dutchContainer
import static pl.allegro.finance.tradukisto.internal.Container.polishContainer

class DutchLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = dutchContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            5_000_000_000             : "vijf miljard",

            1_000_000_000_000         : "één biljoen",
            2_000_000_000_000         : "twee biljoen",
            5_000_000_000_000         : "vijf biljoen",

            1_000_000_000_000_000     : "één biljard",
            2_000_000_000_000_000     : "twee biljard",
            5_000_000_000_000_000     : "vijf biljard",
            
            1_000_000_000_000_000_000 : "één triljoen",
            2_000_000_000_000_000_000 : "twee triljoen",
            (Long.MAX_VALUE)            : "negen triljoen tweehonderddrieëntwintig biljard " +
                    "driehonderdtweeënzeventig biljoen zesendertig miljard " +
                    "achthonderdvierenvijftig miljoen zevenhonderdvijfenzeventigduizendachthonderdzeven"
    ]
}
