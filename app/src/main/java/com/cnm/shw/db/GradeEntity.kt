package com.cnm.shw.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grade")
data class GradeEntity(
    @PrimaryKey val num: String,
    @ColumnInfo(name = "kor") var kor: String = "0",
    @ColumnInfo(name = "end") var eng: String = "0",
    @ColumnInfo(name = "math") var math: String = "0",
    @ColumnInfo(name = "total") var total: String = "0",
    @ColumnInfo(name = "avg") var avg: String = "0"
)