package com.buslaev.di.domain

import com.buslaev.di.repository.RepositoryLocator
import com.buslaev.feature.cat.domain.*
import com.buslaev.feature.cat.repository.CatRepository

object DomainLocator {

    fun provideInsertCatUseCase(catRepository: CatRepository): InsertCatUseCase {
        return InsertCatUseCase(catRepository)
    }

    fun provideDeleteCatUseCase(catRepository: CatRepository): DeleteCatUseCase {
        return DeleteCatUseCase(catRepository)
    }

    fun provideUpdateCatUseCase(catRepository: CatRepository): UpdateCatUseCase {
        return UpdateCatUseCase(catRepository)
    }

    fun provideGetCatByIdUseCase(catRepository: CatRepository): GetCatByIdUseCase {
        return GetCatByIdUseCase(catRepository)
    }

    fun provideGetCatsUseCase(catRepository: CatRepository): GetCatsUseCase {
        return GetCatsUseCase(catRepository)
    }

    fun provideDomainProvider(): DomainProvider {
        return DomainProviderImpl(RepositoryLocator.provideRepositoryProvider())
    }
}