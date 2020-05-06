package com.cnm.shw.listview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    private val city = listOf("서울", "베이징", "도쿄", "뉴욕", "파리", "마드리드", "바르셀로나")
    private val mainAdapter = MainAdapter(::showToast)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        mainAdapter.setItem(city)
        rv_content.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@RecyclerActivity)
        }
    }
    private fun showToast(city : String) = Toast.makeText(this,"당신은 ${city}에 살고 계시는군요",Toast.LENGTH_LONG).show()
}
