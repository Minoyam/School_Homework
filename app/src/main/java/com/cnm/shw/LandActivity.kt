package com.cnm.shw

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LandActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_land)
        } else {
            setContentView(R.layout.activity_land2)
        }
    }
}
