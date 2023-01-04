package com.fcenesiz.mvvmnewsapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fcenesiz.mvvmnewsapp.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment(val resId : Int) : Fragment(resId) {
    protected val viewModel: NewsViewModel by viewModels()
}