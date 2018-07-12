package com.arkarzaw.mm_healthcare.networks

import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO
import com.google.gson.annotations.SerializedName

class HCInfoResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("healthcare-info")
    private var infoList: List<HCInfoVO>? = null

    fun getInfoList(): List<HCInfoVO >{
        if (infoList == null) infoList = ArrayList<HCInfoVO>()
        val listVal = infoList
        return listVal!!
    }
}