# Changelog

## [Unreleased]

### Added

- support to generate code when IntelliJ syncs

### Changed

### Deprecated

### Removed

### Fixed

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-beta.1`
- `gradle -> 8.2`

## [0.1.0-alpha.17] - 2023-01-27

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.4.0-alpha.7`

## [0.1.0-alpha.16] - 2022-11-27

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.46`
- `gradle -> 7.6`
- `com.android.tools.build:gradle -> 7.3.0`
- `org.jetbrains.compose:compose-gradle-plugin -> 1.2.0-beta01`

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

[Unreleased]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.17...HEAD

[0.1.0-alpha.17]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.16...0.1.0-alpha.17

[0.1.0-alpha.16]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.15...0.1.0-alpha.16

[0.1.0-alpha.15]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.14...0.1.0-alpha.15

[0.1.0-alpha.14]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.13...0.1.0-alpha.14

[0.1.0-alpha.13]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.12...0.1.0-alpha.13

[0.1.0-alpha.12]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.11...0.1.0-alpha.12

[0.1.0-alpha.11]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.10...0.1.0-alpha.11

[0.1.0-alpha.10]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.9...0.1.0-alpha.10

[0.1.0-alpha.9]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.8...0.1.0-alpha.9

[0.1.0-alpha.8]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.7...0.1.0-alpha.8

[0.1.0-alpha.7]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.6...0.1.0-alpha.7

[0.1.0-alpha.6]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.5...0.1.0-alpha.6

[0.1.0-alpha.5]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.4...0.1.0-alpha.5

[0.1.0-alpha.4]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.3...0.1.0-alpha.4

[0.1.0-alpha.3]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.2...0.1.0-alpha.3

[0.1.0-alpha.2]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/compare/0.1.0-alpha.1...0.1.0-alpha.2

[0.1.0-alpha.1]: https://github.com/JavierSegoviaCordoba/compose-resources-kmp/commits/0.1.0-alpha.1
