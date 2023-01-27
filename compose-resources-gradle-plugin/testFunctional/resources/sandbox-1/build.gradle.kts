buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = file(System.getProperty("user.home")).resolve("mavenLocalTest/repository").toURI())
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = file(System.getProperty("user.home")).resolve("mavenLocalTest/repository").toURI())
    }
}
