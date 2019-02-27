package com.workshop.aroundme.remote.model.response

data class FeaturedPlacesResponseDto(
    val meta: Meta?,
    val response: Response?
)

data class Meta(
    val code: Int?,
    val msg: Any?,
    val notification: Int?
)

data class Response(
    val items: List<PlaceDto>?,
    val total: Int?
)

data class PlaceDto(
    val address: String?,
    val attributes: Attributes?,
    val categories: List<Category?>?,
    val checkin_count: Int?,
    val comment_count: Int?,
    val description: Any?,
    val full_name: String?,
    val has_checkin: Boolean?,
    val image_count: Int?,
    val images: List<Image?>?,
    val is_bookmarked: Boolean?,
    val is_claimed: Boolean?,
    val is_closed: Boolean?,
    val is_deleted: Boolean?,
    val is_liked: Boolean?,
    val is_manager: Boolean?,
    val is_now_open: Boolean?,
    val is_verified: Boolean?,
    val lat: String?,
    val latlng: String?,
    val like_count: Int?,
    val lng: String?,
    val my_checkins: Int?,
    val name: String?,
    val place_id: Int,
    val privacy_level: String?,
    val slug: String?,
    val total_checkins: Int?,
    val total_views: Int?,
    val url: String?
)

data class Category(
    val icon: String?,
    val id: Int?,
    val name: String?
)

data class Image(
    val image: ImageX?
)

data class ImageX(
    val card: Card?,
    val large: Large?,
    val medium: Medium?,
    val small: Small?,
    val tiny: Tiny?
)

data class Tiny(
    val url: String?
)

data class Card(
    val url: String?
)

data class Small(
    val url: String?
)

data class Large(
    val url: String?
)

data class Medium(
    val url: String?
)

data class Attributes(
    val chilivery_promotion_code: ChiliveryPromotionCode?,
    val chilivery_url: ChiliveryUrl?
)

data class ChiliveryUrl(
    val type: String?,
    val value: String?
)

data class ChiliveryPromotionCode(
    val type: String?,
    val value: String?
)