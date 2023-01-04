package com.fcenesiz.mvvmnewsapp.repository

import com.fcenesiz.mvvmnewsapp.db.ArticleDatabase
import javax.inject.Inject

class NewsRepository(
    val db: ArticleDatabase
) {
}