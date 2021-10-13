package com.buslaev.feature.cat

import com.buslaev.feature.cat.CatConstants.CAT_INFO
import com.buslaev.feature.cat.CatConstants.DELETE_CAT
import com.buslaev.feature.cat.CatConstants.GET_CATS
import com.buslaev.feature.cat.CatConstants.INSERT_CAT
import com.buslaev.feature.cat.CatConstants.UPDATE_CAT
import com.buslaev.feature.cat.module.Cat
import io.ktor.locations.*

sealed class CatLocations {

    @Location(CAT_INFO)
    data class CatInfo(val catId: String)

    @Location(GET_CATS)
    class GetCats

    @Location(INSERT_CAT)
    class InsertCat

    @Location(DELETE_CAT)
    data class DeleteCatById(val catId: String)

    @Location(UPDATE_CAT)
    data class UpdateCat(val catId: String, val cat: Cat)

}

