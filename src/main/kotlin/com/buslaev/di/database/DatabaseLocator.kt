package com.buslaev.di.database

import com.buslaev.base.database.Database
import com.buslaev.base.database.DatabaseImpl

object DatabaseLocator {

    private fun provideClientName(): String {
        return "ktor-cats-mongo"
    }

    fun provideDatabase(): Database {
        return DatabaseImpl(provideClientName())
    }
}