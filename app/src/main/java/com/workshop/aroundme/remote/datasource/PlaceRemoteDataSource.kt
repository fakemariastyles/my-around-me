package com.workshop.aroundme.remote.datasource

import com.workshop.aroundme.remote.model.response.DetailResponseDto
import com.workshop.aroundme.remote.model.response.PlaceDto
import com.workshop.aroundme.remote.service.PlaceService

class PlaceRemoteDataSource(private val placeService: PlaceService) {

    fun getFeaturedPlaces(): List<PlaceDto>? {
        return placeService.getFeaturedPlacesResponse()
            .response?.items
    }

    fun getPlaceDetail(slug: String): DetailResponseDto? {
        return placeService.getPlaceDetailResponse(slug)
            .response
    }
}