package com.cnm.shw.menubar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        with(et_name) {
            when (item.itemId) {
                R.id.im_blue -> {
                    this.setBackgroundColor(android.graphics.Color.BLUE)
                }
                R.id.im_green -> {
                    this.setBackgroundColor(android.graphics.Color.GREEN)
                }
                R.id.im_red -> {
                    this.setBackgroundColor(android.graphics.Color.RED)
                }
                R.id.im_dark_gray -> {
                    this.setBackgroundColor(android.graphics.Color.DKGRAY)
                }
                R.id.im_normal_gray -> {
                    this.setBackgroundColor(android.graphics.Color.GRAY)
                }
                R.id.im_light_gray -> {
                    this.setBackgroundColor(android.graphics.Color.LTGRAY)
                }
                R.id.im_white -> {
                    this.setBackgroundColor(android.graphics.Color.rgb(255, 148, 0))
                }
                R.id.im_black -> {
                    this.setBackgroundColor(android.graphics.Color.rgb(0, 225, 255))
                }
                R.id.im_yellow -> {
                    this.setBackgroundColor(android.graphics.Color.rgb(118, 0, 145))
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}