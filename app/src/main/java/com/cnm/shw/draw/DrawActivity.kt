package com.cnm.shw.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    private val p = Paint()
    private var selectFigure: Int = 0

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
            MotionEvent.ACTION_UP, MotionEvent.ACTION_MOVE -> {
                endX = event.x
                endY = event.y
                myView.invalidate()
            }
        }
        return true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.im_draw_blue -> p.color = Color.BLUE
            R.id.im_draw_green -> p.color = Color.GREEN
            R.id.im_draw_red -> p.color = Color.RED
            R.id.im_draw_gray -> p.color = Color.GRAY
            R.id.im_draw_black -> p.color = Color.BLACK
            R.id.im_draw_yellow -> p.color = Color.YELLOW
            R.id.im_rectangle -> selectFigure = 0
            R.id.im_circle -> selectFigure = 2
            R.id.im_line -> selectFigure = 1
        }
        return super.onOptionsItemSelected(item)
    }

    inner class MyView(context: Context) : View(context) {
        private val s = Paint()
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            s.color = Color.BLUE
            s.textSize = 30f
            when (selectFigure) {
                0 -> canvas?.drawRect(startX, startY, endX, endY, p)
                1 -> canvas?.drawLine(startX, startY, endX, endY, p)
                2 -> canvas?.drawCircle(startX, startY,100F,p)

            }
            var string: String = ""
            string = "startX = $startX  startY = $startY   endX = $endX   endY = $endY"
            canvas?.drawText(string, 10F, 1500F, s)


        }
    }
}




