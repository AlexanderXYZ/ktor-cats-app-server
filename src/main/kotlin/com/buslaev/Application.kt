package com.buslaev

import com.buslaev.base.configureRouting
import com.buslaev.base.configureStatusPages
import com.buslaev.di.ConfigLocator
import io.ktor.application.*
import com.buslaev.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

private val serviceLocator = ConfigLocator

fun Application.module() {
    configureStatusPages()
    configureRouting()
    configureSerialization()
    configureMonitoring()
}
