package com.buslaev.feature.cat.module

import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    val cat: Cat = Cat()
)
