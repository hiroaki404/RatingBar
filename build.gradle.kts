plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.ktlintPlugin).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
}

subprojects {
    apply(plugin = rootProject.libs.plugins.ktlintPlugin.get().pluginId)

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        android.set(true)
    }
}
