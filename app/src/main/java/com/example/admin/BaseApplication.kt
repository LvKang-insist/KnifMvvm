package com.example.admin

import android.app.Application
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

    @Inject
    lateinit var hiltTest: HiltTest

    override fun onCreate() {
        super.onCreate()
        hiltTest.hiltTest()
    }
}