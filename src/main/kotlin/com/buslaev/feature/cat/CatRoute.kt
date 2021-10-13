package com.buslaev.feature.cat

import com.buslaev.di.domain.DomainProvider
import com.buslaev.feature.cat.module.Cat
import com.buslaev.feature.cat.request.UpdateCatRequest
import com.buslaev.util.formatCatInfo
import com.buslaev.util.formatCats
import io.ktor.application.*
import io.ktor.locations.get
import io.ktor.locations.post
import io.ktor.locations.delete
import io.ktor.locations.put
import io.ktor.response.*
import io.ktor.routing.*
import com.buslaev.util.getBodyContent
import kotlinx.serialization.json.encodeToJsonElement

fun Application.catRoutes(domainProvider: DomainProvider) {
    routing {

        get<CatLocations.CatInfo> { catRequest ->
            val response = domainProvider.provideGetCatByIdUseCase().invoke(catRequest.catId)
            call.respond(formatCatInfo.encodeToJsonElement(response))
        }

        get<CatLocations.GetCats> {
            val response = domainProvider.provideGetCatsUseCase().invoke()
            call.respond(formatCats.encodeToJsonElement(response))
        }

        post<CatLocations.InsertCat> {
            val cat = getBodyContent<Cat>()
            val response = domainProvider.provideInsertCatUseCase().invoke(cat)
            call.respond(formatCatInfo.encodeToJsonElement(response))
        }

        put<CatLocations.UpdateCat> {
            val cat = getBodyContent<UpdateCatRequest>()
            val request = Pair(cat.catId, cat.cat)
            val response = domainProvider.provideUpdateCatUseCase().invoke(request)
            call.respond(formatCatInfo.encodeToJsonElement(response))
        }

        delete<CatLocations.DeleteCatById> { request ->
            val response = domainProvider.provideDeleteCatUseCase().invoke(request.catId)
            call.respond(formatCatInfo.encodeToJsonElement(response))
        }
    }
}