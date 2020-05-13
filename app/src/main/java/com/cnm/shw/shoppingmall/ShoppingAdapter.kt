package com.cnm.shw.shoppingmall

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cnm.shw.R
import com.cnm.shw.databinding.ItemShoppingBinding

class ShoppingAdapter(private val onClickAction: (String) -> Unit) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {
    private val shopItems = mutableListOf<ProductEnum>()
    fun setItem(items : List<ProductEnum>){
        shopItems.clear()
        shopItems.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding = DataBindingUtil.inflate<ItemShoppingBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_shopping, parent, false
        )
        return ShoppingViewHolder(binding)
    }

    override fun getItemCount(): Int = shopItems.size

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.bind(shopItems[position])
    }

    inner class ShoppingViewHolder(private val binding: ItemShoppingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btShoppingBuy.setOnClickListener {
             val item = shopItems[adapterPosition].price
                onClickAction(item)
            }
        }
        fun bind(item : ProductEnum){
            binding.item = item
        }
    }
}