package com.cnm.shw.fragment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
        bt_fragment_mul.setOnClickListener {
            createFrag(MulFragment())
        }
        bt_fragment_plus_remove.setOnClickListener {
            removeFrag(1)
        }
        bt_fragment_mul_remove.setOnClickListener {
            removeFrag(2)
        }
        bt_fragment_plus_toggle.setOnClickListener {
            createPopup(1)
        }
        bt_fragment_mul_toggle.setOnClickListener {
            createPopup(2)
        }
    }

    private fun createPopup(index: Int) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_cal, null)
        val builder = AlertDialog.Builder(this).setTitle("toggle 선택").create()

        val tvPlus = dialogView.findViewById<TextView>(R.id.tv_dialog_plus)
        val tvMul = dialogView.findViewById<TextView>(R.id.tv_dialog_mul)

        tvPlus.setOnClickListener {
            if (index == 1) {
                removeFrag(1)
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fl_show_plus, PlusFragment()).addToBackStack(null)
                    .commit()
            }
            else{
                removeFrag(2)
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fl_show_mul, PlusFragment()).addToBackStack(null)
                    .commit()
            }
            builder.dismiss()
        }
        tvMul.setOnClickListener {
            if (index == 1) {
                removeFrag(1)
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fl_show_plus, MulFragment()).addToBackStack(null)
                    .commit()
            }
            else{
                removeFrag(2)
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fl_show_mul, MulFragment()).addToBackStack(null)
                    .commit()
            }
            builder.dismiss()
        }
        builder.setView(dialogView)
        builder.show()
    }

    private fun removeFrag(index: Int) {
        for (fragment in supportFragmentManager.fragments) {
            if (index == 1 && fragment is PlusFragment) {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            } else if (index == 2 && fragment is MulFragment)
                supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

    private fun createFrag(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (fragment) {
            is PlusFragment -> {
                fragmentTransaction.replace(R.id.fl_show_plus, fragment).addToBackStack(null)
                    .commit()
            }
            is MulFragment -> {
                fragmentTransaction.replace(R.id.fl_show_mul, fragment).addToBackStack(null)
                    .commit()
            }
        }
    }
}
