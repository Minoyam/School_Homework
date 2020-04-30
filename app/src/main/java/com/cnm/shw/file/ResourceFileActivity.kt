package com.cnm.shw.file

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_resource_file.*
import kotlinx.android.synthetic.main.activity_sd_card_storage.*

class ResourceFileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource_file)

        bt_resource_read.setOnClickListener {
            try {
                val inputStream = resources.openRawResource(R.raw.myname)
                val bt = ByteArray(inputStream.available())
                inputStream.read(bt)
                et_resource_text.setText(String(bt))
                inputStream.close()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
