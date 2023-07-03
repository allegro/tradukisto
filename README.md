Tradukisto
==========

[![Build](https://github.com/allegro/tradukisto/actions/workflows/ci.yml/badge.svg)](https://github.com/allegro/tradukisto/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/allegro/tradukisto/branch/master/graph/badge.svg?token=YO4NcWxDCI)](https://codecov.io/gh/allegro/tradukisto)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.allegro.finance/tradukisto/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/pl.allegro.finance/tradukisto)

Tradukisto is a library for Java 8+ created to convert numbers to their word representations.

The main motivation behind its creation was the lack of a production-ready tool providing number conversion for the Polish language. 
There are many individual classes, but we felt there is space for something well-tested and ready to use in production without copy-pasting someone else's code.

Features
--------

* Converts `Integer` to `String` with numerical representation support.
* Converts `Long` to `String` with numerical representation support.
* Converts `BigDecimal` to `String` with money representation support.

Supported languages
-------------------

* Brazilian Portuguese
* Bulgarian
* Czech
* English
* French
* German
* Italian
* Kazakh
* Latvian
* Polish
* Russian
* Slovak
* Ukrainian
* Serbian (Latin)
* Serbian (Cyrillic)
* Turkish

Usage
-----

Add `tradukisto` as a dependency:

```
dependencies {
    implementation("pl.allegro.finance:tradukisto:1.12.1")
}
```

and use it:

```java
ValueConverters intConverter = ValueConverters.ENGLISH_INTEGER;
String valueAsWords = intConverter.asWords(1_234);

assertEquals("one thousand two hundred thirty-four", valueAsWords);
```

```java
LongValueConverters longConverter = LongValueConverters.ENGLISH_LONG;
String valueAsWords = converter.asWords(1_000_000_000_000_000_000);

assertEquals("one quintillion", valueAsWords);
```

```java
MoneyConverters converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;

String moneyAsWords = converter.asWords(new BigDecimal("1234.56"));
assertEquals("one thousand two hundred thirty-four £ 56/100", moneyAsWords);

String moneyAsWordsWithCurrency = converter.asWords(new BigDecimal("1234.56", "EUR"));
assertEquals("one thousand two hundred thirty-four EUR 56/100", moneyAsWordsWithCurrency);
```

Tradukisto can handle only values with no more than two digits after the decimal point. Otherwise, `IllegalArgumentException` will be thrown. 
For that reason, you should either construct `BigDecimal` object based on the `String` value as shown 
in the example above or use [setScale](http://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html#setScale(int,%20java.math.RoundingMode))
method to ensure that the given value has appropriate precision.
