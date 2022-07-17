plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        publishing()
    }

    kotlin {
        multiplatform {
            features {
                compose()
            }

            common {
                main {
                    dependencies {
                        implementation(compose.ui)
                    }
                }
            }

            android()
            jvm()
        }
    }
}
