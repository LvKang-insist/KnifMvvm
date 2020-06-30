package com.lv.admin

import android.app.Application
import com.lv.library_core.net.ApiServices
import com.standalone.core.latte.Latte


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
            .withLvHttp(ApiServices::class.java)
            .configure()

    }
}