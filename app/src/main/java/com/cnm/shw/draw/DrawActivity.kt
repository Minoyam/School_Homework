package com.cnm.shw.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_draw.*


class DrawActivity : AppCompatActivity() {
    var startX = 0.0f
    var startY = 0.0f
    var endX = 0.0f
    var endY = 0.0f
    lateinit var myView: MyView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
        myView = MyView(this)
        cl_layout.addView(myView)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_UP,MotionEvent.ACTION_MOVE -> {
                endX = event.x
                endY = event.y
                myView.invalidate()
            }
        }
        return true

    }

    inner class MyView(context: Context) : View(context) {
        private val p = Paint()
        private val s = Paint()
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            p.color = Color.YELLOW
            s.color = Color.BLUE
            s.textSize = 30f
            canvas?.drawRect(startX, startY, endX, endY, p)
            var string: String = ""
            string = "startX = $startX  startY = $startY   endX = $endX   endY = $endY"
                canvas?.drawText(string, 10F, 1500F, s)


        }
    }
}




