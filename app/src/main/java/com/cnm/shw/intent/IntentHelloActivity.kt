package com.cnm.shw.intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_intent_hello.*

class IntentHelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_hello)
        bt_intent_hello_exit.setOnClickListener {
            finish()
        }
    }
}
