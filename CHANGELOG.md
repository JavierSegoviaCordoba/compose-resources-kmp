# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Updated


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
