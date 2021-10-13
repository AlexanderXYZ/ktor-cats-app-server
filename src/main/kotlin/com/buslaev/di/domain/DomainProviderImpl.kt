package com.buslaev.di.domain

import com.buslaev.di.repository.RepositoryProvider
import com.buslaev.feature.cat.domain.*

class DomainProviderImpl(private val repositoryProvider: RepositoryProvider) : DomainProvider {

    override fun provideInsertCatUseCase(): InsertCatUseCase {
        return DomainLocator.provideInsertCatUseCase(repositoryProvider.provideCatRepository())
    }

    override fun provideDeleteCatUseCase(): DeleteCatUseCase {
        return DomainLocator.provideDeleteCatUseCase(repositoryProvider.provideCatRepository())
    }

    override fun provideUpdateCatUseCase(): UpdateCatUseCase {
        return DomainLocator.provideUpdateCatUseCase(repositoryProvider.provideCatRepository())
    }

    override fun provideGetCatByIdUseCase(): GetCatByIdUseCase {
        return DomainLocator.provideGetCatByIdUseCase(repositoryProvider.provideCatRepository())
    }

    override fun provideGetCatsUseCase(): GetCatsUseCase {
        return DomainLocator.provideGetCatsUseCase(repositoryProvider.provideCatRepository())
    }
}