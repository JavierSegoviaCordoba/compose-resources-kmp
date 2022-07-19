# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.29`

## [0.1.0-alpha.15] - 2022-07-18

### Fixed

- incorrect imports in codegen

## [0.1.0-alpha.14] - 2022-07-17

### Changed

- `core` artifact to `com.javiersc.compose:compose-resources`
- `gradle-plugin` artifact to `com.javiersc.compose:compose-resources-gradle-plugin`
- all file packages

### Updated

- `gradle -> 7.5`
- `com.android.tools.build:gradle -> 7.2.1`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.7.10`
- `org.jetbrains.compose:compose-gradle-plugin -> 1.2.0-alpha01-dev745`

## [0.1.0-alpha.13] - 2021-12-25

### Updated

- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.28`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.6.10`
- `org.jetbrains.compose:compose-gradle-plugin -> 1.0.1`
- `gradle -> 7.3.3`
- `io.kotest:kotest-assertions-core -> 5.0.3`
- `com.android.tools.build:gradle -> 7.0.4`

## [0.1.0-alpha.12] - 2021-12-01

### Updated

- `org.jetbrains.compose:compose-gradle-plugin -> 1.0.0`
- `gradle -> 7.3.1`

## [0.1.0-alpha.11] - 2021-12-01

- No changes

## [0.1.0-alpha.10] - 2021-12-01

- No changes

## [0.1.0-alpha.9] - 2021-12-01

- No changes

## [0.1.0-alpha.8] - 2021-12-01

### Removed

- `compose-resources` plugin accessor

### Updated

- `org.jetbrains.compose:compose-gradle-plugin -> 1.0.0-rc12`
- `io.kotest:kotest-assertions-core -> 5.0.1`
- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.21`
- `gradle -> 7.3`
- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.8.0`

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
