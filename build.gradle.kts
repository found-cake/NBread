plugins {
    kotlin("jvm") version "1.8.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.github.found_cake"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.12")
    implementation("ch.qos.logback:logback-classic:1.4.8")
}

tasks{
    shadowJar{
        archiveFileName.set("NBread.jar")
        manifest{
            attributes(mapOf("Main-Class" to "io.github.found_cake.nbread.MainKt"))
        }
    }
}