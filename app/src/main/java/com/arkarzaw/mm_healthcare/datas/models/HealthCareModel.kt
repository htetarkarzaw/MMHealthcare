package com.arkarzaw.mm_healthcare.datas.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.arkarzaw.mm_healthcare.HealthCareApp
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO
import com.padcmyanmar.mmnews.kotlin.utils.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HealthCareModel private constructor(context: Context) : BaseModel(context) {
    companion object {
        private var INSTANCE : HealthCareModel? = null
        fun getInstance() : HealthCareModel {
            if(INSTANCE ==null){
                throw RuntimeException("HealthCareModel is being invoked before initializing.")
            }
            val i = INSTANCE
            return i!!
        }
        fun initHealthCareModel(context: Context){
            INSTANCE = HealthCareModel(context)
        }
    }



    fun loadHCInfo(mHCInfoList : MutableLiveData<List<HCInfoVO>> , errMsg : MutableLiveData<String>){
        mTheApi.loadHCInfo(AppConstants.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result ->
                    mHCInfoList.value=result.getInfoList()
                    persistHCInfo(result.getInfoList())},{error->errMsg.value = error.message})
    }

    private fun persistHCInfo(infoList: List<HCInfoVO>) {
        val insertedInfo = mTheDB.HCInfoDao().insertInfo(infoList)
        Log.d(HealthCareApp.TAG, "insertedInfo : $insertedInfo")
    }

    fun getInfoByIDLD(infoId : Long):LiveData<HCInfoVO>{
        return mTheDB.HCInfoDao().getNewsByIdLD(infoId)
    }

}