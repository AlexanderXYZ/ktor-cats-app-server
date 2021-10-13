package com.buslaev.base.database

import com.buslaev.feature.cat.module.Cat
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

interface Database {

    val initializationName: String

    val mongoClient: CoroutineClient

    val database: CoroutineDatabase

    val catCollection: CoroutineCollection<Cat>
}