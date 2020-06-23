package com.cnm.shw

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_frame_animation.*

class FrameAnimationActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)
        val ani = iv_animation_run.drawable as AnimationDrawable
        bt_animation_start.setOnClickListener {
            ani.start()
        }
        bt_animation_stop.setOnClickListener {
            ani.stop()
        }

    }
}