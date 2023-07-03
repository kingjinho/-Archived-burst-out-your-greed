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
        buildConfigField("String", "KRX_URL", "\"http://data.krx.co.kr/\"")
        buildConfigField("String", "UPBIT_URL", "\"https://api.upbit.com/v1/\"")
        buildConfigField("String", "OPEC_URL", "\"https://www.opec.org/\"")
        buildConfigField("String", "GOLD_SILVER_URL", "\"https://data.nasdaq.com/\"")
        buildConfigField("String", "CURRENCY_URL", "\"https://www.koreaexim.go.kr/site/program/financial/\"")
        buildConfigField("String", "CURRENCY_KEY", "\"Quev2QgRtLQD8XQJ6bFg4Em256ujwkGM\"")
        buildConfigField("String", "BASE_INTEREST_RATE", "\"http://ecos.bok.or.kr/api/\"")
        buildConfigField("String", "BASE_INTEREST_RATE_KEY", "\"DGYNOUL6KY051SK6B7XS\"")
        buildConfigField("String", "COMMODITY_URL", "\"http://www.krei.re.kr:18181/\"")
        buildConfigField("String", "IMPORT_EXPORT_URL", "\"https://unipass.customs.go.kr/\"")
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

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
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
