Changelog
=========

## 0.1.0 (2015-04-02)

First release. Added support for:

  - Polish

## 0.2.0 (2015-06-19)

Added support for:

  - Czech
  
## 0.3.0 (2015-07-14)

Added support for:

  - English
  
## 0.4.0 (2015-07-22)

Added support for:

  - Russian

## 0.4.1 (2015-07-22)

Fixed currency symbol for Russian language

## 0.5.0 (2015-09-29)

Added support for:

  - German

## 0.5.1 (2015-09-30)

Fixed incorrect translation of "2" for Czech language

## 1.0.0 (2017-09-06)

Migrate to Java 8. Added support for:

  - Brazilian Portuguese

## 1.0.1 (2018-02-02)

Fixed incorrect translations for Russian language

## 1.1.0 (2018-03-26)

Added support for:

  - Latvian

## 1.2.0 (2018-03-31)

Added support for:

  - Slovak

## 1.3.0 (2018-05-14)

Added support for:

  - Kazakh

## 1.4.0 (2018-06-04)

Added support for:

  - Ukrainian

## 1.4.1 (2018-06-06)

Added missing Ukrainian banking money value.

## 1.5.0 (2018-09-18)

Added support for:

  - French

## 1.6.0 (2019-01-02)

Added support for:

  - Serbian (latin)
  
Fixed:

  - Incorrect translations for French language

## 1.7.0 (2019-02-04)

Added support for:

  - Italian

## 1.7.1 (2019-02-07)

Fixed:

  - Missing French banking money value

## 1.8.0 (2019-03-05)

Added support for:

  - Turkish

## 1.9.0 (2021-09-29)

Migrated builds to GitHub Actions. Added support for:

  - American English ($ instead of £ currency symbol)

## 1.9.1 (2021-10-01)

Fixed:

  - French translation bugs

## 1.10.0 (2021-10-02)

Added support for:

  - Serbian (cyrillic)
  
Fixed:

  - Incorrect translations for Serbian language (latin)

## 1.10.1 (2021-10-12)

Fixed:

  - Release workflow now publishes .jar files to Maven Central (.jar files missing for versions 1.9.0, 1.9.1, 1.10.0)

## 1.10.2 (2021-10-18)

Added methods for getting value converters based on locale or language tag

## 1.10.3 (2022-01-31)

Fixed:

  - missing number 88 in Italian values
  - added check for number remapping

## 1.10.4 (2022-03-14)

Fixed:

  - published jars now contain `com.google.guava` dependency (bug present since version 1.9.0)

## 1.10.5 (2022-03-18)

Added method for using money converters with a custom currency string

## 1.10.6 (2022-03-28)

Upgraded `com.google.guava:guava` dependency version from `23.0` to `25.0-jre`

## 1.11.0 (2022-07-22)

Added support for:

  - Bulgarian

## 1.12.0 (2022-07-25)

Added long converters for:

  - English
  - Polish

## 1.12.1 (2023-07-03)

Upgraded `com.google.guava:guava` dependency version from `25.0-jre` to `32.1.1-jre`
