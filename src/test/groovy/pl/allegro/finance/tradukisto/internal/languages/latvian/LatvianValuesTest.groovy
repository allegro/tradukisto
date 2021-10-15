package pl.allegro.finance.tradukisto.internal.languages.latvian

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.latvianContainer

class LatvianValuesTest extends Specification {

	static intConverter = latvianContainer().getIntegerConverter()
	static longConverter = latvianContainer().getLongConverter()

	@Unroll
	def "should convert #value to '#words' in Latvian"() {
		expect:
		intConverter.asWords(value) == words

		where:
		value         | words
		0             | "nulle"
		1             | "viens"
		2             | "divi"
		3             | "trīs"
		4             | "četri"
		5             | "pieci"
		6             | "seši"
		7             | "septiņi"
		8             | "astoņi"
		9             | "deviņi"

		11            | "vienpadsmit"
		12            | "divpadsmit"
		13            | "trīspadsmit"
		14            | "četrpadsmit"
		15            | "piecpadsmit"
		16            | "sešpadsmit"
		17            | "septiņpadsmit"
		18            | "astoņpadsmit"
		19            | "deviņpadsmit"

		10            | "desmit"
		20            | "divdesmit"
		30            | "trīsdesmit"
		40            | "četrdesmit"
		50            | "piecdesmit"
		60            | "sešdesmit"
		70            | "septiņdesmit"
		80            | "astoņdesmit"
		90            | "deviņdesmit"

		21            | "divdesmit viens"
		37            | "trīsdesmit septiņi"
		43            | "četrdesmit trīs"
		58            | "piecdesmit astoņi"
		69            | "sešdesmit deviņi"
		76            | "septiņdesmit seši"
		82            | "astoņdesmit divi"
		95            | "deviņdesmit pieci"

		100           | "viens simts"
		200           | "divi simti"
		300           | "trīs simti"
		400           | "četri simti"
		500           | "pieci simti"
		600           | "seši simti"
		700           | "septiņi simti"
		800           | "astoņi simti"
		900           | "deviņi simti"

		111           | "viens simts vienpadsmit"
		272           | "divi simti septiņdesmit divi"
		387           | "trīs simti astoņdesmit septiņi"
		448           | "četri simti četrdesmit astoņi"
		569           | "pieci simti sešdesmit deviņi"
		625           | "seši simti divdesmit pieci"
		777           | "septiņi simti septiņdesmit septiņi"
		782           | "septiņi simti astoņdesmit divi"
		895           | "astoņi simti deviņdesmit pieci"
		999           | "deviņi simti deviņdesmit deviņi"

		1_000         | "viens tūkstotis"
		2_000         | "divi tūkstoši"
		3_000         | "trīs tūkstoši"
		4_000         | "četri tūkstoši"
		5_000         | "pieci tūkstoši"
		7_634         | "septiņi tūkstoši seši simti trīsdesmit četri"
		11_000        | "vienpadsmit tūkstoši"
		15_000        | "piecpadsmit tūkstoši"
		21_000        | "divdesmit viens tūkstotis"
		22_000        | "divdesmit divi tūkstoši"
		24_190        | "divdesmit četri tūkstoši viens simts deviņdesmit"
		653_000       | "seši simti piecdesmit trīs tūkstoši"
		211_000       | "divi simti vienpadsmit tūkstoši"
		123_454       | "viens simts divdesmit trīs tūkstoši četri simti piecdesmit četri"
		700_000       | "septiņi simti tūkstoši"
		751_221       | "septiņi simti piecdesmit viens tūkstotis divi simti divdesmit viens"
		999_999       | "deviņi simti deviņdesmit deviņi tūkstoši deviņi simti deviņdesmit deviņi"

		1_000_000     | "viens miljons"
		2_000_000     | "divi miljoni"
		5_000_000     | "pieci miljoni"
		7_211_000     | "septiņi miljoni divi simti vienpadsmit tūkstoši"
		23_437_219    | "divdesmit trīs miljoni četri simti trīsdesmit septiņi tūkstoši divi simti deviņpadsmit"
		100_000_000   | "viens simts miljoni"
		123_456_789   | "viens simts divdesmit trīs miljoni četri simti piecdesmit seši tūkstoši septiņi simti " +
				"astoņdesmit deviņi"
		322_089_890   | "trīs simti divdesmit divi miljoni astoņdesmit deviņi tūkstoši astoņi simti deviņdesmit"

		1_000_000_000 | "viens miljards"
		2_147_483_647 | "divi miljardi viens simts četrdesmit septiņi miljoni četri simti astoņdesmit trīs tūkstoši " +
				"seši simti četrdesmit septiņi"
	}

	def "should convert any value in range of 0-999 in Latvian"() {
		when:
		def words = intConverter.asWords(value)

		then:
		notThrown(IllegalArgumentException)
		words.length() > 0

		where:
		value << (0..999)
	}

	@Ignore("Needs Latvian long converter and values for trillion, quadrillion, quintillion")
	@Unroll
	def "should convert long #value to '#words' in Latvian"() {
		expect:
		longConverter.asWords(value) == words

		where:
		value                     | words
		5_000_000_000             | ""

		1_000_000_000_000         | ""
		2_000_000_000_000         | ""
		5_000_000_000_000         | ""

		1_000_000_000_000_000     | ""
		2_000_000_000_000_000     | ""
		5_000_000_000_000_000     | ""

		1_000_000_000_000_000_000 | ""
		2_000_000_000_000_000_000 | ""
		Long.MAX_VALUE            | ""
	}
}
