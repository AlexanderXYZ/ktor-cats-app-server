package com.buslaev.di.repository

import com.buslaev.feature.cat.repository.CatRepository

interface RepositoryProvider {

    fun provideCatRepository():CatRepository
}