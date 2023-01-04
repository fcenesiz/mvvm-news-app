package com.fcenesiz.mvvmnewsapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fcenesiz.mvvmnewsapp.api.NewsAPI
import com.fcenesiz.mvvmnewsapp.db.ArticleDao
import com.fcenesiz.mvvmnewsapp.db.ArticleDatabase
import com.fcenesiz.mvvmnewsapp.repository.NewsRepository
import com.fcenesiz.mvvmnewsapp.util.Constants.BASE_URL
import com.fcenesiz.mvvmnewsapp.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideArticleDatabase(
        @ApplicationContext context: Context
    ): RoomDatabase = Room.databaseBuilder(
        context.applicationContext,
        ArticleDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideNewsRepository(db: ArticleDatabase) = NewsRepository(db)

    @Singleton
    @Provides
    fun provideArticleDao(db: ArticleDatabase) = db.getArticleDao()

}