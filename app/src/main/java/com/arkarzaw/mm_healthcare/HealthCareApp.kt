package com.arkarzaw.mm_healthcare

import android.app.Application
import com.arkarzaw.mm_healthcare.datas.models.HealthCareModel

class HealthCareApp : Application() {
    companion object {
        const val TAG ="HealthCareApp"
    }

    override fun onCreate() {
        super.onCreate()
        HealthCareModel.initHealthCareModel(applicationContext)
    }
}