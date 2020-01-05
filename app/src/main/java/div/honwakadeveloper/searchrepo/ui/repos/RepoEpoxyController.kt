package div.honwakadeveloper.searchrepo.ui.repos

import com.airbnb.epoxy.TypedEpoxyController
import div.honwakadeveloper.searchrepo.RepoBindingModel_
import div.honwakadeveloper.searchrepo.data.entities.Repo

class RepoEpoxyController : TypedEpoxyController<List<Repo>>() {

    override fun buildModels(data: List<Repo>?) {

        if (data.isNullOrEmpty()) return

        data.forEach {

            RepoBindingModel_()
                .id(it.id)
                .repo(it)
                .addTo(this)
        }
    }
}