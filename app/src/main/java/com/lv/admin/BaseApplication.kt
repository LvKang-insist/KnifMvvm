package com.lv.admin

import android.app.Application
import com.lv.library_core.latte.Latte
import com.tencent.rtmp.TXLiveBase
import com.www.net.LvCreator
import com.www.net.LvHttp


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

        LvCreator.init("https://github.com/LvKang-insist/").log(true)

        val licenceURL =
            "http://license.vod2.myqcloud.com/license/v1/b6e51dd3896f420cc0481a88f0aea56e/TXLiveSDK.licence" // 获取到的 licence url

        val licenceKey = "33871031779fa85fa83cb4dc3ade633d" // 获取到的 licence key

        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey)
    }
}