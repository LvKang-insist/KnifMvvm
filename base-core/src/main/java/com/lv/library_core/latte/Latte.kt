package com.lv.library_core.latte

import android.app.Application

/**
 * @name Latte
 * @package com.lv.library_core.latte
 * @author 345 QQ:1831712732
 * @time 2020/5/15 21:14
 * @description 获取配置信息
 */
object Latte {

    fun init(context: Application): LatteConfigurator {
        getConfiguration()[LatteConfigKeys.APP_CONTEXT] = context.applicationContext
        return getInstance()
    }

    /**
     * @return 返回一个 全局Context
     */
    fun getAppContext(): Application {
        return getInstance().getConfigurator(LatteConfigKeys.APP_CONTEXT)
    }


    /**
     * 获取一个 Value
     */
    fun <T> getValue(key: LatteConfigKeys): T {
        return getInstance().getConfigurator(key) as T
    }

    private fun getConfiguration(): LinkedHashMap<LatteConfigKeys, Any> {
        return getInstance().getLatteConfigs()
    }

    private fun getInstance(): LatteConfigurator {
        return LatteConfigurator
    }
}