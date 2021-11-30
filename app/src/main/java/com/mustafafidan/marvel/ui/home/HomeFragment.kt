package com.mustafafidan.marvel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mustafafidan.marvel.databinding.FragmentHomeBinding
import com.mustafafidan.marvel.ui.home.adapter.CharactersAdapter
import com.mustafafidan.marvel.ui.home.adapter.CharactersLoadingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding : FragmentHomeBinding
    private lateinit var charactersAdapter : CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUi()
        this.setRefreshListener()
        this.setRecyclerAdapter()
        this.updateAdapter()
        this.addStateListener()
    }

    private fun setupUi(){
        binding.recyclerView.setHasFixedSize(true)
        binding.swipeRefreshLayout.isRefreshing = true

    }

    private fun setRecyclerAdapter(){
        binding.recyclerView.apply {
            charactersAdapter = CharactersAdapter()
            val loadingAdapter = CharactersLoadingAdapter(charactersAdapter)
            adapter = charactersAdapter.withLoadStateFooter(footer = loadingAdapter)
        }
    }

    private fun updateAdapter(){
        lifecycleScope.launch {
            homeViewModel.flow.collectLatest { pagingData ->
                charactersAdapter.submitData(pagingData)
            }
        }
    }

    private fun addStateListener(){
        charactersAdapter.addLoadStateListener { loadState->
            if (!(loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading)){
                this.finishRefreshing()
            }
        }
    }

    private fun finishRefreshing(){
        if(binding.swipeRefreshLayout.isRefreshing) {
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setRefreshListener(){
        binding.swipeRefreshLayout.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        charactersAdapter.refresh()
    }
}