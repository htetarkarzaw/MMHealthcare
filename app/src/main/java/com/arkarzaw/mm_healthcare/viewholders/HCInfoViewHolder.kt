package com.arkarzaw.mm_healthcare

import android.view.View
import com.arkarzaw.mm_healthcare.controllers.HCInfoItemClickLIstener
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO
import com.arkarzaw.mm_healthcare.mvp.presenters.HCInfoPresenter
import com.bumptech.glide.Glide
import com.padcmyanmar.mmnews.kotlin.views.holders.BaseViewHolder
import kotlinx.android.synthetic.main.viewholder_hc_info.view.*

class HCInfoViewHolder(itemView: View,private val mPresenter: HCInfoPresenter) : BaseViewHolder<HCInfoVO>(itemView) {
    override fun setData(data: HCInfoVO) {
        mData = data
        itemView.tvHCTitle.text = data.title
        if(data.image!=null){
            Glide.with(itemView.context)
                    .load(data.image)
                    .into(itemView.ivHCImage)
        }
        itemView.tvAuthorName.text = data.author!!.name
        itemView.tvDate.text = data.pubDate

    }

    override fun onClick(p0: View?) {
        mPresenter.infoClick(mData?.url!!)
    }

}