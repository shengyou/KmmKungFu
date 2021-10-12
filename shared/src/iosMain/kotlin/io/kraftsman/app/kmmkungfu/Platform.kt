package io.kraftsman.app.kmmkungfu

import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " version " + UIDevice.currentDevice.systemVersion
}
