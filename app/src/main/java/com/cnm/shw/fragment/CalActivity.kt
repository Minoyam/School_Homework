package com.cnm.shw.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_cal.*


class CalActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)
        bt_fragment_plus.setOnClickListener {
            createFrag(PlusFragment())
        }
        bt_fragment_minus.setOnClickListener {
            createFrag(MinusFragment())
        }
        bt_fragment_remove.setOnClickListener {
            removeFrag()
        }
    }

    private fun removeFrag() {
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

    private fun createFrag(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_show, fragment).addToBackStack(null).commit()
    }
}
