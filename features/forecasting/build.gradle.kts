plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.aliahmed.forecasting"
    compileSdk = 35
    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.compilerVersion
    }
}

dependencies {

    // Compose
    val composeBom = platform(Compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.activityCompose)
    implementation(Compose.lifecycleViewModelCompose)
    implementation(Compose.navigationCompose)
    implementation(Compose.hiltNavigationCompose)

    implementation(Compose.uiToolingPreview)
    debugImplementation(Compose.uiTooling)

    androidTestImplementation(Compose.uiTestJunit)
    debugImplementation(Compose.uiTestManifest)

    // Module
    implementation(project(Module.CoreUi))
    implementation(project(Module.data))

    //coil
    implementation(Coil.coilCompose)

    // Hilt
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    //Test
    implementation(JUnit.junit4)
    implementation(JUnit.ext)
    testImplementation("io.mockk:mockk:1.12.5")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

}