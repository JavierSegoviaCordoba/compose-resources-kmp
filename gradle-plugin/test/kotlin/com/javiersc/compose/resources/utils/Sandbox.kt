package com.javiersc.compose.resources.utils

import java.io.File
import java.nio.file.Paths
import kotlin.io.path.createTempDirectory

internal infix fun String.copyResourceTo(destination: File) {
    File(Thread.currentThread().contextClassLoader?.getResource(this)?.toURI()!!)
        .copyRecursively(destination)
}

internal fun createSandboxFile(): File {
    val path = Paths.get("build/sandbox").apply { toFile().mkdirs() }
    return createTempDirectory(directory = path).toFile()
}
