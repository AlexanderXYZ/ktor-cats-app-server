package com.buslaev.feature.cat.module

import kotlinx.serialization.Serializable

@Serializable
data class CatListResponse(
    val cats: List<Cat> = emptyList()
)
