package com.workshop.aroundme.local.datasource

import com.workshop.aroundme.local.dao.PlaceDao
import com.workshop.aroundme.local.model.LocalPlace

class PlaceLocalDataSource(private val placeDao: PlaceDao) {

    fun getStarredPlaces(): List<LocalPlace> {
        return placeDao.listStarredPlaces()
    }

    fun starPlace(localPlace: LocalPlace) {
        placeDao.insert(localPlace)
    }
}