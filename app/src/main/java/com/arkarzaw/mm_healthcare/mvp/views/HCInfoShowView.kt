package com.arkarzaw.mm_healthcare.mvp.views

import android.arch.lifecycle.LiveData
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO

interface HCInfoShowView : BaseView {

    fun lunchInfoDetail(infoUrl : String)
}