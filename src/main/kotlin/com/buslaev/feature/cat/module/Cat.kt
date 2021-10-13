package com.buslaev.feature.cat.module

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Cat(
    @BsonId
    var catId: String = ObjectId().toString(),
    var name: String? = null,
    var gender: String? = null,
    var height: Int? = null,
    var weight: Int? = null,
    var dominantColor: String? = null,
    var secondColor: String? = null,
    var imageUrl: String? = null
)

enum class Gender(val gender: String) {
    Male("male"),
    Female("female")
}
