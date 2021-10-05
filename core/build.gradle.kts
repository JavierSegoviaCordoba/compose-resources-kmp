plugins {
    `javiersc-kotlin-multiplatform`
    compose
    `javiersc-publish-kotlin-multiplatform`
}

kotlin {
    explicitApi()

    android { publishAllLibraryVariants() }

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.ui)
            }
        }

        named("androidMain")

        named("jvmMain")
    }
}
