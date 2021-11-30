package com.mustafafidan.marvel.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("adapter")
fun RecyclerView.setAdapter(adapter : RecyclerView.Adapter<*>?) {
    adapter.let { this.adapter = adapter }
}