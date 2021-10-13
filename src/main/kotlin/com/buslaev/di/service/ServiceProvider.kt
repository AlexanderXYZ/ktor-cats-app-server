package com.buslaev.di.service

import com.buslaev.feature.cat.service.CatApiService

interface ServiceProvider {

    fun provideCatService(): CatApiService
}