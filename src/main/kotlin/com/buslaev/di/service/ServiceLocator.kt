package com.buslaev.di.service

import com.buslaev.feature.cat.module.Cat
import com.buslaev.feature.cat.service.CatApiService
import com.buslaev.feature.cat.service.CatApiServiceImpl
import org.litote.kmongo.coroutine.CoroutineCollection

object ServiceLocator {

    fun provideCatApiService(catCollection: CoroutineCollection<Cat>): CatApiService {
        return CatApiServiceImpl(catCollection)
    }

    fun providerServiceProvider():ServiceProvider{
        return ServiceProviderImpl()
    }
}