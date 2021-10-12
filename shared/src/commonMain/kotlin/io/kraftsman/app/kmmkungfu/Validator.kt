package io.kraftsman.app.kmmkungfu

import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

class Validator {
    private val httpClient = httpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun inspect(password: String): InspectResponse {
        return httpClient.post("http://localhost:8080/api/v1/passwords/inspection") {
            accept(ContentType.Application.Json)
            contentType(ContentType.Application.Json)
            body = InspectRequest(password)
        }
    }
}
