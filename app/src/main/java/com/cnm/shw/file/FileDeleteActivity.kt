package com.cnm.shw.file

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_file_delete.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FileDeleteActivity : AppCompatActivity(), DirDialogFragment.InputListener {

    private lateinit var fn: Array<File>
    private val dirDialogFragment = DirDialogFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_delete)
        fn = ContextCompat.getExternalFilesDirs(applicationContext, null)
        bt_delete_resource_read.setOnClickListener {
            try {
                val inputStream = resources.openRawResource(R.raw.myname)
                val bt = ByteArray(inputStream.available())
                inputStream.read(bt)
                et_delete_text.setText(String(bt))
                inputStream.close()
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
        }
        bt_delete_write.setOnClickListener {
            val fileName = fn[0].absolutePath + "/${et_delete_name.text}.txt"
            val sout = FileOutputStream(fileName, true)
            sout.write(et_delete_text.text.toString().toByteArray())
            sout.close()
            showToast("$fileName 쓰기 성공")
        }
        bt_delete_read.setOnClickListener {
            try {
                val fileName = fn[0].absolutePath + "/${et_delete_name.text}.txt"
                val sin = FileInputStream(fileName)
                val bt = ByteArray(sin.available())
                sin.read(bt)
                et_delete_text.setText(String(bt))
                sin.close()
                showToast("파일 읽기 성공")

            } catch (e: Exception) {
                showToast(e.message.toString())

            }
        }
        bt_delete_delete.setOnClickListener {
            val fileName = fn[0].absolutePath + "/${et_delete_name.text}.txt"
            val file = File(fileName)
            file.delete()
            showToast("파일 삭제 성공")
        }
        bt_delete_directory.setOnClickListener {
            dirDialogFragment.apply {
                this.show(supportFragmentManager, dirDialogFragment.tag)
            }

        }
    }

    private fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

    override fun onPositiveClicked(dir: String) {
        val dirName = fn[0].absolutePath + "/$dir"
        File(dirName).mkdir()
        showToast("$dir 폴더 생성")
    }
}
