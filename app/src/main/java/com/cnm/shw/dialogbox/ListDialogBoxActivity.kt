package com.cnm.shw.dialogbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_list_dialog_box.*

class ListDialogBoxActivity : AppCompatActivity() {
    private val item = arrayOf("LG U+", "SKT", "KT", "기타")
    private val item1 = arrayOf("서울시", "성남시", "광주시", "용인시", "수원시", "하남시", "남양주시", "기타")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_dialog_box)
        bt_list_dialog.setOnClickListener { makeDialog(BASIC_TITLE, item, TOAST_TEXT) }

        bt_radio_dialog.setOnClickListener { makeRadioDialog(BASIC_TITLE, item, TOAST_TEXT) }

        bt_homework_dialog2.setOnClickListener { makeRadioDialog(SELECT_TITLE, item1, TOAST_TEXT2) }
    }
    private fun makeDialog(title: String, item: Array<String>,text: String) {
        val builder = AlertDialog.Builder(
            ContextThemeWrapper(
                this,
                R.style.Theme_AppCompat_Light_Dialog_Alert
            )
        )
        builder.apply {
            setTitle(title)
            setItems(item) { _, which ->
                showToast(which, item,text)
            }
            show()
        }
    }

    private fun makeRadioDialog(title: String, item: Array<String>,text: String) {
        val builder = AlertDialog.Builder(
            ContextThemeWrapper(
                this,
                R.style.Theme_AppCompat_Light_Dialog_Alert
            )
        )
        builder.apply {
            setTitle(title)
            setSingleChoiceItems(
                item, 0
            ) { _, which ->
                showToast(which, item,text)
            }
            setPositiveButton("확인", null)
            show()
        }
    }

    private fun showToast(which: Int, item: Array<String>, text: String) {
        Toast.makeText(
            this@ListDialogBoxActivity,
            "번호=" + which + "당신은 " + item[which] + text,
            Toast.LENGTH_LONG
        ).show()
    }

    companion object {
        const val BASIC_TITLE = "통신사 선택"
        const val SELECT_TITLE = "살고 있는 도시 선택"
        const val TOAST_TEXT = "통신사 이용하시네요."
        const val TOAST_TEXT2 = "에 살고시는군요."
    }
}
