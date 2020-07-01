package com.cnm.shw

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_frame_animation.*

class FrameAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)
        val translate = AnimationUtils.loadAnimation(this, R.anim.traslate).apply {
            duration = 500
        }
        val rotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
        val scale = AnimationUtils.loadAnimation(this, R.anim.scale).apply {
            duration = 500
        }
        val alpha = AnimationUtils.loadAnimation(this, R.anim.alpha).apply {
            duration = 500
        }
        val mix = AnimationUtils.loadAnimation(this, R.anim.mix).apply {
            duration = 1000
        }
        bt_animation_translate.setOnClickListener {
            iv_animation_run.startAnimation(translate)
        }
        bt_animation_rotate.setOnClickListener {
            iv_animation_run.startAnimation(rotate)
        }
        bt_animation_scale.setOnClickListener {
            iv_animation_run.startAnimation(scale)
        }
        bt_animation_alpha.setOnClickListener {
            iv_animation_run.startAnimation(alpha)
        }
        bt_animation_mix.setOnClickListener {
            iv_animation_run.startAnimation(mix)
        }
    }
}