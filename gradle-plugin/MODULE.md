# Module gradle-plugin

Resource generator for Compose Multiplatform

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
