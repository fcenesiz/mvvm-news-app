package com.fcenesiz.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import com.fcenesiz.mvvmnewsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    val newsRepository: NewsRepository
) : ViewModel() {
}