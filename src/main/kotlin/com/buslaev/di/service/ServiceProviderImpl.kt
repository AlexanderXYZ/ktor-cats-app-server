package com.buslaev.di.service

import com.buslaev.di.database.DatabaseLocator
import com.buslaev.feature.cat.service.CatApiService

class ServiceProviderImpl : ServiceProvider {

    override fun provideCatService(): CatApiService {
        return ServiceLocator.provideCatApiService(DatabaseLocator.provideDatabase().catCollection)
    }
}