package com.fcenesiz.mvvmnewsapp.repository

import androidx.lifecycle.LiveData
import com.fcenesiz.mvvmnewsapp.models.Article
import com.fcenesiz.mvvmnewsapp.models.NewsResponse
import retrofit2.Response

interface MainRepository {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) : Response<NewsResponse>

    suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse>

    suspend fun upsertArticle(article: Article) : Long

    fun getSavedNews() : LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)

}