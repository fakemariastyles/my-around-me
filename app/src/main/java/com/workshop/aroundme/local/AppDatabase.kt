package com.workshop.aroundme.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.workshop.aroundme.local.dao.PlaceDao
import com.workshop.aroundme.local.model.LocalPlace

@Database(entities = [LocalPlace::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun placeDao(): PlaceDao
}