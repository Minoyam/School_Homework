package com.cnm.shw

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_frame_animation.*

class FrameAnimationActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)
        val ani2 = AnimationUtils.loadAnimation(this,R.anim.rotate)
        bt_animation_start.setOnClickListener {
            iv_animation_run.startAnimation(ani2)
        }

    }
}