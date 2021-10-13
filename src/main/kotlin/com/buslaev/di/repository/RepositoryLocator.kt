package com.buslaev.di.repository

import com.buslaev.di.ConfigLocator
import com.buslaev.di.service.ServiceLocator
import com.buslaev.feature.cat.repository.CatRepository
import com.buslaev.feature.cat.repository.CatRepositoryImpl
import com.buslaev.feature.cat.service.CatApiService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi

object RepositoryLocator {


    fun provideCatRepository(
        catApiService: CatApiService
    ): CatRepository {
        return CatRepositoryImpl(catApiService, ConfigLocator.provideExceptionHandler())
    }

    fun provideRepositoryProvider():RepositoryProvider{
        return RepositoryProviderImpl(ServiceLocator.providerServiceProvider())
    }
}