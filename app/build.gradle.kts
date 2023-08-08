import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

private val property = gradleLocalProperties(rootDir)

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.projectseoul.stockmarkettest"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "KRX_URL", getValueByKey("KRX_URL"))
        buildConfigField("String", "UPBIT_URL", getValueByKey("UPBIT_URL"))
        buildConfigField("String", "OPEC_URL", getValueByKey("OPEC_URL"))
        buildConfigField("String", "GOLD_SILVER_URL", getValueByKey("GOLD_SILVER_URL"))
        buildConfigField("String", "CURRENCY_URL", getValueByKey("CURRENCY_URL"))
        buildConfigField("String", "CURRENCY_KEY", getValueByKey("CURRENCY_KEY"))
        buildConfigField("String", "BASE_INTEREST_RATE", getValueByKey("BASE_INTEREST_RATE"))
        buildConfigField("String", "BASE_INTEREST_RATE_KEY", getValueByKey("BASE_INTEREST_RATE_KEY"))
        buildConfigField("String", "COMMODITY_URL", getValueByKey("COMMODITY_URL"))
        buildConfigField("String", "IMPORT_EXPORT_URL", getValueByKey("IMPORT_EXPORT_URL"))
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile ("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    namespace = "com.projectseoul.stockmarkettest"
}

dependencies {
    modules {
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk7 is now part of kotlin-stdlib")
        }
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk8 is now part of kotlin-stdlib")
        }
    }

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    implementation(libs.room.ktx)
    kapt (libs.room.compiler)
    implementation (libs.room.runtime)
    testImplementation (libs.room.testing)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.truth)

    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi.converter)

    implementation(libs.okhttp.logging)

    implementation(libs.moshi.kotlin)
    implementation (libs.moshi)
    implementation(libs.moshi.adapters)
    kapt(libs.moshi.codegen)

    implementation(libs.coroutines)

    implementation(libs.mp.android.chart)

    implementation(libs.jsoup)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}

fun getValueByKey(key: String): String {
    return property.getProperty(key)
}