package com.javiersc.compose.resources

import com.javiersc.compose.resources.utils.copyResourceTo
import com.javiersc.compose.resources.utils.createSandboxFile
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import java.io.File
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Before
import org.junit.Test

internal class ComposeResourcesPluginTest {

    private val testProjectDir: File = createSandboxFile()

    @Before
    fun setup() {
        "sandbox-1" copyResourceTo testProjectDir
    }

    @Test
    fun composeTest() {
        val result =
            GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments(":app:generateComposeResources")
                .withPluginClasspath()
                .build()

        println("____")
        println(result.output)
        println("____")
        result.task(":app:generateComposeResources").shouldNotBeNull().outcome shouldBe
            TaskOutcome.SUCCESS
    }
}
