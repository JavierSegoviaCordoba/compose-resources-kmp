package com.javiersc.compose.resources.gradle.plugin.generators.drawables

import com.javiersc.compose.resources.gradle.plugin.utils.capitalized
import java.io.File

internal fun drawableGenerator(packageName: String, drawables: Map<String, List<File>>): String =
    """
        |package $packageName
        |
        |${imports()}
        |
        |sealed interface Drawables : ComposeResource {
        |
        |${drawables.abstractProperties()}
        |
        |    companion object {
        |        internal val type: String
        |            get() = "drawable"
        |    }
        |}
        |
        |${drawables.implementations()}
        |
    """
        .trimMargin()

private fun imports() =
    listOf(
            "import com.javiersc.compose.resources.Drawable",
        )
        .sorted()
        .joinToString("\n")

private fun Map<String, List<File>>.abstractProperties(): String =
    flatMap { (suffix: String, files: List<File>) ->
            files.map { file ->
                val name = file.nameWithoutExtension.replace("_$suffix", "")
                """
                    |val $name: Drawable
                """
                    .trimMargin()
            }
        }
        .distinct()
        .joinToString("\n", transform = String::withMargin)
        .drop(1)

private fun Map<String, List<File>>.implementations(): String {
    val implementationsPerType =
        map { (suffix: String, files: List<File>) ->
                """
                    |
                    |internal object ${suffix.capitalized()}Drawables : Drawables {
                    |
                    |${implementationProperties(suffix, keys, files, values.flatten())}
                    |}
                    |
                """
                    .trimMargin()
            }
            .joinToString("\n")
            .drop(1)

    val companionObject =
        """
            |
            |val ComposeResource.Companion.drawables: AllDrawables get() = AllDrawables()
            |
        """
            .trimMargin()

    val allDrawables =
        keys.map { suffix ->
            """
                |val $suffix: Drawables = ${suffix.capitalized()}Drawables
                |
            """
                .trimMargin()
                .lines()
                .joinToString("\n", transform = String::withMargin)
        }

    val allDrawablesClass =
        """
            |class AllDrawables {
            |
            |${allDrawables.joinToString("").dropLast(1)}
            |}
            |
        """
            .trimMargin()

    return (implementationsPerType.lines() + companionObject + allDrawablesClass.lines())
        .joinToString("\n")
        .dropLast(1)
}

@OptIn(ExperimentalStdlibApi::class)
private fun implementationProperties(
    mainSuffix: String,
    suffixes: Set<String>,
    mainFiles: List<File>,
    allFiles: List<File>
): String {
    fun File.nameWithoutSuffix(suffix: String) = nameWithoutExtension.replace("_$suffix", "")

    val allProperties =
        buildList {
                for (file in allFiles) {
                    var property: String = file.nameWithoutExtension
                    for (suffix in suffixes) {
                        property = property.replace("_$suffix", "")
                    }
                    add(property)
                }
            }
            .distinct()

    return allProperties.joinToString("\n") { property ->
        val file =
            mainFiles.firstOrNull { file -> file.nameWithoutSuffix(mainSuffix) == property }
                ?: allFiles.firstOrNull { file -> file.nameWithoutExtension == property }

        checkNotNull(file) { "There is a missing drawable for the property $property" }

        """
            |override val $property = Drawable("${file.nameWithoutExtension}", "${file.extension}", Drawables.type)
        """
            .trimMargin()
            .withMargin()
    }
}

private fun String.withMargin(): String = "|    $this"
