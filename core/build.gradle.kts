plugins {
    `kotlin-multiplatform`
    `android-library`
    compose
    `javiersc-kotlin-config`
    `javiersc-publish`
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
