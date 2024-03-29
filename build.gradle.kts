// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.kotlinSerialization) apply false
//    alias(libs.plugins.hilt) apply false
//    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.room) apply false
}

//buildscript {
//    dependencies {
//        classpath(kotlin("gradle-plugin", version = "1.9.22"))
//    }
//}