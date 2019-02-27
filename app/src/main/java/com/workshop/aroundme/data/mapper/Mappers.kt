package com.workshop.aroundme.data.mapper

import com.beust.klaxon.JSON
import com.beust.klaxon.Parser
import com.workshop.aroundme.data.model.PlaceDetailEntity
import com.workshop.aroundme.data.model.PlaceEntity
import com.workshop.aroundme.data.model.TokenResponse
import com.workshop.aroundme.data.model.UserEntity
import com.workshop.aroundme.local.model.LocalPlace
import com.workshop.aroundme.remote.model.response.DetailResponseDto
import com.workshop.aroundme.remote.model.response.PlaceDto

fun PlaceDto.toPlaceEntity() = PlaceEntity(
    name = full_name,
    address = address,
    likes = like_count,
    imageUrl = images?.getOrNull(0)?.image?.card?.url,
    isFavorite = is_liked != null && is_liked,
    placeId = place_id,
    slug = slug
)

fun LocalPlace.toPlaceEntity() = PlaceEntity(
    name = name,
    address = address,
    likes = 0,
    imageUrl = null,
    isFavorite = isStarred,
    placeId = placeId,
    slug = null
)

fun PlaceEntity.toLocalPlace() = LocalPlace(
    name = name ?: "",
    placeId = placeId,
    address = address ?: "",
    isStarred = isFavorite
)

fun DetailResponseDto.toPlaceDetailEntity() = PlaceDetailEntity(
    coverUrl = cover_image?.image?.medium?.url,
    name = full_name,
    categories = categories?.joinToString(separator = " ،") { category -> category?.name.toString() },
    address = address,
    location = latlng,
    tags = tags?.joinToString(separator = " ،") { tag -> tag?.name.toString() }

)
