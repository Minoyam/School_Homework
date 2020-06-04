package com.cnm.shw.parsing

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_parsing.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader

class ParsingActivity : AppCompatActivity() {

    private val s: String = "<?xml version=\"1.0\" encoding=\"utf-8\"?> \n" +
            "<students>\n" +
            "<student>\n" +
            "<name>홍길동</name> <age>34</age> <sex>남성</sex>\n" +
            "</student>\n" +
            "<student>\n" +
            "<name>유관순</name> <age>18</age> <sex>여성</sex>\n" +
            "</student>\n" +
            "<student>\n" +
            "<name>김민호</name> <age>27</age> <sex>남성</sex>\n" +
            "</student>\n" +
            "</students>\n"
    private var r: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parsing)
        tv_parsing_text.text = s
        bt_parsing_run.setOnClickListener {
            try {
                val parser: XmlPullParser
                val fact: XmlPullParserFactory = XmlPullParserFactory.newInstance()
                parser = fact.newPullParser()
                parser.setInput(StringReader(s))
                var type = parser.eventType
                var bName = false
                var bAge = false
                var tag: String
                while (type != XmlPullParser.END_DOCUMENT) {
                    when (type) {
                        XmlPullParser.START_TAG -> {
                            tag = parser.name
                            if (tag == "name") {
                                bName = true
                            } else if (tag == "age") {
                                bAge = true
                            }
                        }
                        XmlPullParser.TEXT -> {
                            if (bName) {
                                r += "이름: " + parser.text
                                bName = false
                            } else if (bAge) {
                                r += "나이: " + parser.text
                                bAge = false
                            }
                        }
                    }
                    type = parser.next()
                }
                tv_parsing_text2.text = r
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }
//    Thread {
//        val document = Jsoup.connect(s).get()
//        runOnUiThread {
//            tv_parsing_text.text = document.toString()
//        }
//    }.start()
}
