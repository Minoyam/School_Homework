package com.cnm.shw.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GradeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg grade: GradeEntity)

    @Query("SELECT * FROM grade order by grade.num")
    fun getAll(): List<GradeEntity>

    @Query("SELECT * FROM grade where grade.num = :toString")
    fun getOne(toString: String): GradeEntity

    @Query("DELETE FROM grade where grade.num = :toString")
    fun delete(toString: String)
}