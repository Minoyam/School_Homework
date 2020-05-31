package com.cnm.shw.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.cnm.shw.R
import kotlinx.android.synthetic.main.fragment_plus_cal.*

class MulFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mul_cal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_fragment_result.setOnClickListener {
            if (et_fragment_num1.text.isNotEmpty() && et_fragment_num2.text.isNotEmpty()) {
                val num1 = et_fragment_num1.text.toString().toInt()
                val num2 = et_fragment_num2.text.toString().toInt()
                tv_fragment_result.text = "곱하기: " + (num1 * num2).toString()
            }
            et_fragment_num2.hideKeyboard()
        }

    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}