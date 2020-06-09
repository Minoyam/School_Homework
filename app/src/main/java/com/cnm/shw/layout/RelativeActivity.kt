package com.cnm.shw.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_relative.*

class RelativeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)

        bt_relative_1.setOnClickListener {
                iv_relative_1.setImageResource(R.drawable.a)
        }
        bt_relative_2.setOnClickListener {
            iv_relative_1.setImageResource(R.drawable.b)
        }
        bt_relative_3.setOnClickListener {
            iv_relative_1.setImageResource(R.drawable.c)
        }
        bt_relative_4.setOnClickListener {
            iv_relative_1.setImageResource(R.drawable.d)
        }

    }
}
