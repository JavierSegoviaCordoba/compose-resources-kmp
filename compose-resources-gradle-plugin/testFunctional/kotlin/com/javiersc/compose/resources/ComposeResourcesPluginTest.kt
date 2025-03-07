package com.javiersc.compose.resources

import com.javiersc.gradle.testkit.test.extensions.GradleTestKitTest
import com.javiersc.kotlin.test.assertEquals
import com.javiersc.kotlin.test.assertNotNull
import java.io.File
import java.nio.file.Paths
import kotlin.test.Ignore
import kotlin.test.Test
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.AfterAll

internal class ComposeResourcesPluginTest : GradleTestKitTest() {

    private val generateTask = "app:generateComposeResources"

    private val composeResourcesVersion =
        Paths.get(".")
            .toAbsolutePath()
            .normalize()
            .toFile()
            .resolve("build/semver/version.txt")
            .readLines()
            .first()

    private val composeResourcesVersionProperty =
        "-PcomposeResourcesVersion=$composeResourcesVersion"

    @Test
    fun simple_success() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            gradlew(generateTask, composeResourcesVersionProperty)
                .task(":$generateTask")
                .assertNotNull()
                .outcome
                .assertEquals(TaskOutcome.SUCCESS)
            gradlew("assemble", composeResourcesVersionProperty)
        }
    }

    // TODO: Enable it after
    // https://youtrack.jetbrains.com/issue/KT-55051/MetadataDependencyTransformationTask-is-not-compatible-with-Gradle-configuration-cache
    @Test
    @Ignore
    fun configuration_cache_success() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(generateTask, composeResourcesVersionProperty)
            testConfigurationCache()
            gradlew("assemble", composeResourcesVersionProperty)
        }
    }

    @Test
    fun build_cache_from_cache() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(generateTask, composeResourcesVersionProperty)
            testBuildCache()
            gradlew("assemble", composeResourcesVersionProperty)
        }
    }

    @Test
    fun add_file_invalidate_build_cache_success() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(generateTask, composeResourcesVersionProperty)
            testBuildCache {
                val favoriteFile =
                    File("$projectDir/app/src/commonMain/resources/drawable/favorite.xml")
                favoriteFile.copyTo(File("${favoriteFile.parentFile}/favorite_copy.xml"))
            }
            gradlew("assemble", composeResourcesVersionProperty)
        }
    }

    companion object {
        private val mavenLocalPath =
            File(System.getProperty("user.home")).resolve("mavenLocalTest/repository/")

        @JvmStatic
        @AfterAll
        fun `clean m2_com_kotlin after test`() {
            mavenLocalPath.deleteRecursively()
        }
    }
}
