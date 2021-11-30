package com.mustafafidan.marvel.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mustafafidan.marvel.databinding.ItemCharacterBinding
import com.mustafafidan.marvel.model.local.CharacterUiModel

class CharactersAdapter : PagingDataAdapter<CharacterUiModel, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<CharacterUiModel>() {
            override fun areItemsTheSame(oldItem: CharacterUiModel, newItem: CharacterUiModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CharacterUiModel, newItem: CharacterUiModel): Boolean =
                oldItem.id == newItem.id
        }
    }

    private fun getItemViewState(position: Int) : CharacterItemViewState {
        return CharacterItemViewState(getItem(position)!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CharactersViewHolder)?.bind(item = getItemViewState(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharactersViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    class CharactersViewHolder(private val binding : ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterItemViewState?) {
            binding.viewState = item
        }

    }


}
