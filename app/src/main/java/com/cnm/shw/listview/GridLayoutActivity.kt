package com.cnm.shw.listview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_grid_layout.*

class GridLayoutActivity : AppCompatActivity() {

    private val gridAdapter = GridAdapter()
    var item = GridResponse.values().toList()
    val items = mutableListOf<GridResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)
        for (i in 0..5)
        {
            items.addAll(item)
            item = item.shuffled()
        }
            gridAdapter.setItems(items)
        rv_grid_content.apply {
            adapter = gridAdapter
            layoutManager = GridLayoutManager(this@GridLayoutActivity, 5)
        }
    }
}
