plugins {
    id("com.santimattius.android.feature")
    id("com.santimattius.android.library.compose")
}

android {
    namespace = "com.santimattius.android.custom.second.feature"

}

dependencies{
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(project(mapOf("path" to ":core:ui")))
}