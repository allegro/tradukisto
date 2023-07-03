Tradukisto
==========

[![Build](https://github.com/allegro/tradukisto/actions/workflows/ci.yml/badge.svg)](https://github.com/allegro/tradukisto/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/allegro/tradukisto/branch/master/graph/badge.svg?token=YO4NcWxDCI)](https://codecov.io/gh/allegro/tradukisto)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.allegro.finance/tradukisto/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/pl.allegro.finance/tradukisto)

Introduction
------------
Tradukisto is a powerful Java 8+ library designed to **convert numbers** into their corresponding **word representations**.

Our main goal is to create a production-ready tool providing number conversion for the human language.
We recognized the need for a well-tested and ready solution that eliminates the hassle of copying and pasting code from different sources.
With Tradukisto, you can now transform numbers into their word equivalents easy way!

Features
--------

* Converts `Integer` to `String` with numerical representation support.
* Converts `Long` to `String` with numerical representation support.
* Converts `BigDecimal` to `String` with money representation support.

Supported languages
-------------------

* 🇧🇷🇵🇹 Brazilian Portuguese
* 🇧🇬 Bulgarian
* 🇨🇿 Czech
* 🇬🇧 English
* 🇫🇷 French
* 🇩🇪 German
* 🇮🇹 Italian
* 🇰🇿 Kazakh
* 🇱🇻 Latvian
* 🇵🇱 Polish
* 🇷🇺 Russian
* 🇸🇰 Slovak
* 🇺🇦 Ukrainian
* 🇷🇸 Serbian (Latin)
* 🇷🇸 Serbian (Cyrillic)
* 🇹🇷 Turkish

Usage
-----

Add `tradukisto` as a dependency:

```
repositories {
    mavenCentral()
}

dependencies {
    compile 'pl.allegro.finance:tradukisto:1.12.0'
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

Tradukisto can handle only values with no more than two digits after the decimal point. Otherwise, `IllegalArgumentException` will be thrown. For that reason, you should either construct `BigDecimal` object based on the `String` value as shown in the example above or use [setScale](http://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html#setScale(int,%20java.math.RoundingMode))
method to ensure that the given value has appropriate precision.

Issues
------
Before you open an [issue](https://github.com/allegro/tradukisto/issues), please ensure that there are no duplicates. 

Changelog
---------
Each release is documented in the [release notes](https://github.com/allegro/tradukisto/releases).

License
-------

Copyright 2015-2022 Allegro Group

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
