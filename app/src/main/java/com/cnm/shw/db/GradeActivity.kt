package com.cnm.shw.db

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_grade.*

class GradeActivity : AppCompatActivity() {

    private var gradeDb: GradeDatabase? = null
    private var studentDb: StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)
        gradeDb = GradeDatabase.getInstance(this)
        studentDb = StudentDatabase.getInstance(this)

        bt_grade_submit.setOnClickListener {
            submit()
            bt_grade_submit.hideKeyboard()
        }
        bt_grade_show.setOnClickListener {
            allShow()
            bt_grade_show.hideKeyboard()
        }
        bt_grade_cal.setOnClickListener {
            cal("계산 완료")
            bt_grade_cal.hideKeyboard()
        }
        bt_grade_delete.setOnClickListener {
            delete()
            bt_grade_delete.hideKeyboard()
        }
        bt_grade_one.setOnClickListener {
            oneShow()
            bt_grade_one.hideKeyboard()
        }
        bt_grade_update.setOnClickListener {
                submit()
                cal("수정 완료")
            bt_grade_update.hideKeyboard()
        }
        bt_student_submit.setOnClickListener {
            val num = et_student_num.text.toString()
            val name = et_student_name.text.toString()
            val age = et_student_age.text.toString()
            val sex = et_student_sex.text.toString()
            val r = Runnable {
                studentDb?.studentDao()?.insert(StudentEntity(num, name, age, sex))

            }
            val thread = Thread(r)
            thread.start()
            tv_grade_text.text = "insert into score values($num, $name, $age, $sex)"
            it.hideKeyboard()
        }
        bt_student_show.setOnClickListener {
            val r = Runnable {
                val list = studentDb?.studentDao()?.getAll()
                var text = ""
                list?.forEach {
                    text += "${it.num} ${it.name} ${it.age} ${it.sex}\n"
                }
                runOnUiThread {
                    tv_grade_text.text = text
                }
            }
            val thread = Thread(r)
            thread.start()
            it.hideKeyboard()
        }
    }

    private fun delete() {
        val r = Runnable {
            gradeDb?.gradeDao()?.delete(et_grade_num.text.toString())
        }
        runOnUiThread {
            tv_grade_text.text = et_grade_num.text.toString() + " 삭제 완료"
        }
        val thread = Thread(r)
        thread.start()
    }

    private fun oneShow() {
        val r = Runnable {
            val one = gradeDb?.gradeDao()?.getOne(et_grade_num.text.toString())
            runOnUiThread {
                tv_grade_text.text =
                    "${one?.num} ${one?.kor} ${one?.eng} ${one?.math} ${one?.total} ${one?.avg}"
            }
        }
        val thread = Thread(r)
        thread.start()
    }

    private fun cal(string: String) {
        val r = Runnable {
            val list = gradeDb?.gradeDao()?.getAll()
            list?.forEach {
                it.total = (it.kor.toInt() + it.eng.toInt() + it.math.toInt()).toString()
                it.avg = (it.total.toFloat() / 3f).toString()
                gradeDb?.gradeDao()?.insert(it)
            }
        }
        val thread = Thread(r)
        thread.start()
        tv_grade_text.text = string
    }

    private fun submit() {
        val num = et_grade_num.text.toString()
        val kor = et_grade_kor.text.toString()
        val eng = et_grade_eng.text.toString()
        val math = et_grade_math.text.toString()
        val r = Runnable {
            gradeDb?.gradeDao()?.insert(GradeEntity(num, kor, eng, math))

        }
        val thread = Thread(r)
        thread.start()
        tv_grade_text.text = "insert into score values($num, $kor, $eng, $math)"
    }

    private fun allShow() {
        val r = Runnable {
            val list = gradeDb?.gradeDao()?.getAll()
            var text = ""
            list?.forEach {
                text += "${it.num} ${it.kor} ${it.eng} ${it.math} ${it.total} ${it.avg}\n"
            }
            runOnUiThread {
                tv_grade_text.text = text
            }
        }
        val thread = Thread(r)
        thread.start()
    }
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
