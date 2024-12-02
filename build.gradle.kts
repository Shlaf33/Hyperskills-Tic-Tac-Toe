plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17) // utilisez la version de JDK souhaitée
    }
}

kotlin {
    jvmToolchain(17) // même version que celle configurée pour Java
}

tasks.test {
    useJUnitPlatform()
}