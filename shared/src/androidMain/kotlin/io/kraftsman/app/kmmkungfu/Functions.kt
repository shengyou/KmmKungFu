package io.kraftsman.app.kmmkungfu

import io.ktor.client.*
import io.ktor.client.engine.android.*

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Android) {
    config(this)

    engine {
        connectTimeout = 100_000
        socketTimeout = 100_000
    }
}
