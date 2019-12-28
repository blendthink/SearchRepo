package div.honwakadeveloper.searchrepo

class RepoRepository(
    private val apiService: ApiService
) {

    suspend fun getRepos(word: String): ReposData {
        return apiService.repositoriesAsync(word).await()
    }
}