plugins {
    id("kotlin")
}

dependencies {
    implementation(project(":shared"))
//    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
//    implementation("com.squareup.moshi:moshi:1.13.0")
//    implementation("com.squareup.moshi:moshi-adapters:1.13.0")

    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
}
