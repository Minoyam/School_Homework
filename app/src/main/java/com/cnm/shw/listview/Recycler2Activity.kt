package com.cnm.shw.listview

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_recycler2.*

class Recycler2Activity : AppCompatActivity(){

    private val mainAdapter2 = MainAdapter2(::setEditText)
    val city = mutableListOf("서울", "뉴욕", "베이징", "도쿄")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler2)

        mainAdapter2.setItems(city)
        rv_content_2.apply {
            adapter = mainAdapter2
            layoutManager = LinearLayoutManager(this@Recycler2Activity)
        }
        bt_recycler2_append.setOnClickListener {
            if (textEmptyBoolean(et_recycler2_text.text.toString())) {
                mainAdapter2.setItem(et_recycler2_text.text.toString())
                et_recycler2_text.hideKeyboard()
            }
        }
        bt_recycler2_delete.setOnClickListener {
            if (textEmptyBoolean(et_recycler2_text.text.toString()))
                if(!mainAdapter2.deleteItem(et_recycler2_text.text.toString())) {
                    showToast("도시이름을 다시 확인해주세요.")
                    et_recycler2_text.hideKeyboard()
                }
        }
    }

    private fun textEmptyBoolean(text: String): Boolean {
        if (text.isNotEmpty()) {
            return true
        } else {
            showToast("도시 이름을 입력해주세요.")
        }
        return false
    }

    private fun setEditText(text: String) = et_recycler2_text.setText(text)
    private fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
