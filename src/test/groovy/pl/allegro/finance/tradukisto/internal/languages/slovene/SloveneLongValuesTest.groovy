package pl.allegro.finance.tradukisto.internal.languages.slovene

import pl.allegro.finance.tradukisto.internal.languages.AbstractLongValuesTest
import spock.lang.Ignore

import static pl.allegro.finance.tradukisto.internal.Container.sloveneContainer

@Ignore("Needs Slovene long converter")
class SloveneLongValuesTest extends AbstractLongValuesTest {

    def setup() {
        longConverter = sloveneContainer().getLongConverter()
    }

    @Override
    LongValuesTestData getTestData() {
        testData = new LongValuesTestData(longTranslations)
    }

    private static longTranslations = [
            1_000_000_000            : "ena milijarda",
            2_000_000_000            : "dve milijardi",
            3_000_000_000            : "tri milijarde",
            4_000_000_000            : "štiri milijarde",
            5_000_000_000            : "pet milijard",
            14_000_000_000           : "štirinajst milijard",

            1_000_000_000_000        : "en bilijon",
            2_000_000_000_000        : "dva bilijona",
            3_000_000_000_000        : "trije bilijoni",
            4_000_000_000_000        : "štirije bilijoni",
            5_000_000_000_000        : "pet bilijonov",
            14_000_000_000_000       : "štirinajst bilijonov",

            1_000_000_000_000_000    : "ena bilijarda",
            2_000_000_000_000_000    : "dve bilijardi",
            3_000_000_000_000_000    : "tri bilijarde",
            4_000_000_000_000_000    : "štiri bilijarde",
            5_000_000_000_000_000    : "pet bilijard",
            14_000_000_000_000_000   : "štirinajst bilijard",

            1_000_000_000_000_000_000: "en trilijon",
            2_000_000_000_000_000_000: "dva trilijona",
            3_000_000_000_000_000_000: "trije trilijoni",
            4_000_000_000_000_000_000: "štirije trilijoni",
            5_000_000_000_000_000_000: "pet trilijonov",
            (Long.MAX_VALUE)         : "devet trilijonov dvjesto triindvajset bilijard tristo dvainsedemdeset bilijonov šestintrideset milijardi osamsto štiriinpedeset milijonov sedamsto petinsedemdeset tisoč sedeminosemsto"
    ]
}
