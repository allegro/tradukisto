package pl.allegro.finance.tradukisto.internal.languages.polish

import pl.allegro.finance.tradukisto.internal.languages.AbstractIntegerValuesTest

import static pl.allegro.finance.tradukisto.internal.Container.polishContainer

class PolishIntegerValuesTest extends AbstractIntegerValuesTest {

    def setup() {
        intConverter = polishContainer().getIntegerConverter()
    }

    @Override
    IntegerValuesTestData getTestData() {
        testData = new IntegerValuesTestData(integerTranslations)
    }

    private static integerTranslations = [
            0                  : "zero",
            1                  : "jeden",
            2                  : "dwa",
            3                  : "trzy",
            4                  : "cztery",
            5                  : "pięć",
            6                  : "sześć",
            7                  : "siedem",
            8                  : "osiem",
            9                  : "dziewięć",

            11                 : "jedenaście",
            12                 : "dwanaście",
            13                 : "trzynaście",
            14                 : "czternaście",
            15                 : "piętnaście",
            16                 : "szesnaście",
            17                 : "siedemnaście",
            18                 : "osiemnaście",
            19                 : "dziewiętnaście",

            10                 : "dziesięć",
            20                 : "dwadzieścia",
            30                 : "trzydzieści",
            40                 : "czterdzieści",
            50                 : "pięćdziesiąt",
            60                 : "sześćdziesiąt",
            70                 : "siedemdziesiąt",
            80                 : "osiemdziesiąt",
            90                 : "dziewięćdziesiąt",

            21                 : "dwadzieścia jeden",
            37                 : "trzydzieści siedem",
            43                 : "czterdzieści trzy",
            58                 : "pięćdziesiąt osiem",
            69                 : "sześćdziesiąt dziewięć",
            76                 : "siedemdziesiąt sześć",
            82                 : "osiemdziesiąt dwa",
            95                 : "dziewięćdziesiąt pięć",

            100                : "sto",
            200                : "dwieście",
            300                : "trzysta",
            400                : "czterysta",
            500                : "pięćset",
            600                : "sześćset",
            700                : "siedemset",
            800                : "osiemset",
            900                : "dziewięćset",

            111                : "sto jedenaście",
            272                : "dwieście siedemdziesiąt dwa",
            387                : "trzysta osiemdziesiąt siedem",
            448                : "czterysta czterdzieści osiem",
            569                : "pięćset sześćdziesiąt dziewięć",
            625                : "sześćset dwadzieścia pięć",
            782                : "siedemset osiemdziesiąt dwa",
            895                : "osiemset dziewięćdziesiąt pięć",
            999                : "dziewięćset dziewięćdziesiąt dziewięć",

            1_000              : "jeden tysiąc",
            2_000              : "dwa tysiące",
            5_000              : "pięć tysięcy",
            7_634              : "siedem tysięcy sześćset trzydzieści cztery",
            24_190             : "dwadzieścia cztery tysiące sto dziewięćdziesiąt",
            653_000            : "sześćset pięćdziesiąt trzy tysiące",
            123_454            : "sto dwadzieścia trzy tysiące czterysta pięćdziesiąt cztery",
            700_000            : "siedemset tysięcy",
            999_999            : "dziewięćset dziewięćdziesiąt dziewięć tysięcy dziewięćset dziewięćdziesiąt dziewięć",

            1_000_000          : "jeden milion",
            2_000_000          : "dwa miliony",
            5_000_000          : "pięć milionów",
            23_437_219         : "dwadzieścia trzy miliony czterysta trzydzieści siedem tysięcy dwieście dziewiętnaście",
            100_000_000        : "sto milionów",
            123_456_789        : "sto dwadzieścia trzy miliony czterysta pięćdziesiąt sześć tysięcy siedemset " +
                    "osiemdziesiąt dziewięć",

            1_000_000_000      : "jeden miliard",
            (Integer.MAX_VALUE): "dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące " +
                    "sześćset czterdzieści siedem"
    ]
}
