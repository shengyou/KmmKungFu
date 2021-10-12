package io.kraftsman.app.kmmkungfu

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}