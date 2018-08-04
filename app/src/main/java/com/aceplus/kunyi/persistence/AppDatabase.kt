package com.aceplus.kunyi.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.persistence.Dao.JobsDao
import com.aceplus.kunyi.persistence.TypeConvertor.*

/**
 * Created by kkk on 8/1/2018.
 */
@Database(entities = arrayOf(JobsVO::class), version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun jobsDao(): JobsDao

    companion object {
        private val DB_NAME = "Ku_Nyi.DB"
        var INSATNCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSATNCE == null) {
                INSATNCE = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSATNCE
            return i!!
        }
    }
}