package com.arkarzaw.mm_healthcare

import android.content.Context
import android.support.v4.widget.NestedScrollView
import android.util.AttributeSet

class HCInfoComponent @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : NestedScrollView(context, attrs, defStyleAttr){

    private lateinit var HCAdapter: HCInfoRcAdapter
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

}