plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.21" // Match Kotlin version

}

android {
    namespace = "com.myowin.eastypeasy"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.myowin.eastypeasy"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures { viewBinding = true }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.kotlinx.serialization.json)

    // Hilt core
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Hilt ViewModel
    implementation(libs.androidx.hilt.navigation.fragment)
    kapt(libs.androidx.hilt.compiler)

    //viewbinding
    implementation(libs.android.viewbinding)

    //ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)  // Add this line
    implementation(libs.ktor.client.logging)

    // Kotlinx Serialization
    implementation(libs.kotlinx.serialization.json)

    //datastore
    implementation(libs.datastore.preferences)
    implementation(libs.datastore.core)

    //timber
    implementation(libs.timber)

    //custom crash
    implementation(libs.customactivityoncrash)

    //Material Component
    implementation(libs.material.v160)

    //Glide
    implementation(libs.glide)

    //Circle Image View
    implementation(libs.circleimageview)



}