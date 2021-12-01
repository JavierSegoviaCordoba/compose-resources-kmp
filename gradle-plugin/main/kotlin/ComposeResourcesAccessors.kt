@file:Suppress("FunctionName", "TopLevelPropertyNaming", "ObjectPropertyName")

package com.javiersc.compose.resources

import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

public val PluginDependenciesSpec.`compose-resources`: PluginDependencySpec
    get() = id("com.javiersc.compose.resources")

public fun PluginDependenciesSpec.`compose-resources`(version: String): PluginDependencySpec =
    id("com.javiersc.compose.resources").version(version)
