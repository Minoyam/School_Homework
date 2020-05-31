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
        bt_fragment_mul.setOnClickListener {
            createFrag(MulFragment())
        }
        bt_fragment_div.setOnClickListener {
            createFrag(DivFragment())
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
        removeFrag()
        when (fragment) {
            is PlusFragment -> {
                fragmentTransaction.replace(R.id.fl_show_plus, fragment).addToBackStack(null)
                    .commit()
            }
            is MinusFragment -> {
                fragmentTransaction.replace(R.id.fl_show_minus, fragment).addToBackStack(null)
                    .commit()
            }
            is MulFragment -> {
                fragmentTransaction.replace(R.id.fl_show_mul, fragment).addToBackStack(null)
                    .commit()
            }
            is DivFragment -> {
                fragmentTransaction.replace(R.id.fl_show_div, fragment).addToBackStack(null)
                    .commit()
            }
        }
    }
}
