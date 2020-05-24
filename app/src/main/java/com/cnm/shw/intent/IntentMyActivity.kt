package com.cnm.shw.intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_intent_my.*

class IntentMyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_my)

        bt_intent_my_exit.setOnClickListener {
            finish()
        }
    }
}
