package com.cnm.shw.layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cnm.shw.R
import kotlinx.android.synthetic.main.item_viewpager.view.*

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>()
{
    private val pageList = mutableListOf<Int>()
    fun setList(list : List<Int>)
    {
        pageList.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
            holder.bind(pageList[position])
    }

    inner class ViewPagerViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        fun bind(page : Int)
        {
          itemView.iv_viewpager_image.setImageResource(page)
        }
    }
}