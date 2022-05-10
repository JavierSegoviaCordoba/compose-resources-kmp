package com.javiersc.compose.resources

import com.javiersc.compose.resources.utils.copyResourceTo
import com.javiersc.compose.resources.utils.createSandboxFile
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.gradle.testkit.runner.BuildResult
import java.io.File
import kotlin.test.BeforeTest
import kotlin.test.Test
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome

internal class ComposeResourcesPluginTest {

    private val testProjectDir: File = createSandboxFile()

    @BeforeTest
    fun setup() {
        "sandbox-1" copyResourceTo testProjectDir
    }

    @Test
    fun simple_success() {
        val result =
            GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments(":app:generateComposeResources")
                .withPluginClasspath()
                .build()

        println("-----------------------------------------------------------------")
        println(result.output)
        println("-----------------------------------------------------------------")

        result
            .task(":app:generateComposeResources")
            .shouldNotBeNull()
            .outcome
            .shouldBe(TaskOutcome.SUCCESS)
    }

    @Test
    fun configuration_cache_success() {
        val runner: GradleRunner =
            GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments(
                    ":app:generateComposeResources",
                    "--configuration-cache",
                    "--no-build-cache",
                )
                .withPluginClasspath()

        runner.build()
        val result = runner.build()

        println("-----------------------------------------------------------------")
        println(result.output)
        println("-----------------------------------------------------------------")

        result.output.shouldContain("Reusing configuration cache")
        result
            .task(":app:generateComposeResources")
            .shouldNotBeNull()
            .outcome
            .shouldBe(TaskOutcome.UP_TO_DATE)
    }

    @Test
    fun build_cache_from_cache() {
        val runner: GradleRunner =
            GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withPluginClasspath()

        runner.withArguments(":app:generateComposeResources", "--build-cache", "--info").build().also { printOutput(it) }

        runner.withArguments("clean", "--build-cache").build()

        val result = runner.withArguments(":app:generateComposeResources", "--build-cache", "--info").build().also { printOutput(it) }

        printOutput(result)

        result
            .task(":app:generateComposeResources")
            .shouldNotBeNull()
            .outcome
            .shouldBe(TaskOutcome.FROM_CACHE)
    }

    @Test
    fun add_file_invalidate_build_cache_success() {
        val runner: GradleRunner =
            GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments(":app:generateComposeResources", "--build-cache")
                .withPluginClasspath()

        runner.build()

        val favoriteFile =
            File("$testProjectDir/app/src/commonMain/resources/drawable/favorite.xml")

        favoriteFile.copyTo(File("${favoriteFile.parentFile}/favorite_copy.xml"))

        val result = runner.build()

        printOutput(result)

        result
            .task(":app:generateComposeResources")
            .shouldNotBeNull()
            .outcome
            .shouldBe(TaskOutcome.SUCCESS)
    }

    private fun printOutput(result: BuildResult) {
        println("-----------------------------------------------------------------")
        println(result.output)
        println("-----------------------------------------------------------------")
    }
}
