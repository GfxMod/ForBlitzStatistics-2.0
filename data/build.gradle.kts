plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    kotlin("plugin.serialization") version "2.0.20"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.koin.core)

    implementation(libs.ktor.client.cio)
    implementation(libs.kotlinx.serialization.json)
}