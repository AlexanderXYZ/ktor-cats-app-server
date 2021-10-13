package com.buslaev.feature.cat.request

import com.buslaev.feature.cat.module.Cat
import kotlinx.serialization.Serializable

@Serializable
data class UpdateCatRequest(
    val catId: String,
    val cat: Cat
)
