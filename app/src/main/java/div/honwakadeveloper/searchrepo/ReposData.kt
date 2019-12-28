package div.honwakadeveloper.searchrepo

import com.squareup.moshi.Json

data class ReposData(

    @Json(name = "total_count")
    val totalCount: Int,

    @Json(name = "incomplete_results")
    val incompleteResult: Boolean,

    @Json(name = "items")
    val items: List<RepoData>
)