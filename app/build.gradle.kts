plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.google.dagger.hilt)
}

android {
    namespace = "com.example.rtspstreamer"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rtspstreamer"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
  buildFeatures{
        viewBinding = true
  }
}
kapt {
    correctErrorTypes = true
}
dependencies {
    implementation(libs.androidx.media3.ui)
    implementation(libs.androidx.media3.exoplayer)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.hilt.android.gradle.plugin)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
    implementation( libs.androidx.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.media3.exoplayer.v120)
    implementation (libs.androidx.media3.exoplayer.rtsp)
    implementation (libs.androidx.media3.ui.v120)
    implementation (libs.exoplayer)
}