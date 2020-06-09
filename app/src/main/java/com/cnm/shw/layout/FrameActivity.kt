package com.cnm.shw.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_frame.*

class FrameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        bt_frame_1.setOnClickListener {
            cv_frame_1.visibility = View.VISIBLE
            iv_frame_1.visibility = View.GONE
            ll_frame_1.visibility = View.GONE
        }
        bt_frame_2.setOnClickListener {
            cv_frame_1.visibility = View.GONE
            iv_frame_1.visibility = View.VISIBLE
            ll_frame_1.visibility = View.GONE
            iv_frame_1.setImageResource(R.drawable.b)
        }
        bt_frame_3.setOnClickListener {
            cv_frame_1.visibility = View.GONE
            iv_frame_1.visibility = View.GONE
            ll_frame_1.visibility = View.VISIBLE
        }
        bt_frame_4.setOnClickListener {
            cv_frame_1.visibility = View.GONE
            iv_frame_1.visibility = View.VISIBLE
            ll_frame_1.visibility = View.GONE
            iv_frame_1.setImageResource(R.drawable.c)
        }
    }
}
