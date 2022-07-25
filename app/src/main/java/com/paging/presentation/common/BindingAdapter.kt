package com.paging.presentation.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.paging.common.ui.BaseRecAdapter

object BindingAdapter {

    @BindingAdapter("loadImageFromUrl")
    @JvmStatic
    fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
        imageView.load(imageUrl)
    }

    @BindingAdapter("submitList")
    @JvmStatic
    fun submitList(recyclerView: RecyclerView, list: List<Any>?) {
        val adapter = recyclerView.adapter as BaseRecAdapter<ViewDataBinding, Any>?
        adapter?.submitList(list ?: listOf())
    }

    @BindingAdapter("setAdapter")
    @JvmStatic
    fun setAdapter(
        recyclerView: RecyclerView,
        adapter: BaseRecAdapter<ViewDataBinding, Any>?
    ) {
        adapter?.let { recyclerView.adapter = it }
    }
}