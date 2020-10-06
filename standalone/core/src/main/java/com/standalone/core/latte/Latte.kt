package com.standalone.core.latte

import android.app.Application
import com.gyf.immersionbar.ImmersionBar

/**
 * @name Latte
 * @package com.lv.library_core.latte
 * @author 345 QQ:1831712732
 * @time 2020/5/15 21:14
 * @description 获取配置信息
 */
object Latte {

    fun init(context: Application): LatteConfigurator {
        LatteConfigurator.put(LatteConfigKeys.APP_CONTEXT, context)
        return LatteConfigurator
    }

    /**
     * @return 返回一个全局Context
     */
    fun getAppContext(): Application {
        return LatteConfigurator.getConfigurator(LatteConfigKeys.APP_CONTEXT)
    }


    /**
     * @return 一个 Value
     */
    fun <T> getValue(key: LatteConfigKeys): T {
        return LatteConfigurator.getConfigurator(key) as T
    }


    /**
     * 获取默认的状态栏配置
     */
    fun getImmersionBar(): (ImmersionBar.() -> Unit?)? {
        return LatteConfigurator.getConfiguratorNull(LatteConfigKeys.CONFIG_IMMERSION)
    }

}