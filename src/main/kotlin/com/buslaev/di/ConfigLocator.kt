package com.buslaev.di

import com.buslaev.base.http.ExceptionHandler
import com.buslaev.base.http.ExceptionHandlerImpl

object ConfigLocator {

    fun provideExceptionHandler(): ExceptionHandler {
        return ExceptionHandlerImpl()
    }
}