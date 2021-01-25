import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    kotlin("jvm") version "1.4.30-RC"
    `maven-publish`
    application
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    jcenter()
}

group = "com.lilithsthrone"
version = "1"
description = "lilithsthrone"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

application {
    mainClass.set("com.lilithsthrone.main.Main")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    // include for server side
    val kotlinxHtmlVersion = "0.7.1"
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:${kotlinxHtmlVersion}")

    // include for client-side
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:${kotlinxHtmlVersion}")

}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}