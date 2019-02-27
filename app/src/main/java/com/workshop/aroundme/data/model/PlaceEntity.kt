package com.workshop.aroundme.data.model

data class PlaceEntity(
    val placeId: Int,
    val name: String?,
    val address: String?,
    val likes: Int?,
    val imageUrl: String?,
    var isFavorite: Boolean,
    val slug: String?
)