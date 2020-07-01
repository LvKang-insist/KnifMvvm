package com.lv.admin

import android.app.Application
import android.util.Log
import com.lv.library_core.net.ApiServices
import com.standalone.core.latte.Latte
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


/**
 * @name BaseApplication
 * @class name：com.lv.admin
 * @author 345 QQ:1831712732
 * @time 2020/5/7 22:53
 * @description
 */
//https://juejin.im/post/5ef2f31951882565a94e06a5#heading-0
@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}