plugins {
    `kotlin-jvm`
    `javiersc-publish-kotlin-jvm`
}

kotlin { explicitApi() }

dependencies {
    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(files(pluginLibs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(gradleApi())
}
