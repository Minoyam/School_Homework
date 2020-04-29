package com.cnm.shw.file

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_internal_storage.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class InternalStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)
        bt_read.setOnClickListener {
            try {
                val fileName = et_file_name.text.toString() + ".txt"
                var fileInputStream: FileInputStream? = null
                fileInputStream = openFileInput(fileName)
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    stringBuilder.append(text)
                }
                et_text.setText(stringBuilder.toString())
                showToast("파일 읽기 성공")
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
        }
        bt_write.setOnClickListener {
            val fileName = et_file_name.text.toString() + ".txt"
            val contents = et_text.text.toString()
            val fos: FileOutputStream
            try {
                fos = openFileOutput(fileName, Context.MODE_PRIVATE)
                fos.write(contents.toByteArray())
                fos.close()
                showToast("파일 쓰기 성공")
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
        }

    }

    private fun showToast(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }

}
