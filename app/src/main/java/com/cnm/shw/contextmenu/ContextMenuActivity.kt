package com.cnm.shw.contextmenu

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_context_menu.*

class ContextMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)
        registerForContextMenu(bt_color)
        registerForContextMenu(et_gender)
        registerForContextMenu(bt_ad)
        bt_clear.setOnClickListener {
            et_gender.setText("")
            et_ad.apply {
                setText("")
                visibility = View.GONE
            }
            bt_color.setBackgroundColor(Color.rgb(204, 206, 206))
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when (v) {
            et_gender -> menuInflater.inflate(R.menu.context_et_menu, menu)
            bt_color -> menuInflater.inflate(R.menu.context_menu, menu)
            bt_ad -> menuInflater.inflate(R.menu.context_bt_menu, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.red -> { color(Color.RED) }
            R.id.yellow -> { color(Color.YELLOW)}
            R.id.green -> { color(Color.GREEN) }
            R.id.m -> { gender("당신은 남성이군요") }
            R.id.w -> { gender("당신은 여성이군요") }
            R.id.se -> { ad("서울에 거주하시는군요") }
            R.id.seong -> { ad("성남에 거주하시는군요") }
            R.id.etc -> { ad("다른곳에 거주하시는군요") }
        }
        return super.onContextItemSelected(item)
    }

    private fun gender(text: String) = et_gender.setText(text)

    private fun color(color: Int) = bt_color.setBackgroundColor(color)

    private fun ad(text: String) {
        et_ad.visibility = View.VISIBLE
        et_ad.setText(text)
    }
}
