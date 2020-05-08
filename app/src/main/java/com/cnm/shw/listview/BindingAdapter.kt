package com.cnm.shw.listview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("bind:bindSetItem")
fun RecyclerView.bindSetCategoryItem(items: List<String>) {
    if (adapter is MainAdapter2)
        items.let {
            (adapter as MainAdapter2).setItems(it)
        }
}


@BindingAdapter("bind:bindGridItem")
fun RecyclerView.bindGridItem(items: List<GridResponse>){

    if(adapter is GridAdapter)
        items.let {
            (adapter as GridAdapter).setItems(it)
        }
}

@BindingAdapter("bind:bindImage")
fun bindImage(imageView: ImageView, imageUri : String)
{
    imageUri.let {
        Glide.with(imageView.context).load(imageUri).override(200,200).into(imageView)
    }
}