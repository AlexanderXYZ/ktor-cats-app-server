package com.buslaev.feature.cat.domain

import com.buslaev.base.BaseUseCase
import com.buslaev.feature.cat.module.Cat
import com.buslaev.feature.cat.module.CatResponse
import com.buslaev.feature.cat.repository.CatRepository
import com.buslaev.util.BaseResponse

class InsertCatUseCase(private val catRepository: CatRepository) : BaseUseCase<Cat, Any> {

    override suspend fun invoke(input: Cat): BaseResponse<CatResponse> {
        return catRepository.insertCat(input) as BaseResponse<CatResponse>
    }
}