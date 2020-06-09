package com.cnm.shw.layout

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_view_flipper.*

class ViewFlipperActivity : AppCompatActivity() {
    private var imageList = intArrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d)
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper)

        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
            viewFlipper.setInAnimation(applicationContext, android.R.anim.slide_in_left)
            viewFlipper.setOutAnimation(applicationContext, android.R.anim.slide_out_right)
        bt_view_flipper_1.setOnClickListener {
            if (index < 0)
                index = imageList.size - 1
            flipper(viewFlipper)
            viewFlipper.showPrevious()
            viewFlipper.stopFlipping()
                index--
        }
        bt_view_flipper_2.setOnClickListener {
            if (index == imageList.size)
                index = 0
            flipper(viewFlipper)
            viewFlipper.showNext()
            viewFlipper.stopFlipping()
                index++
        }
    }
        private fun flipper(viewFlipper: ViewFlipper) {
            val imageView = ImageView(this)
            val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(30, 30, 30, 30)
            layoutParams.gravity = Gravity.CENTER
            imageView.setImageResource(imageList[index])
            viewFlipper.addView(imageView)

        }
    }

