plugins {
    kotlin("jvm") version "1.3.50"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("org.jetbrains", "annotations", "18.0.0")

    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.5.2")

    // IDEA needs those:
    testCompileOnly("org.junit.jupiter", "junit-jupiter-api", "5.5.2")
    testCompileOnly("org.junit.jupiter", "junit-jupiter-params", "5.5.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    test {
        useJUnitPlatform()

        testLogging.showExceptions = true
    }
}
