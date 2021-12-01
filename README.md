![Kotlin version](https://img.shields.io/badge/kotlin-1.5.31-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.compose-resources/gradle-plugin?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/compose-resources/gradle-plugin/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.compose-resources/gradle-plugin?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/compose-resources/gradle-plugin/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/compose-resources-kmp/build-kotlin?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/compose-resources-kmp/tree/main)
[![Quality](https://img.shields.io/sonar/quality_gate/JavierSegoviaCordoba_compose-resources-kmp?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_compose-resources-kmp)
[![Tech debt](https://img.shields.io/sonar/tech_debt/JavierSegoviaCordoba_compose-resources-kmp?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_compose-resources-kmp)

# Compose Resources Gradle plugin

### Download from MavenCentral

```kotlin
implementation("com.javiersc.compose-resources:gradle-plugin:$version")
```

## Usage

```kotlin
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.javiersc.compose.resources")
}

kotlin {
    //...
}

android {
    // ...
}

composeResources {
    suffixes = listOf("blue", "dark")
    packageName = "com.javiersc.some.custom.package" // required
}
```
