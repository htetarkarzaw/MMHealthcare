package com.arkarzaw.mm_healthcare.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO

@Database(entities = arrayOf(HCInfoVO::class) , version = 1 , exportSchema = false)
abstract class HealthCareDatabase : RoomDatabase() {
    abstract fun HCInfoDao() : HCInfoDao

    companion object {

        private val DB_NAME = "HealthCare_DB"
        private var INSTANCE: HealthCareDatabase? = null

        fun getDatabase(context: Context) : HealthCareDatabase {
            if(INSTANCE ==null){
                INSTANCE = Room.databaseBuilder(context, HealthCareDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSTANCE
            return i!!
        }
    }

}