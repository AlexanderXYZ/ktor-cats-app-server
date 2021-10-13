package com.buslaev.base.database

import com.buslaev.feature.cat.module.Cat
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class DatabaseImpl(private val clientName: String) : Database {

    override val initializationName: String
        get() = clientName

    override val mongoClient: CoroutineClient
        get() = KMongo.createClient().coroutine

    override val database: CoroutineDatabase
        get() = mongoClient.getDatabase(initializationName)

    override val catCollection: CoroutineCollection<Cat>
        get() = database.getCollection()
}