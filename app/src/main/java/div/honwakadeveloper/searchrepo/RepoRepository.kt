package div.honwakadeveloper.searchrepo

class RepoRepository(
    private val apiService: ApiService
) {

    suspend fun getRepositories(word: String): RepositoriesData {
        return apiService.repositoriesAsync(word).await()
    }
}