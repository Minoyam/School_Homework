package com.cnm.shw.parsing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_parsing.*
import org.jsoup.Jsoup

class ParsingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parsing)
        bt_parsing_move.setOnClickListener {
            if (et_parsing_url.text.isNotEmpty()) {
                Thread {
                    val document = Jsoup.connect(et_parsing_url.text.toString()).get()
                    runOnUiThread {
                        tv_parsing_html.text = document.toString()
                    }
                }.start()
            }
        }

    }
}
