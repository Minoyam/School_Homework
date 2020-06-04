package com.cnm.shw.parsing

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_parsing.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream
import java.io.StringReader

class ParsingActivity : AppCompatActivity() {


    private var r: String = ""
    private var s : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parsing)

        bt_parsing_run.setOnClickListener {
            try {
                val parser: XmlPullParser
                val fact: XmlPullParserFactory = XmlPullParserFactory.newInstance()
                parser = fact.newPullParser()
                val inputStream : InputStream = resources.openRawResource(R.raw.info)
                val byteArray = ByteArray(inputStream.available())
                inputStream.read(byteArray)
                s = String(byteArray)
                parser.setInput(StringReader(s))
                tv_parsing_text.text = s

                var type = parser.eventType
                var bName = false
                var bAge = false
                var bTel = false
                var tag: String
                while (type != XmlPullParser.END_DOCUMENT) {
                    when (type) {
                        XmlPullParser.START_TAG -> {
                            tag = parser.name
                            if (tag == "name") {
                                bName = true
                            } else if (tag == "age") {
                                bAge = true
                            }else if (tag == "tel") {
                                bTel = true
                            }
                        }
                        XmlPullParser.TEXT -> {
                            when {
                                bName -> {
                                    r += "이름: " + parser.text
                                    bName = false
                                }
                                bAge -> {
                                    r += "나이: " + parser.text
                                    bAge = false
                                }
                                bTel -> {
                                    r += "전화번호: " + parser.text +"\n"
                                    bTel = false
                                }
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
