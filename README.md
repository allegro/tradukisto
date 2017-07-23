Tradukisto
==========

[![Build Status](https://travis-ci.org/allegro/tradukisto.svg?branch=master)](https://travis-ci.org/allegro/tradukisto)
[![Coverage Status](https://coveralls.io/repos/allegro/tradukisto/badge.svg?branch=master)](https://coveralls.io/r/allegro/tradukisto?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.allegro.finance/tradukisto/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/pl.allegro.finance/tradukisto)

Tradukisto is a Java library created to convert numbers to their word representations.

The main motivation behind its creation was lack of a production ready tool which provides numbers conversion for the 
Polish language. There are many single classes, but we felt there is definitely space for something well tested and
ready to use in production without copy pasting someone else's code.

Features
--------

* Converts `Integer` to `String` with numerical representation support.
* Converts `BigDecimal` to `String` with money representation support.

Supported languages
-------------------

* English
* Polish
* Czech
* Russian
* German
* Brazilian Portuguese

Usage
-----

Add `tradukisto` as dependency:

```
repositories {
    mavenCentral()
}

dependencies {
    compile 'pl.allegro.finance:tradukisto:0.5.1'
}
```

and use it:

```java
ValueConverter converter = ValueConverters.ENGLISH_INTEGER;
String valueAsWords = converter.asWords(1_234);

assertEquals("one thousand two hundred thirty-four", valueAsWords);
```

```java
MoneyConverter converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
String moneyAsWords = converter.asWords(new BigDecimal("1234.56"));

assertEquals("one thousand two hundred thirty-four £ 56/100", moneyAsWords);
```

Tradukisto can handle only values with no more than two digits after the decimal point. Otherwise
`IllegalArgumentException` will be thrown. For that reason you should either construct `BigDecimal` object based on `String`
value as shown in example above or use [setScale](http://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html#setScale(int,%20java.math.RoundingMode))
method to ensure that given value has appropriate precision.

License
-------

Copyright 2015 Allegro Group

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
