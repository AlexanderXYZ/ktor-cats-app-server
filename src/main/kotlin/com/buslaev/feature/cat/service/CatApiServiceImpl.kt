package com.buslaev.feature.cat.service

import com.buslaev.feature.cat.module.Cat
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.eq

class CatApiServiceImpl(
    private val catCollection: CoroutineCollection<Cat>
) : CatApiService {

    override suspend fun insertCat(cat: Cat): Boolean {
        return catCollection.insertOne(cat).wasAcknowledged()
    }

    override suspend fun deleteCatById(catId: String): Boolean {
        return catCollection.deleteOneById(catId).wasAcknowledged()
    }

    override suspend fun updateCat(catId: String, cat: Cat): Boolean {
        return catCollection.updateOneById(
            id = catId,
            update = cat,
            updateOnlyNotNullProperties = true
        ).wasAcknowledged()
    }

    override suspend fun getCatById(catId: String): Cat? {
        return catCollection.findOneById(catId)
    }

    override suspend fun getCats(): List<Cat> {
        return catCollection.find().toList()
    }
}