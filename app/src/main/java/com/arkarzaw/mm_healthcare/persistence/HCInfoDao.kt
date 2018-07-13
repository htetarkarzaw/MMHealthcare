package com.arkarzaw.mm_healthcare.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO

@Dao
interface HCInfoDao {

    @get:Query("SELECT * FROM HCInfo")
    val allInfo: List<HCInfoVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInfo(infoVo: List<HCInfoVO>): LongArray

    @Query("SELECT * FROM HCInfo WHERE id = :infoId")
    fun getInfoById(infoId: String): HCInfoVO

    @Query("SELECT * FROM HCInfo WHERE id = :infoId")
    fun getNewsByIdLD(infoId: Long): LiveData<HCInfoVO>
}