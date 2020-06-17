package com.cnm.shw.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg student: StudentEntity)

    @Query("SELECT * FROM student order by student.num")
    fun getAll(): List<StudentEntity>
}