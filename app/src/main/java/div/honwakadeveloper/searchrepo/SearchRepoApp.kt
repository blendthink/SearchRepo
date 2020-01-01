package div.honwakadeveloper.searchrepo

import android.app.Application
import div.honwakadeveloper.searchrepo.di.Module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SearchRepoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SearchRepoApp)
            modules(Module.modules)
        }
    }
}