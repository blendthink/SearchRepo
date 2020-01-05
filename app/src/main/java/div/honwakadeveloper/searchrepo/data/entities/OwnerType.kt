package div.honwakadeveloper.searchrepo.data.entities

import com.squareup.moshi.Json

enum class OwnerType {

    @Json(name = "User")
    USER,

    @Json(name = "Organization")
    ORGANIZATION
}