plugins {
    `javiersc-kotlin-multiplatform`
    compose
    `javiersc-publish-kotlin-multiplatform`
}

kotlin {
    android { publishAllLibraryVariants() }

    jvm()

    sourceSets { commonMain { dependencies { implementation(compose.ui) } } }
}
