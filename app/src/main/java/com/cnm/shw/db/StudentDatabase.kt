package com.cnm.shw.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [StudentEntity::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase(){
    abstract fun studentDao() : StudentDao

    companion object{
        private var instance : StudentDatabase? = null

        fun getInstance(context : Context) : StudentDatabase?{
            if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                    StudentDatabase::class.java, "student.db").addCallback(object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    }).build()
                }
            return instance
        }
    }
}