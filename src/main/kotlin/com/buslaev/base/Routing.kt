package com.buslaev.base

import com.buslaev.di.domain.DomainLocator
import com.buslaev.feature.cat.catRoutes
import io.ktor.routing.*
import io.ktor.locations.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*

fun Application.configureRouting() {
    install(Locations)
    install(Routing)

    routing {
        catRoutes(DomainLocator.provideDomainProvider())
    }
}

