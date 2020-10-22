package com.lv.library_core.startup

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils
import com.standalone.core.latte.Latte
import java.util.*

/**
 * @name UtilsInitializer
 * @package com.lv.admin
 * @author 345 QQ:1831712732
 * @time 2020/6/30 23:30
 * @description 初始化工具类
 */

class UtilsInitializer : Initializer<UtilsInit> {
    override fun create(context: Context): UtilsInit {
        UtilsInit.init(context.applicationContext as Application)
        return UtilsInit
    }

    /**
     * 在 ComponentInitializer 之后初始化 当前类
     */
    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        val dependencies = arrayListOf<Class<out Initializer<*>>>()
        dependencies.add(ComponentInitializer::class.java)
        return Collections.emptyList()
    }

}

object UtilsInit {
    private const val TAG = "UtilsInit"
    fun init(application: Application) {

        //初始化项目配置
        Latte.init(application)
            .withImmersionBar()
            .configure()

        //初始化 Toast
        ToastUtils.init(application)

        //初始化 MMKV
//        MMKV.initialize(application)

        //初始化 Log
        XLog.init(
            LogConfiguration.Builder()
                .t() //允许打印线程信息
                .tag("345")
                .build()
        )
        Log.e(TAG, "init: 完成")
    }
}