package div.honwakadeveloper.searchrepo.data

import div.honwakadeveloper.searchrepo.data.entities.Repos

class RepoRepository(
    private val apiService: ApiService
) {

    suspend fun getRepos(word: String): Repos {
        return apiService.repositoriesAsync(word).await()
    }
}