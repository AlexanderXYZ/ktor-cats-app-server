package com.buslaev.feature.cat.service

import com.buslaev.feature.cat.module.Cat

interface CatApiService {

    suspend fun insertCat(cat: Cat): Boolean

    suspend fun deleteCatById(catId:String): Boolean

    suspend fun updateCat(catId: String, cat: Cat): Boolean

    suspend fun getCatById(catId: String): Cat?

    suspend fun getCats(): List<Cat>

}