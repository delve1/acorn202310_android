plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.0.0")
}