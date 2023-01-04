package com.fcenesiz.mvvmnewsapp.di

import com.fcenesiz.mvvmnewsapp.api.NewsAPI
import com.fcenesiz.mvvmnewsapp.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApi(
        retrofit: Retrofit
    ) = retrofit.create(NewsAPI::class.java)


}

/*
val logging = HttpLoggingInterceptor()
logging.setLevel(HttpLoggingInterceptor.Level.Body)
val client = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()
*/