package com.javiersc.compose.resources

import com.javiersc.gradle.testkit.test.extensions.GradleTest
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import java.io.File
import kotlin.test.Test
import org.gradle.testkit.runner.TaskOutcome

internal class ComposeResourcesPluginTest : GradleTest() {

    private val generateTask = "app:generateComposeResources"

    @Test
    fun simple_success() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            gradlew(generateTask)
                .task(":$generateTask")
                .shouldNotBeNull()
                .outcome
                .shouldBe(TaskOutcome.SUCCESS)
        }
    }

    @Test
    fun configuration_cache_success() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(generateTask)
            testConfigurationCache()
        }
    }

    @Test
    fun build_cache_from_cache() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(generateTask)
            testBuildCache()
        }
    }

    @Test
    fun add_file_invalidate_build_cache_success() {
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(generateTask)
            testBuildCache {
                val favoriteFile =
                    File("$projectDir/app/src/commonMain/resources/drawable/favorite.xml")
                favoriteFile.copyTo(File("${favoriteFile.parentFile}/favorite_copy.xml"))
            }
        }
    }
}
