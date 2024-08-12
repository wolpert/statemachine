// gradle clean build test publishToSonatype closeAndReleaseSonatypeStagingRepository

plugins {
    `java-library`
    `maven-publish`
    jacoco
    signing
    //checkstyle
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
}

dependencies {
    implementation(libs.jackson.core)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.annotations)
    implementation(libs.jackson.datatype.jdk8)
    implementation(libs.commons.io)
    implementation(libs.metrics.core)
    implementation("javax.inject:javax.inject:1")
    implementation(libs.slf4j.api)

    implementation(libs.immutables.annotations)
    annotationProcessor(libs.immutables.value)

    implementation(libs.dagger)
    annotationProcessor(libs.dagger.compiler)


    // Use JUnit Jupiter Engine for testing.
    testImplementation(libs.codehead.test)

    testImplementation(libs.logback.classic)
    testImplementation(libs.logback.core)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    api(libs.bundles.testing)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
    withJavadocJar()
    withSourcesJar()
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
//tasks.named<Checkstyle>("checkstyleTest") {
//    enabled = false
//}

group = "com.codeheadsystems"
version = "1.0.1-SNAPSHOT"

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "statemachine"
            from(components["java"])
            pom {
                name = "statemachine"
                description = "statemachine utilities"
                url = "https://github.com/wolpert/statemachine"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "wolpert"
                        name = "Ned Wolpert"
                        email = "ned.wolpert@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/wolpert/database-test.git"
                    developerConnection = "scm:git:ssh://github.com/wolpert/database-test.git"
                    url = "https://github.com/wolpert/database-test/"
                }
            }

        }
    }
    repositories {
        maven {
            val releasesRepoUrl = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
            val snapshotsRepoUrl = "https://oss.sonatype.org/content/repositories/snapshots"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            name = "ossrh"
            credentials(PasswordCredentials::class)
        }
    }
}

// gradle publishToSonatype closeAndReleaseSonatypeStagingRepository
nexusPublishing {
    repositories {
        sonatype()
    }
}
signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}
tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
