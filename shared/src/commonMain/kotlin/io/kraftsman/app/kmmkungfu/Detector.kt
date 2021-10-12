package io.kraftsman.app.kmmkungfu

class Detector {

    fun detect(): String {
        return Platform().platform
    }
}
