package io.kraftsman.app.kmmkungfu

class PasswordGenerator {
    private val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9') + "@#=+!£$%&?".toList()

    fun generate(length: Int): String = (1..length).map {
        chars.random()
    }.joinToString("")
}
