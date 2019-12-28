package div.honwakadeveloper.searchrepo

import com.squareup.moshi.Json

data class RepoData(

    @Json(name = "full_name")
    val fullName: String
)