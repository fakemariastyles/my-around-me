package com.workshop.aroundme.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place")
data class LocalPlace(
    @PrimaryKey val placeId: Int,
    val name: String,
    val address: String,
    val isStarred: Boolean
)