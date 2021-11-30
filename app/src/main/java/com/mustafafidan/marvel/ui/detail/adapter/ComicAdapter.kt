package com.mustafafidan.marvel.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafafidan.marvel.databinding.ItemComicBinding
import com.mustafafidan.marvel.model.local.ComicsUiModel

class ComicAdapter(var items : List<ComicsUiModel>) : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>(){

    private fun getItemViewState(position: Int) : ComicItemViewState {
        return ComicItemViewState(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        return ComicViewHolder(ItemComicBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bindTo(getItemViewState(position))
    }

    override fun getItemCount(): Int = items.size

    class ComicViewHolder(private val binding : ItemComicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item : ComicItemViewState){
            binding.viewState = item
        }
    }

}