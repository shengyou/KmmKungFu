package io.kraftsman.app.kmmkungfu

import io.ktor.client.*
import io.ktor.client.engine.ios.*

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Ios) {
    config(this)

    engine {
        configureRequest {
            setAllowsCellularAccess(true)
        }
    }
}
