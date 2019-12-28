package div.honwakadeveloper.searchrepo

import com.squareup.moshi.Json

data class RepositoriesData(

    @Json(name = "total_count")
    val totalCount: Int,

    @Json(name = "incomplete_results")
    val incompleteResult: Boolean,

    @Json(name = "items")
    val items: List<RepositoryData>
)