package div.honwaka_developer.searchrepository

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    fun repositoriesAsync(

        @Query("q")
        word: String,

        @Query("sort")
        sort: String = "starts"

    ): Deferred<RepositoriesData>
}