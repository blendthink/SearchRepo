package div.honwakadeveloper.searchrepo

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private val appModules = module {
    single<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single { createApiOkHttpClient() }
}

private val apiModule = module {
    factory<ApiService> { createApi(get(), get()) }
}

private val repositoryModule = module {
    single { RepoRepository(get()) }
}

private val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

private fun createApiOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor { chain ->

            val request = chain.request().newBuilder().also {
                it.addHeader("Accept", "application/json")
                it.addHeader("Content-Type", "application/json")
            }

            chain.proceed(request.build())
        }
        .build()
}

private inline fun <reified T> createApi(okHttpClient: OkHttpClient, moshi: Moshi): T {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(T::class.java)
}

object Module {
    val modules = listOf(appModules, apiModule, repositoryModule, viewModelModule)
}