package com.javiersc.compose.resources

import com.javiersc.gradle.testkit.extensions.gradleBuildCacheTestKitTest
import com.javiersc.gradle.testkit.extensions.gradleConfigurationCacheTestKitTest
import com.javiersc.gradle.testkit.extensions.gradleTestKitTest
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import java.io.File
import kotlin.test.Test
import org.gradle.testkit.runner.TaskOutcome

internal class ComposeResourcesPluginTest {

    @Test
    fun simple_success() {
        val task = ":app:generateComposeResources"
        gradleTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(task)
            val result = build()
            result.task(task).shouldNotBeNull().outcome.shouldBe(TaskOutcome.SUCCESS)
        }
    }

    @Test
    fun configuration_cache_success() {
        gradleConfigurationCacheTestKitTest(sandboxPath = "sandbox-1") {
            withArguments(":app:generateComposeResources")
        }
    }

    @Test
    fun build_cache_from_cache() {
        gradleBuildCacheTestKitTest(sandboxPath = "sandbox-1", isolated = true) {
            withArguments(":app:generateComposeResources")
        }
    }

    @Test
    fun add_file_invalidate_build_cache_success() {
        gradleBuildCacheTestKitTest(
            sandboxPath = "sandbox-1",
            isolated = true,
            invalidate = {
                val favoriteFile =
                    File("$projectDir/app/src/commonMain/resources/drawable/favorite.xml")
                favoriteFile.copyTo(File("${favoriteFile.parentFile}/favorite_copy.xml"))
            },
            preTest = { withArguments(":app:generateComposeResources") },
        )
    }
}
