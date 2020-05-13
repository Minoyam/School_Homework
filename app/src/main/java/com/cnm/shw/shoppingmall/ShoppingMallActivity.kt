package com.cnm.shw.shoppingmall

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_shopping_mall.*
import kotlinx.android.synthetic.main.item_recycler.*
import java.text.DecimalFormat

class ShoppingMallActivity : AppCompatActivity() {

    private val shoppingAdapter = ShoppingAdapter(::priceSum)
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

    fun priceSum(price: String) {
        val tv = tv_shopping_final_price.text.substring(0,tv_shopping_final_price.text.length-1)

        if (tv == "0")
            tv_shopping_final_price.text = makeCommaNumber(removeComma(price)) + "원"
        else {
            tv_shopping_final_price.text =
                makeCommaNumber(removeComma(tv) + removeComma(price)) + "원"
        }
    }

    private fun makeCommaNumber(input: Int): String {
        val formatter = DecimalFormat("###,###")
        return formatter.format(input)
    }
    private fun removeComma(price :String) : Int{
        var pr = ""
        price.forEach {
            if (it != ',')
                pr += it
        }
        return pr.toInt()
    }
}
