import kotlinx.kover.api.DefaultIntellijEngine

plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        analysis()
        binaryCompatibilityValidator()
        coverage {
            engine(DefaultIntellijEngine)
        }
        documentation {
            changelog()
            readme {
                badges()
            }
            site()
        }
        nexus()
    }
}
