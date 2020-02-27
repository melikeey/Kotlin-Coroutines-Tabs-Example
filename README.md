# Kotlin-Coroutines-Tabs-Example
This is tabs and coroutines example with Kotlin.

It downloads images and handles errors with coroutines 

## Libraries 

    AppCompat
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation "com.google.android.material:material:1.0.0"

    Kotlin
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0'
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation "androidx.core:core-ktx:+"



Do not forget to add ```androidExtension``` to build gradle to use Parcelize

```
androidExtensions {
    experimental = true // @Parcelize
}
```
## Screenshot


<div align="center">
    <img src="https://github.com/melikeey/Kotlin-Caroutines-Tabs-Example/blob/master/ss.png" width="250px"</img> 
</div>
