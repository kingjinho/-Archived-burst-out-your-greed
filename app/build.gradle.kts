plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'androidx.navigation.safeargs.kotlin'
    id 'dagger.hilt.android.plugin'
}

android {
    compileSdk 33

    defaultConfig {
        applicationId "com.projectseoul.stockmarkettest"
        minSdk 26
        targetSdk 33
        versionCode 1
        versionName "1.0"
        buildConfigField "String", "KRX_URL", '"http://data.krx.co.kr/"'
        buildConfigField "String", "UPBIT_URL", '"https://api.upbit.com/v1/"'
        buildConfigField "String", "OPEC_URL", '"https://www.opec.org/"'
        buildConfigField "String", "GOLD_SILVER_URL", '"https://data.nasdaq.com/"'
        buildConfigField "String", "CURRENCY_URL", '"https://www.koreaexim.go.kr/site/program/financial/"'
        buildConfigField "String", "CURRENCY_KEY", '"Quev2QgRtLQD8XQJ6bFg4Em256ujwkGM"'
        buildConfigField "String", "BASE_INTEREST_RATE", '"http://ecos.bok.or.kr/api/"'
        buildConfigField "String", "BASE_INTEREST_RATE_KEY", '"DGYNOUL6KY051SK6B7XS"'
        buildConfigField "String", "COMMODITY_URL", '"http://www.krei.re.kr:18181/"'
        buildConfigField "String", "IMPORT_EXPORT_URL", '"https://unipass.customs.go.kr/"'
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }

    buildFeatures{
        viewBinding true
        dataBinding true
    }
    namespace 'com.projectseoul.stockmarkettest'
}

dependencies {

    implementation 'androidx.core:core-ktx:1.10.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.6.0'
    implementation 'androidx.navigation:navigation-ui-ktx:2.6.0'

    implementation 'androidx.room:room-ktx:2.5.2'
    kapt "androidx.room:room-compiler:2.5.2"
    implementation "androidx.room:room-runtime:2.5.2"
    testImplementation "androidx.room:room-testing:2.5.2"

    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    testImplementation "com.google.truth:truth:1.1.3"

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'
    implementation 'com.squareup.moshi:moshi-kotlin:1.13.0'
    implementation "com.squareup.moshi:moshi:1.13.0"
    implementation 'com.squareup.moshi:moshi-adapters:1.13.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2'
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'

    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'

    implementation "org.jsoup:jsoup:1.14.3"

    implementation "com.google.dagger:hilt-android:2.44"
    kapt "com.google.dagger:hilt-compiler:2.44"

}
