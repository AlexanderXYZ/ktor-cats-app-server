package com.buslaev.feature.cat.repository

import com.buslaev.base.http.ExceptionHandler
import com.buslaev.feature.cat.module.Cat
import com.buslaev.feature.cat.module.CatListResponse
import com.buslaev.feature.cat.module.CatResponse
import com.buslaev.feature.cat.service.CatApiService
import com.buslaev.util.BaseResponse
import com.buslaev.util.SuccessResponse
import io.ktor.http.*

class CatRepositoryImpl(
    private val catApiService: CatApiService,
    private val exceptionHandler: ExceptionHandler
) : CatRepository {

    companion object {
        private const val CAT_NOT_FOUND = "Cat not found"
        private const val CANNOT_UPDATE = "You cannot update the data"
    }

    override suspend fun insertCat(cat: Cat): BaseResponse<Any> {
        val isSuccess = catApiService.insertCat(cat)
        //return SuccessResponse(HttpStatusCode.OK, isSuccess)
        return SuccessResponse(HttpStatusCode.OK, CatResponse(cat))
    }

    override suspend fun deleteCatById(catId: String?): BaseResponse<Any> {
        val (cat, doExist) = checkIfCatExistWithCatData(catId)
        if (catId != null && doExist) {
            val isSuccess = catApiService.deleteCatById(catId)
            //return SuccessResponse(HttpStatusCode.OK, isSuccess)
            return SuccessResponse(HttpStatusCode.OK, CatResponse(cat ?: Cat()))
        } else {
            throw exceptionHandler.respondWithNotFoundException(CAT_NOT_FOUND)
        }
    }

    override suspend fun updateCat(catId: String, cat: Cat): BaseResponse<Any> {
        val (catToBeUpdater, doExist) = checkIfCatExistWithCatData(catId)
        if (catToBeUpdater != null && doExist && catToBeUpdater.catId == catId) {
            val catUpdated = cat.copy(
                catId = catId,
                name = catToBeUpdater.name,
                gender = catToBeUpdater.gender,
                height = catToBeUpdater.height,
                weight = catToBeUpdater.weight,
                dominantColor = catToBeUpdater.dominantColor,
                secondColor = catToBeUpdater.secondColor,
                imageUrl = catToBeUpdater.imageUrl
            )
            val isSuccess = catApiService.updateCat(catId, catUpdated)
            //return SuccessResponse(HttpStatusCode.OK, isSuccess)
            return SuccessResponse(HttpStatusCode.OK, CatResponse(catUpdated))
        } else {
            throw exceptionHandler.respondWithGenericException(CANNOT_UPDATE)
        }
    }

    override suspend fun getCatById(catId: String?): BaseResponse<Any> {
        val (cat, doExist) = checkIfCatExistWithCatData(catId)
        if (catId != null && doExist) {
            //return SuccessResponse(HttpStatusCode.Found, cat)
            return if (cat != null) {
                SuccessResponse(HttpStatusCode.Found, CatResponse(cat))
            } else
                SuccessResponse(HttpStatusCode.Found, CatResponse(Cat()))


        } else {
            throw exceptionHandler.respondWithNotFoundException(CAT_NOT_FOUND)
        }
    }

    override suspend fun getCats(): BaseResponse<Any> {
        val cats = catApiService.getCats()
        return if (cats.isEmpty()) {
            //SuccessResponse(HttpStatusCode.OK, emptyList<Cat>())
            SuccessResponse(HttpStatusCode.OK, CatListResponse())
        } else {
            //SuccessResponse(HttpStatusCode.OK, cats)
            SuccessResponse(HttpStatusCode.OK, CatListResponse(cats))
        }
    }

    private suspend fun checkIfCatExistWithCatData(catId: String?): Pair<Cat?, Boolean> {
        val cat = catId?.let { catApiService.getCatById(catId) }
        return Pair(cat, cat != null)
    }
}