hubdle {
    config {
        analysis()
        coverage()
        documentation { //
            api()
        }
        explicitApi()
        publishing {
            maven {//
                repositories { //
                    mavenLocalTest()
                }
            }
        }
    }

    kotlin {
        multiplatform {
            features { //
                compose()
            }

            common {
                main {//
                    dependencies { //
                        implementation(compose.ui)
                    }
                }
            }

            android()
            jvm()
        }
    }
}
