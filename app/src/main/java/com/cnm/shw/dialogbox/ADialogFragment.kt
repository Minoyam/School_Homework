package com.cnm.shw.dialogbox

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.cnm.shw.R
import kotlinx.android.synthetic.main.dialog_custom.view.*

class ADialogFragment : DialogFragment(){
    private lateinit var listener: InputListener
    interface InputListener {
        fun onPositiveClicked(papa: String, mama: String)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.listener = context as InputListener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val mBuilder = AlertDialog.Builder(it)
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.dialog_custom, null)
            mBuilder.setView(view)
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle("부모님 성함 입력")
                .setPositiveButton("확인") { _, _ ->
                    listener.onPositiveClicked(
                        view.et_input_papa.text.toString(),
                        view.et_input_mama.text.toString()
                    )
                }
                .setNegativeButton("취소", null)
                .create()
        } ?: throw IllegalStateException("Activity is null")


    }

}
