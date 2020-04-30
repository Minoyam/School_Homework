package com.cnm.shw.file

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.cnm.shw.R
import kotlinx.android.synthetic.main.dialog_dir.view.*

class DirDialogFragment : DialogFragment(){
    private lateinit var listener: InputListener
    interface InputListener {
        fun onPositiveClicked(dir: String)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.listener = context as InputListener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val mBuilder = AlertDialog.Builder(it)
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.dialog_dir, null)
            mBuilder.setView(view)
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle("폴더 이름 입력")
                .setPositiveButton("확인") { _, _ ->
                    listener.onPositiveClicked(view.et_dir_name.text.toString())
                }
                .setNegativeButton("취소", null)
                .create()
        } ?: throw IllegalStateException("Activity is null")


    }

}
