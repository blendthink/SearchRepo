package div.honwaka_developer.searchrepository

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SearchRepositoryApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SearchRepositoryApp)
            modules(Module.modules)
        }
    }
}