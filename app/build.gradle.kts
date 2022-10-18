plugins {
    id(Plugins.AGP.APPLICATION)
    id(Plugins.HILT)
    kotlin(Plugins.Kotlin.ANDROID)
    kotlin(Plugins.Kotlin.KAPT)
}
android {
    namespace = "meh.daniel.com.sundriesstoreapp"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "meh.daniel.com.sundriesstoreapp"
        minSdk =  Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.Options.compileOptions
        targetCompatibility = Config.Options.compileOptions
    }
    kotlinOptions {
        jvmTarget = Config.Options.kotlinOptions
    }
    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas",)
            arg("room.incremental", "true")
            arg("room.expandProjection", "true")
        }
    }
    buildFeatures.viewBinding = true
}

dependencies {
    implementation(Deps.Network.RETROFIT2)
    implementation(Deps.Network.RETROFIT2_GSON)
    implementation(Deps.Network.LOGGING_INERCEPTOR)
    implementation(Deps.Hilt.ANDROID)
    implementation(Deps.INJECT)
    implementation(Deps.Room.KTX)
    implementation(Deps.Room.RUNTIME)
    kapt(Deps.Room.COMPILER)
    kapt(Deps.Hilt.COMPILER)
    implementation(Deps.Lifecycle.VIEW_MODEL)
    implementation(Deps.Lifecycle.LIVE_DATA)
    implementation(Deps.Lifecycle.RUNTIME)
    implementation(Deps.Navigation.FRAGMENT)
    implementation(Deps.Navigation.UI)
    implementation(Deps.Coroutines.CORE)
    implementation(Deps.Coroutines.ANDROID)
    implementation(Deps.UI.CONSTRAINT_LAYOUT)
    implementation(Deps.UI.COORDINATOR_LAYOUT)
    implementation(Deps.UI.RECYCLER_VIEW)
    implementation(Deps.UI.PROGRESS_BAR)
    implementation(Deps.UI.FRAGMENT_KTX)
    implementation(Deps.UI.ACTIVITY_KTX)
    implementation(Deps.ImageLoad.GLIDE)
    implementation(Deps.ImageLoad.GLIDE_COMPILER)
    implementation(Deps.Android.CORE_KTX)
    implementation(Deps.Android.APPCOMPAT)
    implementation(Deps.Android.MATERIAL)
    testImplementation(Deps.Test.JUNIT)
    androidTestImplementation(Deps.Test.ANDROID_JUNIT)
    androidTestImplementation(Deps.Test.ESPRESSO)
    androidTestImplementation(Deps.Test.MOCKITO_CORE)
    androidTestImplementation(Deps.Test.MOCKITO_KOTLIN)
}