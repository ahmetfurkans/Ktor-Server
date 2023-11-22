package example.com.routes

import example.com.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlin.test.Test
import kotlin.test.assertEquals


class RootTest {
    @Test
    fun `access root endpoint assert correct information`() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Welcome to Boruto API!", bodyAsText())
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access non existing endpoint,assert not found`() =
        testApplication {
            val response = client.get("/unknown")
            assertEquals(expected = HttpStatusCode.NotFound, actual = response.status)
            assertEquals(expected = "Page not Found.", actual = response.bodyAsText())
        }
}

