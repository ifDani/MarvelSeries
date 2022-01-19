package com.example.marvelseries.di

import com.example.marvelseries.data.remote.MarvelApi
import com.example.marvelseries.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Named("baseUrl")
    fun provideBaseUrl() = BASE_URL.toHttpUrl()


    //To log http calls
    @Singleton
    @Provides
    fun provideInterceptor(): OkHttpClient {
        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().addInterceptor(logginInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("baseUrl") baseUrl: HttpUrl): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()
    }

    @Provides
    @Singleton
    fun provideMarvelApi(): MarvelApi {
        return Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .client(provideInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelApi::class.java)

    }
}