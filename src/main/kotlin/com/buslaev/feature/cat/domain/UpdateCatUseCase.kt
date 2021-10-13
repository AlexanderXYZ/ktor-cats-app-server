package com.buslaev.feature.cat.domain

import com.buslaev.base.BaseUseCase
import com.buslaev.feature.cat.module.Cat
import com.buslaev.feature.cat.module.CatResponse
import com.buslaev.feature.cat.repository.CatRepository
import com.buslaev.util.BaseResponse

class UpdateCatUseCase(private val catRepository: CatRepository) : BaseUseCase<Pair<String, Cat>, Any> {

    override suspend fun invoke(input: Pair<String, Cat>): BaseResponse<CatResponse> {
        return catRepository.updateCat(input.first, input.second) as BaseResponse<CatResponse>
    }
}