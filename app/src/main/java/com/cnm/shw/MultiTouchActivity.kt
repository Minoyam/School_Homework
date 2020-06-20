package com.cnm.shw

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_multi_touch.*

class MultiTouchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_touch)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val act = event?.action?.and(0xff)
        val index = event?.action?.and(0xff00)?.shr(8)
        var id: Int?
        when (act) {

            MotionEvent.ACTION_DOWN -> {
                id = index?.let { event.getPointerId(it) }
                val s = String.format("DOWN id=%d index=%d x=%4.0f y=%4.0f",
                    id,
                    index,
                    index?.let { event.getX(it) },
                    index?.let { event.getY(it) })
                tv_multi_text.text = s
                Log.e("DOWN",s)
            }
            MotionEvent.ACTION_UP -> {
                id = index?.let { event.getPointerId(it) }
                val s = String.format("UP id=%d index=%d x=%4.0f y=%4.0f",
                    id,
                    index,
                    index?.let { event.getX(it) },
                    index?.let { event.getY(it) })
                tv_multi_text.text = s
                Log.e("UP",s)
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                id = index?.let { event.getPointerId(it) }
                val s = String.format("POINTER DOWN id=%d index=%d x=%4.0f y=%4.0f",
                    id,
                    index,
                    index?.let { event.getX(it) },
                    index?.let { event.getY(it) })
                tv_multi_text.text = s
                Log.e("POINTER_DOWN",s)
            }
            MotionEvent.ACTION_POINTER_UP -> {
                id = index?.let { event.getPointerId(it) }
                val s = String.format("POINTER UP id=%d index=%d x=%4.0f y=%4.0f",
                    id,
                    index,
                    index?.let { event.getX(it) },
                    index?.let { event.getY(it) })
                tv_multi_text.text = s
                Log.e("POINTER_UP",s)
            }
        }
        return super.onTouchEvent(event)
    }
}
