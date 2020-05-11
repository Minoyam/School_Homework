package com.cnm.shw.shoppingmall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_shopping_mall.*

class ShoppingMallActivity : AppCompatActivity() {

    private val shoppingAdapter = ShoppingAdapter()
    val items = ProductEnum.values().toList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_mall)

        shoppingAdapter.setItem(items)
        rv_shopping_content.apply {
            adapter = shoppingAdapter
            layoutManager = LinearLayoutManager(this@ShoppingMallActivity)
        }
    }
}
