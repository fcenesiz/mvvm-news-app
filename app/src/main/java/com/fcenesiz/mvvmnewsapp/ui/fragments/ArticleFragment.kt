package com.fcenesiz.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fcenesiz.mvvmnewsapp.R
import com.fcenesiz.mvvmnewsapp.databinding.FragmentArticleBinding
import com.fcenesiz.mvvmnewsapp.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


class ArticleFragment : BaseFragment(R.layout.fragment_article) {

    companion object {
        public val TAG: String = ArticleFragment::class.simpleName.toString()
    }

    lateinit var binding: FragmentArticleBinding
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

    }

}