package com.lv.admin

import android.app.Application
import com.lv.library_core.latte.Latte
import com.tencent.rtmp.TXLiveBase


/**
 * @name BaseApplication
 * @class name：com.lv.admin
 * @author 345 QQ:1831712732
 * @time 2020/5/7 22:53
 * @description
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Latte.init(this)
            .withLog()
            .withToastUtils()
            .withComponent()
            .configure()

        val licenceURL = "http://download-1252463788.cossh.myqcloud.com/xiaoshipin/licence_android/RDM_Enterprise.license" // 获取到的 licence url

        val licenceKey = "9bc74ac7bfd07ea392e8fdff2ba5678a" // 获取到的 licence key

        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey)
    }
}