object Versions {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val androidGradlePlugin = "4.1.0-rc02"
    const val glide = "4.11.0"
    const val insetter = "0.3.1"
    const val kotlin = "1.4.10"
    const val coroutines = "1.3.9"
    const val coreKtx = "1.5.0-alpha02"
    const val activityKtx = "1.2.0-alpha08"
    const val fragmentKtx = "1.3.0-alpha08"
    const val appCompat = "1.3.0-alpha02"
    const val constraintLayout = "2.0.1"
    const val lifecycleKtx = "2.2.0"
    const val paging = "3.0.0-alpha06"
    const val navigation = "2.3.0"
    const val hiltX = "1.0.0-alpha02"
    const val dataStore = "1.0.0-alpha01"
    const val testCore = "1.3.0"
    const val jUnit = "1.1.2"
    const val runner = "1.3.0"
    const val testFragment = "1.2.5"
    const val testNavigation = "2.3.0"
    const val services = "4.3.3"
    const val material = "1.2.1"
    const val hiltG = "2.29.1-alpha"
    const val okhttp = "4.8.1"
    const val retrofit = "2.9.0"
    const val moshiConverter = "2.5.0"
    const val moshi = "1.9.3"
    const val networkFlow = "1.0.2"
    const val analyticsFB = "17.5.0"
    const val perfFB = "19.0.8"
    const val perfFBPlugin = "1.3.1"
    const val crashlyticsFB = "17.2.1"
    const val crashlyticsFBPlugin = "2.2.1"
    const val timber = "4.7.1"
    const val leakcanary = "2.4"
    const val chucker = "3.2.0"
}

object Deps {

    //region Gradle
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val services = "com.google.gms:google-services:${Versions.services}"
    //endregion

    //region Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glidecodegen = "com.github.bumptech.glide:compiler:${Versions.glide}"
    //endregion

    //region Core
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    //endregion

    //region Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    //endregion

    //region AndroidX
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val activity_ktx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val viewModel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtx}"
    const val liveData_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtx}"
    const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
    const val lifecycle_ext = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleKtx}"
    const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    const val datastore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    //endregion

    //region Navigation
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val safeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    //endregion

    //region Hilt
    const val hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.hiltX}"
    const val hilt_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltX}"
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hiltG}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltG}"
    const val hilt_android_gradle_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltG}"
    //endregion

    //region Test
    const val test_runner = "androidx.test:runner:${Versions.runner}"
    const val instrumentation_runner = "androidx.test.runner.AndroidJUnitRunner"
    const val test_core_ktx = "androidx.test:core-ktx:${Versions.testCore}"
    const val junit_ktx = "androidx.test.ext:junit-ktx:${Versions.jUnit}"
    const val fragment_test = "androidx.fragment:fragment-testing:${Versions.testFragment}"
    const val navigation_test = "androidx.navigation:navigation-testing:${Versions.testNavigation}"
    //endregion

    //region Design
    const val material = "com.google.android.material:material:${Versions.material}"
    const val insetter = "dev.chrisbanes:insetter-dbx:${Versions.insetter}"
    //endregion

    //region Network
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshicodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val network_flow = "ru.beryukhov:flowreactivenetwork:${Versions.networkFlow}"
    //endregion

    //region Firebase
    const val fb_analytics = "com.google.firebase:firebase-analytics:${Versions.analyticsFB}"
    const val fb_analytics_ktx = "com.google.firebase:firebase-analytics-ktx:${Versions.analyticsFB}"
    const val fb_perf = "com.google.firebase:firebase-perf:${Versions.perfFB}"
    const val fb_perf_plugin = "com.google.firebase:perf-plugin:${Versions.perfFBPlugin}"
    const val fb_crashlytics = "com.google.firebase:firebase-crashlytics-ktx:${Versions.crashlyticsFB}"
    const val fb_crashlytics_plugin = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlyticsFBPlugin}"
    //endregion

    //region Debug
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckernoop = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    //endregion
}
