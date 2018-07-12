package com.arkarzaw.mm_healthcare

import android.content.Context
import android.view.ViewGroup
import com.arkarzaw.mm_healthcare.controllers.HCInfoItemClickLIstener
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO
import com.arkarzaw.mm_healthcare.mvp.presenters.HCInfoPresenter
import com.padcmyanmar.mmnews.kotlin.adapters.BaseRecyclerAdapter
import com.padcmyanmar.mmnews.kotlin.views.holders.BaseViewHolder

class HCInfoRcAdapter(context :Context,private val mPresenter:HCInfoPresenter) : BaseRecyclerAdapter<HCInfoViewHolder , HCInfoVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HCInfoVO> {
        val newItemView = mLayoutInflator.inflate(R.layout.viewholder_hc_info,parent,false)
        return HCInfoViewHolder(newItemView,mPresenter)
    }

}