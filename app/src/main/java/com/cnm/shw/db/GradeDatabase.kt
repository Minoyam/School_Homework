package com.cnm.shw.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [GradeEntity::class], version = 1, exportSchema = false)
abstract class GradeDatabase : RoomDatabase(){
    abstract fun gradeDao() : GradeDao

    companion object{
        private var instance : GradeDatabase? = null

        fun getInstance(context : Context) : GradeDatabase?{
            if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                    GradeDatabase::class.java, "grade.db").addCallback(object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    }).build()
                }
            return instance
        }
    }
}