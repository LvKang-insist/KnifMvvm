package com.lv.library_core.startup

import android.app.Application
import android.content.Context
import androidx.startup.Initializer


/**
 * @author 345 QQ:1831712732
 * @package : com.example.library_core.startup
 * @time : 2020/10/15  21:27
 * @description :初始化友盟
 */
class UMSDKInit : Initializer<UmInit> {
    override fun create(context: Context): UmInit {
        UmInit.init(context.applicationContext as Application)
        return UmInit
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        //在 ComponentInitializer 初始化完成后在初始化当前 SDK
        return mutableListOf(ComponentInitializer::class.java)
    }
}

object UmInit {
    private const val TAG = "UmInit"
    fun init(context: Application) {

    }
}