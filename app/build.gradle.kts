plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.changzakso.viewmodelsample"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.changzakso.viewmodelsample"
        minSdk = 28
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //[2][3]ViewModel 위한 Dependency
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    //[4]ViewModel 초기화 위임을 위한 dependency
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.fragment:fragment-ktx:1.6.1")

    //[5] ViewModel이 종료되어도 값유지하기 위한 SavedState
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.1")

    //[6]livedata dependency 추가
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")


    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}