package com.cnm.shw.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cnm.shw.R
import com.cnm.shw.databinding.ActivityDrawBinding
import kotlinx.android.synthetic.main.activity_draw.*


class DrawActivity : AppCompatActivity() {
    var startX = 0.0f
    var startY = 0.0f
    var endX = 0.0f
    var endY = 0.0f
    var drawcolor = 0
    private lateinit var myView: MyView
    private val p = Paint()
    private var selectFigure: Int = 0
    private lateinit var binding: ActivityDrawBinding
    private val list = mutableListOf<DrawData.Body>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_draw)
        binding.ac = this
        myView = MyView(this)
        cl_layout.addView(myView)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_MOVE ->{
                endX = event.x
                endY = event.y
                myView.invalidate()
            }
            MotionEvent.ACTION_UP ->{
                endX = event.x
                endY = event.y
                list.add(DrawData.Body(startX, startY, endX, endY,selectFigure,p.color))
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
            R.id.im_draw_blue -> drawColor(Color.BLUE)
            R.id.im_draw_green -> drawColor(Color.GREEN)
            R.id.im_draw_red -> drawColor(Color.RED)
            R.id.im_draw_gray -> drawColor(Color.GRAY)
            R.id.im_draw_black -> drawColor(Color.BLACK)
            R.id.im_draw_yellow -> drawColor(Color.YELLOW)
            R.id.im_rectangle -> selectFigure = 0
            R.id.im_circle -> selectFigure = 2
            R.id.im_line -> selectFigure = 1
        }
        return super.onOptionsItemSelected(item)
    }

    inner class MyView(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            if(list.isNotEmpty()){
                list.forEach {
                    p.color = it.color
                    when (it.select) {
                        0 -> canvas?.drawRect(it.startX, it.startY, it.endX, it.endY, p)
                        1 -> canvas?.drawLine(it.startX, it.startY, it.endX, it.endY, p)
                        2 -> canvas?.drawCircle(it.startX, it.startY, 100F, p)
                    }
                }
            }
            p.color = drawcolor
            when (selectFigure) {
                0 -> canvas?.drawRect(startX, startY, endX, endY, p)
                1 -> canvas?.drawLine(startX, startY, endX, endY, p)
                2 -> canvas?.drawCircle(startX, startY, 100F, p)
            }
        }
    }

    fun drawColor(color: Int) {
        drawcolor = when (color) {
            1 -> resources.getColor(R.color.colorOrange)
            2 -> resources.getColor(R.color.colorBrown)
            3 -> resources.getColor(R.color.colorPink)
            4 -> resources.getColor(R.color.colorSky)
            5 -> resources.getColor(R.color.colorPurple)
            else -> color
        }
    }

    fun drawFill(boolean: Boolean) {
        if (boolean)
            p.style = Paint.Style.FILL
        else
            p.style = Paint.Style.STROKE
    }
}




