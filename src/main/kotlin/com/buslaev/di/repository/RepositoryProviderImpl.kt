package com.buslaev.di.repository

import com.buslaev.di.service.ServiceProvider
import com.buslaev.feature.cat.repository.CatRepository
import com.buslaev.feature.cat.repository.CatRepositoryImpl
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi

class RepositoryProviderImpl(private val serviceProvider: ServiceProvider) : RepositoryProvider {


    override fun provideCatRepository(): CatRepository {
        return RepositoryLocator.provideCatRepository(serviceProvider.provideCatService())
    }
}