package com.buslaev.feature.cat.domain

import com.buslaev.base.BaseUseCase
import com.buslaev.feature.cat.module.CatResponse
import com.buslaev.feature.cat.repository.CatRepository
import com.buslaev.util.BaseResponse

class DeleteCatUseCase(private val catRepository: CatRepository) : BaseUseCase<String, Any> {

    override suspend fun invoke(input: String): BaseResponse<CatResponse> {
        return catRepository.deleteCatById(input) as BaseResponse<CatResponse>
    }
}