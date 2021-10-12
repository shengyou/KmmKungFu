package io.kraftsman.app.kmmkungfu

actual class Platform actual constructor() {
    actual val platform: String = "Android version ${android.os.Build.VERSION.SDK_INT}"
}