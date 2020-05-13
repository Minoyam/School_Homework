package com.cnm.shw.preference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_preference.*

class PreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        val viewModel = ViewModelProvider(this).get(PreferenceViewModel::class.java)
        viewModel.getNum().observe(this, Observer<List<Int>> { newNum ->
            tv_preference_text1.text = newNum[0].toString()
            tv_preference_text2.text = newNum[1].toString()
            tv_preference_text3.text = newNum[2].toString()
        })

        bt_preference_button1.setOnClickListener {
            tv_preference_text1.text = viewModel.updateNum(tv_preference_text1.text.toString().toInt()+1,1)
        }
        bt_preference_button2.setOnClickListener {
            tv_preference_text2.text = viewModel.updateNum(tv_preference_text2.text.toString().toInt()+1,2)
        }
        bt_preference_button3.setOnClickListener {
            tv_preference_text3.text = viewModel.updateNum(tv_preference_text3.text.toString().toInt()+1,3)

        }
    }
}
