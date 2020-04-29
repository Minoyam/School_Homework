package com.cnm.shw.file

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_sd_card_storage.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class SdCardStorageActivity : AppCompatActivity() {

        lateinit var fn: Array<File>
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sd_card_storage)
            bt_sd_path.setOnClickListener {
                fn = ContextCompat.getExternalFilesDirs(applicationContext, null)
                Toast.makeText(this, fn[0].absolutePath, Toast.LENGTH_LONG).show()
            }
            bt_sd_write.setOnClickListener {
                val fileName = fn[0].absolutePath + "/${et_sd_name.text}.txt"
                val sout = FileOutputStream(fileName, true)
                sout.write(et_sd_text.text.toString().toByteArray())
                sout.close()
                Toast.makeText(this, "$fileName 쓰기 성공", Toast.LENGTH_LONG).show()
            }
            bt_sd_read.setOnClickListener {
                try {
                    val fileName = fn[0].absolutePath + "/${et_sd_name.text}.txt"
                    val sin = FileInputStream(fileName)
                    val bt = ByteArray(sin.available())
                    sin.read(bt)
                    et_sd_text.setText(String(bt))
                    sin.close()
                    Toast.makeText(this, "파일 읽기 성공", Toast.LENGTH_LONG).show()

                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

