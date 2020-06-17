package com.cnm.shw.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentEntity(
    @PrimaryKey val num: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "age") var age: String,
    @ColumnInfo(name = "sex") var sex: String
)