plugins {
    kotlin("jvm") version "1.7.0"
}

group = "leetcode"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
