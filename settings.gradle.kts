rootProject.name = "supermarket-delivery"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention")
}

include(
    "supermarket-delivery-product"
)