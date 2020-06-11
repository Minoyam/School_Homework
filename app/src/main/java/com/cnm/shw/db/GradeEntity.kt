package com.cnm.shw.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grade")
data class GradeEntity(
    @PrimaryKey val num : String,
    @ColumnInfo(name = "kor") val kor : String?,
    @ColumnInfo(name = "end") val eng : String?,
    @ColumnInfo(name = "math") val math : String?
)