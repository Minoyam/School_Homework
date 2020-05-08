package com.cnm.shw.listview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cnm.shw.R
import com.cnm.shw.databinding.ItemGridBinding

class GridAdapter : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {
    private val imgItems = mutableListOf<GridResponse>()

    fun setItems(items : List<GridResponse>)
    {
        imgItems.clear()
        imgItems.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = DataBindingUtil.inflate<ItemGridBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_grid, parent, false
        )
        return GridViewHolder(binding)
    }

    override fun getItemCount(): Int = imgItems.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(imgItems[position].img)

    }

    inner class GridViewHolder(private val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.item = item
        }
    }
}