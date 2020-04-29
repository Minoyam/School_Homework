package com.cnm.shw.dialogbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_dialog_box.*

class DialogBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_box)
        bt_basic_dialog.setOnClickListener { makeDialog(basic_title, basic_message, false) }

        bt_select_dialog.setOnClickListener { makeDialog(select_title, select_message, true) }

        bt_homework_dialog.setOnClickListener { makeDialog(basic_title, homework_message, false) }
    }

    private fun makeDialog(title: String, message: String, alertBoolean: Boolean) {
        val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.Theme_AppCompat_Light_Dialog_Alert))
        builder.apply {
            setTitle(title)
            setMessage(message)
            if (alertBoolean) { select() }
            show()
        }
    }

    private fun AlertDialog.Builder.select() {
        setPositiveButton(positvie_text) { _, _ ->
            Toast.makeText(this@DialogBoxActivity, positvie_message, Toast.LENGTH_LONG).show()
        }
        setNegativeButton(negative_text) { _, _ ->
            Toast.makeText(this@DialogBoxActivity, negative_message, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val basic_title = "나의 소개"
        const val basic_message = "내 이름은 김민호입니다."
        const val select_title = "성별 선택"
        const val select_message = "당신은 남자입니까?"
        const val homework_message = "내 이름은 김민호이고,\n서울시에 살고 있어요."
        const val positvie_text = "예"
        const val positvie_message = "당신은 남자이군요."
        const val negative_text = "아니요"
        const val negative_message= "당신은 여자이군요"
    }
}
