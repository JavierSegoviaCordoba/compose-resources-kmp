![Kotlin version](https://img.shields.io/badge/kotlin-1.7.20-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.compose/compose-resources?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/compose/compose-resources/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.compose/compose-resources?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/compose/compose-resources/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/compose-resources-kmp/build-kotlin?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/compose-resources-kmp/tree/main)
[![Coverage](https://img.shields.io/sonar/coverage/com.javiersc.compose:compose-resources-kmp?label=Coverage&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.compose:compose-resources-kmp)
[![Quality](https://img.shields.io/sonar/quality_gate/com.javiersc.compose:compose-resources-kmp?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.compose:compose-resources-kmp)
[![Tech debt](https://img.shields.io/sonar/tech_debt/com.javiersc.compose:compose-resources-kmp?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.compose:compose-resources-kmp)

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
