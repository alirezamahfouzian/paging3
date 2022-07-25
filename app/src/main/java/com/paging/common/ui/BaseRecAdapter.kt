package com.paging.common.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecAdapter<BINDING : ViewDataBinding, T> :
    ListAdapter<T, BaseViewHolder<BINDING>>(DiffUtilsListAdapter<T>()) {

    private val _clickLiveData: MutableLiveData<T?> = MutableLiveData()
    val clickLiveData: LiveData<T?> get() = _clickLiveData

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun bind(binding: BINDING, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BINDING> {
        val binder = DataBindingUtil.inflate<BINDING>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return BaseViewHolder(binder)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BINDING>, position: Int) {
        val item = getItem(position)
        setOnClickListener(holder, item)
        bind(holder.binder, currentList[position])
    }

    private fun setOnClickListener(holder: BaseViewHolder<BINDING>, item: T) {
        holder.itemView.setOnClickListener {
            _clickLiveData.value = item
        }
    }

    override fun getItemCount(): Int = currentList.size
}

class BaseViewHolder<BINDING : ViewDataBinding>(val binder: BINDING) :
    RecyclerView.ViewHolder(binder.root)


