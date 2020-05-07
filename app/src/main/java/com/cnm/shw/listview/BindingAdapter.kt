package com.cnm.shw.listview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("bind:bindSetItem")
fun RecyclerView.bindSetCategoryItem(items: List<String>) {
    if (adapter is MainAdapter2)
        items.let {
            (adapter as MainAdapter2).setItems(it)
        }
}
