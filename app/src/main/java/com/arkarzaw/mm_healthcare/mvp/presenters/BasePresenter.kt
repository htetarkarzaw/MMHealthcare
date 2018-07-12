package com.arkarzaw.mm_healthcare.mvp.presenters

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.arkarzaw.mm_healthcare.mvp.views.BaseView

open class BasePresenter<V : BaseView> : ViewModel() {

    protected var mView: V? = null
    protected var errorLD: MutableLiveData<String>? = null

    open fun initPresenter(view: V) {
        this.mView = view
        errorLD = MutableLiveData()
    }


}