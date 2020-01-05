package div.honwakadeveloper.searchrepo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import div.honwakadeveloper.searchrepo.data.RepoRepository
import div.honwakadeveloper.searchrepo.data.entities.Repos
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MainViewModel(
    private val repoRepository: RepoRepository
) : ViewModel() {

    private val searchWord = MutableLiveData<String>()

    val reposData = object : MutableLiveData<Repos>() {

        override fun onActive() {
            super.onActive()

            value?.let { return }

            viewModelScope.launch {

                var job: Deferred<Unit>? = null

                searchWord.asFlow()
                    .debounce(2000)
                    .distinctUntilChanged()
                    .collect {

                        println("okayama 検索開始！")

                        job?.cancel()
                        job = async(Dispatchers.Main) {
                            value = repoRepository.getRepos(it)
                        }
                    }
            }
        }
    }

    fun updateSearchWord(searchWord: String) {
        println("okayama 検索文字を更新！")
        this.searchWord.value = searchWord
    }
}