# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Updated
- `gradle -> 7.3`
- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.8`
- `org.jetbrains.compose:compose-gradle-plugin -> 1.0.0-beta6-dev450`
- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.8.0`
- `com.javiersc.gradle-plugins:versioning -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:readme-badges -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:publish-kotlin-multiplatform -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:publish-kotlin-jvm -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:publish-gradle-plugin -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:plugin-accessors -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:nexus -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:kotlin-multiplatform -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:docs -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:code-formatter -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:code-analysis -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:changelog -> 0.1.0-alpha.71`
- `com.javiersc.gradle-plugins:all-projects -> 0.1.0-alpha.71`

## [0.1.0-alpha.7] - 2021-10-10
- No changes

## [0.1.0-alpha.6] - 2021-10-10
- No changes

## [0.1.0-alpha.5] - 2021-10-10
- No changes

## [0.1.0-alpha.4] - 2021-10-05

### Added
- `painterResource` which uses `Drawable` as param

### Changed
- drawables will be exposed as `Drawable` instead of `Painter`
- `ComposeResource.drawable` to `ComposeResource.drawables`

## [0.1.0-alpha.3] - 2021-09-21

### Added
- `compose-resources` plugin accessor
- `commonMain/resources` to `android` main source sets
- run `generateComposeResources` when `preBuild` task is executed or the IDE syncs

### Changed
- `AllDrawables` are not `Composable` 

### Fixed
- `painterResource` in `jvm` doesn't use the type as directory

## [0.1.0-alpha.2] - 2021-09-21

### Added
- `build\generated\source\composeResources\kotlin` as Kotlin source directory

## [0.1.0-alpha.1] - 2021-09-21
- No changes
