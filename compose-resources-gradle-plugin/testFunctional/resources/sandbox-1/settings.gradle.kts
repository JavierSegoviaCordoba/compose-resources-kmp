rootProject.name = "sandbox-project"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven(url = file(System.getProperty("user.home")).resolve("mavenLocalTest/repository").toURI())
    }
}

include(":app")
