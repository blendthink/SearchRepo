package div.honwakadeveloper.searchrepo.data.entities

import com.squareup.moshi.Json

data class Repos(

    @Json(name = "total_count")
    val totalCount: Int,

    @Json(name = "incomplete_results")
    val incompleteResult: Boolean,

    @Json(name = "items")
    val items: List<Repo>
)