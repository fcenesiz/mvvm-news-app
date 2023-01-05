package com.fcenesiz.mvvmnewsapp.repository

import com.fcenesiz.mvvmnewsapp.api.NewsAPI
import com.fcenesiz.mvvmnewsapp.db.ArticleDatabase
import com.fcenesiz.mvvmnewsapp.models.Article
import com.fcenesiz.mvvmnewsapp.models.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    val api: NewsAPI,
    val db: ArticleDatabase
) : MainRepository {

    override suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews(countryCode, pageNumber)

    override suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse> =
        api.searchForNews(searchQuery, pageNumber)

    override suspend fun upsertArticle(article: Article) = db.getArticleDao().upsert(article)

    override fun getSavedNews() = db.getArticleDao().getAll()

    override suspend fun deleteArticle(article: Article) = db.getArticleDao().delete(article)
}