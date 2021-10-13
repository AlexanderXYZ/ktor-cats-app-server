package com.buslaev.feature.cat.domain

import com.buslaev.feature.cat.module.CatListResponse
import com.buslaev.feature.cat.repository.CatRepository
import com.buslaev.util.BaseResponse

class GetCatsUseCase(private val catRepository: CatRepository) {

    suspend fun invoke(): BaseResponse<CatListResponse> {
        return catRepository.getCats() as BaseResponse<CatListResponse>
    }
}