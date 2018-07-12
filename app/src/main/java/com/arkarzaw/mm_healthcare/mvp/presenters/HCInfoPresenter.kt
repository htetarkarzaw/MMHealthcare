package com.arkarzaw.mm_healthcare.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.arkarzaw.mm_healthcare.controllers.HCInfoItemClickLIstener
import com.arkarzaw.mm_healthcare.datas.models.HealthCareModel
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO
import com.arkarzaw.mm_healthcare.mvp.views.HCInfoShowView

class HCInfoPresenter : BasePresenter<HCInfoShowView>() , HCInfoItemClickLIstener {

    private var mHCInfoVOS: MutableLiveData<List<HCInfoVO>>? = null

    override fun initPresenter(view: HCInfoShowView) {
        super.initPresenter(view)
        mHCInfoVOS = MutableLiveData<List<HCInfoVO>>()
        HealthCareModel.getInstance().loadHCInfo(mHCInfoVOS!!, this!!.errorLD!!)
    }

    open fun getHCInfo():LiveData<List<HCInfoVO>>{
        return this!!.mHCInfoVOS!!
    }

    override fun infoClick(infoUrl: String) {
        mView?.lunchInfoDetail(infoUrl)
    }
}