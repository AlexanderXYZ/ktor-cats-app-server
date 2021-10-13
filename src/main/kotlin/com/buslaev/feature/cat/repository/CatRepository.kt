package com.buslaev.feature.cat.repository

import com.buslaev.feature.cat.module.Cat
import com.buslaev.util.BaseResponse

interface CatRepository {

    suspend fun insertCat(cat: Cat): BaseResponse<Any>

    suspend fun deleteCatById(catId: String?): BaseResponse<Any>

    suspend fun updateCat(catId: String, cat: Cat): BaseResponse<Any>

    suspend fun getCatById(catId: String?): BaseResponse<Any>

    suspend fun getCats(): BaseResponse<Any>
}