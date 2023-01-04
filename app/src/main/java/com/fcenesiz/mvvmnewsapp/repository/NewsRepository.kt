package com.fcenesiz.mvvmnewsapp.repository

import com.fcenesiz.mvvmnewsapp.api.NewsAPI
import com.fcenesiz.mvvmnewsapp.db.ArticleDatabase
import javax.inject.Inject

class NewsRepository @Inject constructor(
    val api: NewsAPI,
    val db: ArticleDatabase
) : MainRepository {

    override suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews(countryCode, pageNumber)

}