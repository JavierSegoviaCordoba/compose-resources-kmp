package com.javiersc.compose.resources.gradle.plugin.utils

// import org.gradle.api.Project
// import org.gradle.api.artifacts.Configuration
// import org.gradle.api.artifacts.ResolvedArtifact
// import org.gradle.api.provider.Provider
// import org.gradle.internal.component.local.model.DefaultProjectComponentSelector
// import org.gradle.kotlin.dsl.named

// TODO: Investigate how to merge resources
// internal fun Project.findAllProjects(): AllProjects =
//    AllProjects(mainProject = this, subProjects = commonMainSubProjects)

// TODO: Investigate how to merge resources
// internal val Project.commonMainSubProjects: List<Project>
//    get() =
//        rootProject.subprojects.filter { project ->
//            val allDependenciesNames = allDependenciesNames("jvmCompileClasspath")
//            allDependenciesNames.any { dependency -> dependency.startsWith(project.name) }
//        }

// TODO: Investigate how to merge resources
// internal val Project.compileClasspathSubProjects: List<Project>
//    get() =
//        rootProject.subprojects.filter { project ->
//            val artifacts =
//                configurations
//                    .named<Configuration>("compileClasspath")
//                    .get()
//                    .resolvedConfiguration
//                    .resolvedArtifacts
//                    .toList()
//            artifacts.map(ResolvedArtifact::getName).contains(project.name)
//        }

// TODO: Investigate how to merge resources
// internal val Project.incomingDependenciesSubProjects: List<Project>
//    get() =
//        rootProject.subprojects.filter { project ->
//            val dependencies =
//                project.configurations
//                    .flatMap { configuration -> configuration.incoming.dependencies.toList() }
//                    .map { dependency -> dependency.name }
//            dependencies.contains(project.name)
//        }

// TODO: Investigate how to merge resources
// internal fun Project.allDependenciesNames(vararg configurations: String): List<String> =
//    configurations.flatMap { configuration ->
//        this.configurations.named(configuration).allDependenciesNames
//    }

// TODO: Investigate how to merge resources
// internal val Provider<Configuration>.allDependenciesNames: List<String>
//    get() =
//        get().incoming.resolutionResult.allDependencies.mapNotNull {
//            (it.requested as? DefaultProjectComponentSelector)?.projectName
//        }
