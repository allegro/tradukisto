import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("java")
    id("groovy")
    id("jacoco")
    id("maven-publish")
    id("signing")
    id("pl.allegro.tech.build.axion-release") version "1.15.4"
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
}

dependencies {
    testImplementation("org.spockframework:spock-core:2.3-groovy-4.0")
}

project.version = scmVersion.version
project.group = "pl.allegro.finance"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
    withJavadocJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
}


tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        csv.required.set(true)
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events = setOf(PASSED, SKIPPED, FAILED)
    }
}

publishing {
    publications {
        create<MavenPublication>("sonatype") {
            from(components["java"])
            pom {
                name.set("Tradukisto")
                description.set("Small java library created to convert numbers to their word representations")
                url.set("https://github.com/allegro/tradukisto")
                inceptionYear.set("2015")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("dorians")
                        name.set("Dorian Sarnowski")
                    }
                    developer {
                        id.set("wjur")
                        name.set("Wojciech Jurczyk")
                    }
                    developer {
                        id.set("MaciejLipinski")
                        name.set("Maciej Lipiński")
                    }
                    developer {
                        id.set("jglaszka")
                        name.set("Julia Glaszka")
                    }
                    developer {
                        id.set("bgalek")
                        name.set("Bartosz Gałek")
                    }
                    developer {
                        id.set("pawelkowalski92")
                        name.set("Paweł Kowalski")
                    }
                    developer {
                        id.set("bartlomiejgraczyk")
                        name.set("Bartłomiej Graczyk")
                    }
                }
                scm {
                    url.set("https://github.com/allegro/tradukisto")
                    connection.set("scm:git@github.com:allegro/tradukisto.git")
                    developerConnection.set("scm:git@github.com:allegro/tradukisto.git")
                }
            }
        }
    }
}

nexusPublishing {
    this.repositories {
        sonatype {
            username.set(System.getenv("SONATYPE_USERNAME"))
            password.set(System.getenv("SONATYPE_PASSWORD"))
        }
    }
}

if (System.getenv("GPG_KEY_ID") != null) {
    signing {
        useInMemoryPgpKeys(
            System.getenv("GPG_KEY_ID"),
            System.getenv("GPG_PRIVATE_KEY"),
            System.getenv("GPG_PRIVATE_KEY_PASSWORD")
        )
        sign(publishing.publications)
    }
}
