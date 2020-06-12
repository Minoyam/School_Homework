package com.cnm.shw.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GradeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg grade: GradeEntity)

    @Query("SELECT * FROM grade")
    fun getAll(): List<GradeEntity>
}