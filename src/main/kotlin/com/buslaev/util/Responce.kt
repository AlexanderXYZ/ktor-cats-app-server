package com.buslaev.util

import com.buslaev.feature.cat.module.Cat
import com.buslaev.feature.cat.module.CatListResponse
import com.buslaev.feature.cat.module.CatResponse
import io.ktor.http.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.*

@Serializable
abstract class BaseResponse<out T>

@Serializable
@SerialName("SuccessResponse")
data class SuccessResponse<out T>(
    @Serializable(with = StatusCodeSerializer::class)
    @Contextual
    val statusCode: HttpStatusCode,
    val data: T? = null
//    val message: String? = null
) : BaseResponse<T>()

@Serializable
@SerialName("UnSuccessResponse")
data class UnSuccessResponse<out T>(
    //val statusCode: HttpStatusCode,
    val exception: T? = null
) : BaseResponse<T>()

val responseModule = SerializersModule {
    polymorphic(BaseResponse::class) {
        subclass(SuccessResponse.serializer(PolymorphicSerializer(Any::class)))
    }
}

val catListResponseModule = SerializersModule {
    polymorphic(Any::class) {
        subclass(CatListResponse::class)
    }
}
val catInfoModule = SerializersModule {
    polymorphic(Any::class) {
        subclass(CatResponse::class)
    }
}

//val catEditModule = SerializersModule {
//    polymorphic(Any::class) {
//        subclass(Boolean.serializer())
//    }
//}
val formatCats = Json { serializersModule = responseModule + catListResponseModule }
val formatCatInfo = Json { serializersModule = responseModule + catInfoModule }
//val formatEdit = Json { serializersModule = responseModule + catEditModule }
//val formatCatReturnBoolean = Json { serializersModule = responseModule+ catModule }


class StatusCodeSerializer : KSerializer<HttpStatusCode> {
    override fun deserialize(decoder: Decoder): HttpStatusCode {
        return HttpStatusCode(decoder.decodeInt(), "")
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("HttpStatusCode", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: HttpStatusCode) {
        encoder.encodeInt(value.value)
    }
}

