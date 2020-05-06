package com.cnm.shw.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.cnm.shw.R
import kotlinx.android.synthetic.main.item_recycler.view.*

class MainAdapter(private val onClickAction: (String) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val cityItems = mutableListOf<String>()
    private var lastCheckRB: RadioButton? = null

    fun setItem(items: List<String>) {
        cityItems.clear()
        cityItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int = cityItems.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(cityItems[position])

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
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
            itemView.tv_recycler_text.text = item
        }
    }
}