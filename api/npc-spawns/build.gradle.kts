plugins {
    id("base-conventions")
}

kotlin {
    explicitApi()
}

dependencies {
    implementation(libs.bundles.logging)
    implementation(libs.guice)
    implementation(libs.kotlin.coroutines.core)
    implementation(projects.api.cache)
    implementation(projects.api.gameProcess)
    implementation(projects.api.npc)
    implementation(projects.api.parsers.toml)
    implementation(projects.api.repo)
    implementation(projects.api.script)
    implementation(projects.api.type.typeSymbols)
    implementation(projects.engine.events)
    implementation(projects.engine.game)
    implementation(projects.engine.map)
    implementation(projects.engine.routefinder)
    implementation(projects.engine.scheduler)
    implementation(projects.engine.plugin)
}
