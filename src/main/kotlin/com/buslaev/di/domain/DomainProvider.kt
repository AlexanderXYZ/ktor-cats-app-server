package com.buslaev.di.domain

import com.buslaev.feature.cat.domain.*

interface DomainProvider {

    fun provideInsertCatUseCase():InsertCatUseCase

    fun provideDeleteCatUseCase():DeleteCatUseCase

    fun provideUpdateCatUseCase():UpdateCatUseCase

    fun provideGetCatByIdUseCase():GetCatByIdUseCase

    fun provideGetCatsUseCase():GetCatsUseCase
}