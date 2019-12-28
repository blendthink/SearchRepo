package div.honwakadeveloper.searchrepo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
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

    val reposData = object : MutableLiveData<ReposData>() {

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

    private val _totalCount = Transformations.map(reposData) {
        it.totalCount.toString()
    }

    val totalCount: LiveData<String> = _totalCount

    fun updateSearchWord(searchWord: String) {
        println("okayama 検索文字を更新！")
        this.searchWord.value = searchWord
    }
}