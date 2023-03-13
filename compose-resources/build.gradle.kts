hubdle {
    config {
        analysis()
        documentation {
            api()
        }
        explicitApi()
        publishing {
            repositories {
                mavenLocalTest()
            }
        }
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
