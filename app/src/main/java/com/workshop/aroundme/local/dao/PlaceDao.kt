package com.workshop.aroundme.local.dao

import androidx.room.*
import com.workshop.aroundme.local.model.LocalPlace

@Dao
interface PlaceDao {

    @Query("SELECT * FROM place WHERE isStarred = 1")
    fun listStarredPlaces(): List<LocalPlace>

    @Query("SELECT * FROM place")
    fun listAll(): List<LocalPlace>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg localPlace: LocalPlace)

    @Update
    fun update(localPlace: LocalPlace)

    @Delete
    fun delete(vararg localPlace: LocalPlace)

    @Query("DELETE FROM place")
    fun clearAll()
}