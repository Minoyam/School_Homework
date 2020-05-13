package com.cnm.shw

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cnm.shw.listview.GridAdapter
import com.cnm.shw.listview.GridResponse
import com.cnm.shw.listview.MainAdapter2
import com.cnm.shw.shoppingmall.ProductEnum
import com.cnm.shw.shoppingmall.ShoppingAdapter

@BindingAdapter("bind:bindSetItem")
fun RecyclerView.bindSetCategoryItem(items: List<String>) {
    if (adapter is MainAdapter2)
        items.let {
            (adapter as MainAdapter2).setItems(it)
        }
}

@BindingAdapter("bind:bindGridItem")
fun RecyclerView.bindGridItem(items: List<GridResponse>) {

    if (adapter is GridAdapter)
        items.let {
            (adapter as GridAdapter).setItems(it)
        }
}

@BindingAdapter("bind:bindShoppingItem")
fun RecyclerView.bindShoppingItem(items: List<ProductEnum>) {
    if (adapter is ShoppingAdapter)
        items.let {
            (adapter as ShoppingAdapter).setItem(it)
        }
}

@BindingAdapter("bind:bindImage")
fun bindImage(imageView: ImageView, imageUri: String) {
    imageUri.let {
        Glide.with(imageView.context).load(imageUri).override(200, 200).into(imageView)
    }
}

@BindingAdapter("bind:bindPrice")
fun bindPrice(editText: EditText, price: String){
    price.let {
        editText.setText("가격 = "+price)
    }
}