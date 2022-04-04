import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val springVersion = "2.4.3"
    val jupiterVersion = "5.8.0-M1"

    implementation("org.jetbrains.kotlin", "kotlin-reflect", "1.4.30")

    implementation("org.mongodb", "mongodb-driver-reactivestreams", "4.2.2")

    implementation("org.springframework.boot", "spring-boot-starter-webflux", springVersion)
    implementation("org.springframework.boot", "spring-boot-starter-data-mongodb", springVersion)

    implementation("com.natpryce", "konfig", "1.6.10.0")

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter", "junit-jupiter-api", jupiterVersion)
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", jupiterVersion)

    testImplementation("org.springframework.boot", "spring-boot-starter-test", springVersion)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}