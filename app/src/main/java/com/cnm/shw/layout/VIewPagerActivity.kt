package com.cnm.shw.layout

import android.os.Bundle
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.cnm.shw.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_viewpager.*

class VIewPagerActivity : AppCompatActivity() {
    private val viewPagerAdapter = ViewPagerAdapter()
    private val tabLayoutTextArray = arrayOf("사진1","사진2","사진3","사진4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        viewPagerAdapter.setList(listOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d))
        vp_pager.adapter = viewPagerAdapter
        vp_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(tl_tab,vp_pager){tab, position ->
            tab.text = tabLayoutTextArray[position]
        }.attach()
    }
}
