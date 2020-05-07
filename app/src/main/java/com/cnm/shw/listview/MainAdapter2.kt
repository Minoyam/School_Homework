package com.cnm.shw.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cnm.shw.R
import com.cnm.shw.databinding.ItemRecyclerBinding
import kotlinx.android.synthetic.main.item_recycler.view.*

class MainAdapter2(private val onClickAction: (String) -> Unit) :
    RecyclerView.Adapter<MainAdapter2.Main2ViewHolder>() {
    private val cityItems = mutableListOf<String>()
    private var lastCheckRB: RadioButton? = null

    fun setItems(items: List<String>) {
        cityItems.addAll(items)
        notifyDataSetChanged()
    }

    fun setItem(item: String) {
        cityItems.add(item)
        notifyDataSetChanged()
    }

    fun deleteItem(item: String): Boolean {
        return if (cityItems.contains(item)) {
            cityItems.remove(item)
            notifyDataSetChanged()
            true
        } else
            false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main2ViewHolder {
        val binding = DataBindingUtil.inflate<ItemRecyclerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_recycler,
            parent,
            false
        )

        return Main2ViewHolder(binding)
    }

    override fun getItemCount(): Int = cityItems.size

    override fun onBindViewHolder(holder: Main2ViewHolder, position: Int) =
        holder.bind(cityItems[position])

    inner class Main2ViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val item = cityItems[adapterPosition]
                onClickAction(item)
                itemView.rb_checked.isChecked = !itemView.rb_checked.isChecked
                if (lastCheckRB != null) {
                    lastCheckRB!!.isChecked = false
                }
                lastCheckRB = itemView.rb_checked
            }
        }

        fun bind(item: String) {
            binding.items = item
        }
    }
}