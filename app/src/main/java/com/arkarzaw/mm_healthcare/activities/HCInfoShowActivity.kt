package com.arkarzaw.mm_healthcare.activities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.customtabs.CustomTabsIntent
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.arkarzaw.mm_healthcare.mvp.presenters.HCInfoPresenter
import com.arkarzaw.mm_healthcare.HCInfoRcAdapter
import com.arkarzaw.mm_healthcare.mvp.views.HCInfoShowView
import com.arkarzaw.mm_healthcare.R
import com.arkarzaw.mm_healthcare.datas.VOs.HCInfoVO
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import saschpe.android.customtabs.CustomTabsHelper
import saschpe.android.customtabs.WebViewFallback

class HCInfoShowActivity :BaseActivity() , HCInfoShowView {


    private lateinit var HCAdapter: HCInfoRcAdapter
    private var mPresenter : HCInfoPresenter? = null
    override fun displayErrorMsg(errMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        this.mPresenter = ViewModelProviders.of(this).get(HCInfoPresenter::class.java!!)
        this.mPresenter!!.initPresenter(this)
        setUp()
        mPresenter!!.getHCInfo().observe(this, Observer<List<HCInfoVO>> { t -> if (t != null) HCAdapter.appendNewData(t) })
    }

    private fun setUp(){
        healthCareRc.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        HCAdapter = HCInfoRcAdapter(this, this!!.mPresenter!!)
        healthCareRc.adapter = HCAdapter
    }

    override fun lunchInfoDetail(infoUrl : String) {
        val customTabsIntent = CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(this.resources
                        .getColor(R.color.colorPrimary))
                .setShowTitle(true)
                .setCloseButtonIcon(BitmapFactory.decodeResource(getResources(), R.drawable.fav_icon))
                .build()

// This is optional but recommended
        CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent)

// This is where the magic happens...
        CustomTabsHelper.openCustomTab(this, customTabsIntent,
                Uri.parse(infoUrl),
                WebViewFallback())
        Log.e("infoVo",infoUrl)
//        val i = Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse(infoUrl)
//        )
//        startActivity(i)
    }
}
