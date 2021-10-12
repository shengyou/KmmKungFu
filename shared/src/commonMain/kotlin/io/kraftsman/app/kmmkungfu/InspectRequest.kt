package io.kraftsman.app.kmmkungfu

import kotlinx.serialization.Serializable

@Serializable
data class InspectRequest(val password: String)
