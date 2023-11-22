package example.com

import example.com.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureKoin()
    configureStatusPages()
    configureDefaultHeader()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
