package div.honwaka_developer.searchrepository

import com.squareup.moshi.Json

data class RepositoryData(

    @Json(name = "full_name")
    val fullName: String
)