package com.cnm.shw.clipboard

import android.content.*
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_clipboard_intent.*
import java.util.*

class ClipboardIntentActivity : AppCompatActivity() {

    lateinit var cm: ClipboardManager
    lateinit var data: ClipData
    lateinit var item: ClipData.Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clipboard_intent)

        cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager


        bt_clip_intent_copy.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse(et_clip_intent_text.text.toString())
            data = ClipData.newIntent("label",intent)
            cm.setPrimaryClip(data)
            Toast.makeText(this,"intent copied",Toast.LENGTH_LONG).show()
        }

        bt_clip_intent_paste.setOnClickListener {
            if(!cm.hasPrimaryClip())
                Toast.makeText(this,"clipboard empty",Toast.LENGTH_LONG).show()
            else if(cm.primaryClipDescription!!.hasMimeType(ClipDescription.MIMETYPE_TEXT_INTENT))
                Toast.makeText(this,"type miss",Toast.LENGTH_LONG).show()

            data = cm.primaryClip!!
            item = data.getItemAt(0)
            startActivity(item.intent)
        }

    }
}
