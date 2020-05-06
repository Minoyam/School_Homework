package com.cnm.shw.clipboard

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_clipboard_1.*

class Clipboard1Activity : AppCompatActivity() {

    private lateinit var cm: ClipboardManager
    private lateinit var data: ClipData
    private lateinit var item: ClipData.Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clipboard_1)
        cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        bt_clip_copy.setOnClickListener {
            data = ClipData.newPlainText("mylabel", et_clip_text.text)
            cm.setPrimaryClip(data)
            Toast.makeText(this, "복사 성공", Toast.LENGTH_LONG).show()
        }
        bt_clip_paste.setOnClickListener {
            if (!cm.hasPrimaryClip())
                Toast.makeText(this, "Clipboard empty", Toast.LENGTH_LONG).show()
            if (cm.primaryClipDescription?.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN) == false)
                Toast.makeText(this, "type mismatch", Toast.LENGTH_LONG).show()
            data = cm.primaryClip!!
            item = data.getItemAt(0)
            et_clip_text.setText(item.text)
        }
        bt_clip_cut.setOnClickListener {
            data = ClipData.newPlainText("mylabel", et_clip_text.text)
            cm.setPrimaryClip(data)
            et_clip_text.setText("")
            Toast.makeText(this, "잘라내기 성공", Toast.LENGTH_LONG).show()
        }
    }
}
