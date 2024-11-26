plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp) // Keep KSP plugin for Kotlin Symbol Processin
    id("kotlin-parcelize") // Plugin for Kotlin Parcelize")
}

android {
    namespace = "com.example.goaltrack"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.goaltrack"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Plugin para kotlin-parcelize
    implementation("org.jetbrains.kotlin:kotlin-parcelize-runtime:1.9.0") // Asegúrate de usar una versión de Kotlin compatible con tu proyecto.

    // Otras dependencias que ya tienes
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    val room_version = "2.6.1" // Use the latest stable Room version

    // Room dependencies
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version") // Use KSP instead of kapt

    // Retrofit and OkHttp for API calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // For JSON responses
    implementation("com.squareup.okhttp3:okhttp:4.9.3")  // Optional: for OkHttp customizations

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.15.1") // Glide image loading library
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1") // If using annotation processing with Glide

    // AndroidX dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

