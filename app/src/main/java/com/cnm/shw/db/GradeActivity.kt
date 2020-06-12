package com.cnm.shw.db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_grade.*

class GradeActivity : AppCompatActivity() {

    private var gradeDb: GradeDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)
        gradeDb = GradeDatabase.getInstance(this)

        bt_grade_submit.setOnClickListener {
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
        bt_grade_show.setOnClickListener {
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
        bt_grade_cal.setOnClickListener {
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
            tv_grade_text.text = "계산 완료"
        }
    }

}
