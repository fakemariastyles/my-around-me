package com.workshop.aroundme.remote.model.response

data class PlaceDetailResponseDto(
    val meta: Meta?,
    val response: DetailResponseDto?
)

data class DetailResponseDto(
    val address: String?,
    val alternate_name: Any?,
    val always_open: Boolean?,
    val attributes: Attributes?,
    val categories: List<Category?>?,
    val checkin_count: Int?,
    val comment_count: Int?,
    val comments: List<Comment?>?,
    val cover_image: CoverImage?,
    val description: Any?,
    val full_name: String?,
    val has_checkin: Boolean?,
    val image_count: Int?,
    val images: List<DetailImage?>?,
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
    val liked_by: List<String?>?,
    val lng: String?,
    val my_checkins: Int?,
    val name: String?,
    val opening_hours: List<OpeningHour?>?,
    val place_id: Int?,
    val postal_code: Any?,
    val privacy_level: String?,
    val slug: String?,
    val tags: List<Tag?>?,
    val tels: List<String?>?,
    val total_checkins: Int?,
    val total_views: Int?,
    val transit: Transit?,
    val url: String?,
    val website: Any?
)

data class DetailImage(
    val created_at: String?,
    val image: ImageX?,
    val image_type: String?,
    val is_cover_photo: Boolean?,
    val place_image_id: Int?,
    val title: Any?,
    val user: User?
)

data class User(
    val auth_method: String?,
    val avatar: Avatar?,
    val confidence_level: Any?,
    val full_name: String?,
    val invitation_code: String?,
    val last_activity_at: String?,
    val profile_name: String?,
    val url: String?,
    val user_id: Int?
)

data class Avatar(
    val large: Large?,
    val medium: Medium?,
    val small: Small?,
    val tiny: Tiny?
)

data class Comment(
    val body: String?,
    val comment_id: Int?,
    val created_at: String?,
    val is_liked: Boolean?,
    val like_count: Int?,
    val liked_by: List<String?>?,
    val user: UserX?
)

data class UserX(
    val auth_method: String?,
    val avatar: Avatar?,
    val confidence_level: Any?,
    val full_name: String?,
    val invitation_code: String?,
    val last_activity_at: String?,
    val profile_name: Any?,
    val url: String?,
    val user_id: Int?
)

data class Tag(
    val id: Int?,
    val name: String?
)

data class Transit(
    val bus: Bus?,
    val metro: Metro?
)

data class Metro(
    val address: String?,
    val categories: List<Category?>?,
    val checkin_count: Int?,
    val comment_count: Int?,
    val description: Any?,
    val distance: String?,
    val full_name: String?,
    val has_checkin: Boolean?,
    val image_count: Int?,
    val is_bookmarked: Boolean?,
    val is_claimed: Boolean?,
    val is_closed: Boolean?,
    val is_deleted: Boolean?,
    val is_liked: Boolean?,
    val is_manager: Boolean?,
    val is_now_open: Any?,
    val is_verified: Boolean?,
    val lat: String?,
    val latlng: String?,
    val like_count: Int?,
    val lng: String?,
    val my_checkins: Int?,
    val name: String?,
    val place_id: Int?,
    val privacy_level: String?,
    val slug: String?,
    val total_checkins: Int?,
    val total_views: Int?,
    val url: String?
)

data class Bus(
    val address: String?,
    val categories: List<Category?>?,
    val checkin_count: Int?,
    val comment_count: Int?,
    val description: Any?,
    val distance: String?,
    val full_name: String?,
    val has_checkin: Boolean?,
    val image_count: Int?,
    val is_bookmarked: Boolean?,
    val is_claimed: Boolean?,
    val is_closed: Boolean?,
    val is_deleted: Boolean?,
    val is_liked: Boolean?,
    val is_manager: Boolean?,
    val is_now_open: Any?,
    val is_verified: Boolean?,
    val lat: String?,
    val latlng: String?,
    val like_count: Int?,
    val lng: String?,
    val my_checkins: Int?,
    val name: String?,
    val place_id: Int?,
    val privacy_level: String?,
    val slug: String?,
    val total_checkins: Int?,
    val total_views: Int?,
    val url: String?
)

data class OpeningHour(
    val closing_time: String?,
    val days_of_week: String?,
    val opening_time: String?
)

data class CoverImage(
    val image: ImageX?
)