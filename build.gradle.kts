plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-code-formatter`
    `javiersc-docs`
    `binary-compatibility-validator`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
