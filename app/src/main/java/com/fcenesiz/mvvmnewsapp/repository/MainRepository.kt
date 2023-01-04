package com.fcenesiz.mvvmnewsapp.repository

import com.fcenesiz.mvvmnewsapp.models.NewsResponse
import retrofit2.Response

interface MainRepository {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) : Response<NewsResponse>

}