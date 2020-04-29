package com.cnm.shw.dialogbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_input_dialog_box.*


class InputDialogBoxActivity : AppCompatActivity(), ADialogFragment.InputListener {
    private val aDialogFragment = ADialogFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_dialog_box)
        bt_input_parent.setOnClickListener {
            aDialogFragment.apply {
                this.show(supportFragmentManager, aDialogFragment.tag)
            }
        }
    }

    override fun onPositiveClicked(papa: String, mama: String) {
        et_papa_name.setText(papa)
        et_mama_name.setText(mama)
    }


}
