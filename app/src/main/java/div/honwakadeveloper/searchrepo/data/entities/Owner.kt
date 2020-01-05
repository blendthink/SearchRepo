package div.honwakadeveloper.searchrepo.data.entities

import com.squareup.moshi.Json

data class Owner(

    @Json(name = "login")
    val login: String,

    @Json(name = "id")
    val id: Long,

    @Json(name = "node_id")
    val nodeId: String,

    @Json(name = "avatar_url")
    val avatarUrl: String,

    @Json(name = "gravatar_id")
    val gravatarId: String,

    @Json(name = "url")
    val url: String,

    @Json(name = "received_events_url")
    val receivedEventsUrl: String,

    @Json(name = "type")
    val type: OwnerType
)