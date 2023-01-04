package com.fcenesiz.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fcenesiz.mvvmnewsapp.R
import com.fcenesiz.mvvmnewsapp.adapters.NewsAdapter
import com.fcenesiz.mvvmnewsapp.databinding.FragmentSavedNewsBinding
import com.fcenesiz.mvvmnewsapp.databinding.FragmentSearchNewsBinding
import com.fcenesiz.mvvmnewsapp.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

class SavedNewsFragment : BaseFragment(R.layout.fragment_saved_news) {

    companion object {
        val TAG: String = SavedNewsFragment::class.simpleName.toString()
    }

    lateinit var binding: FragmentSavedNewsBinding
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        newsAdapter.setOnItemClickListener { article ->
            val bundle = Bundle().apply {
                putSerializable("article", article)
            }
            findNavController().navigate(
                R.id.action_savedNewsFragment_to_articleFragment,
                bundle
            )
        }

    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}