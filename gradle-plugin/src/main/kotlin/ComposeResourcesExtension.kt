package com.javiersc.compose.resources

import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType

public interface ComposeResourcesExtension {
    public var suffixes: List<String>
    public var packageName: String?
}

internal fun Project.createComposeResourcesExtension(): ComposeResourcesExtension =
    extensions.create("composeResources")

internal val Project.composeResourcesExtension: ComposeResourcesExtension
    get() = extensions.getByType()
