package com.cnm.shw.db

import android.os.Bundle
import android.util.Log
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
                gradeDb?.gradeDao()?.insertAll(GradeEntity(num, kor, eng, math))
                Log.e("1",gradeDb?.gradeDao()?.getAll().toString())
            }
            val thread = Thread(r)
            thread.start()
            tv_grade_text.text = "insert into score values($num, $kor, $eng, $math)"
        }
    }
}
