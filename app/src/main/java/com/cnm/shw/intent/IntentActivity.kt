package com.cnm.shw.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        bt_intent_hello_start.setOnClickListener {
            val intent = Intent(this, IntentHelloActivity::class.java)
            startActivity(intent)
        }
        bt_intent_start.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse(et_intent_text.text.toString())
            startActivity(intent)
        }
        bt_intent_my_start.setOnClickListener {
            val intent = Intent(this,IntentMyActivity::class.java)
            startActivity(intent)
        }
    }
}
