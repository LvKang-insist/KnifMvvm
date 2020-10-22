@file:Suppress("UNCHECKED_CAST")

package com.standalone.core.latte

import android.graphics.Color
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar


/**
 * @name LatteConfigurator
 * @package com.lv.library_core.latte
 * @author 345 QQ:1831712732
 * @time 2020/5/15 21:15
 * @description
 */
object LatteConfigurator {

    private val LATTE_CONFIG = LinkedHashMap<LatteConfigKeys, Any>()

    /**
     * 配置完成时调用
     */
    fun configure() {
        LATTE_CONFIG[LatteConfigKeys.CONFIG_READER] = true
    }

    /**
     * put
     */
    fun put(configKeys: LatteConfigKeys, any: Any): LatteConfigurator {
        LATTE_CONFIG[configKeys] = any
        return this
    }


    /**
     * 初始化默认状态栏
     */
    fun withImmersionBar() :LatteConfigurator{
        setImmersionBar {
            transparentBar()//透明状态栏
            fullScreen(false)//有导航情况下，activity全屏显示
            statusBarDarkFont(true)
            keyboardEnable(true)//解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
            fitsSystemWindows(true)//解决状态栏和布局重叠问题，任选其一，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色，还有一些重载方法
        }
        return this
    }

    private fun setImmersionBar(block: ImmersionBar.() -> Unit) {
        LATTE_CONFIG[LatteConfigKeys.CONFIG_IMMERSION] = block
    }

    /**
     * @return 返回全部配置
     */
    fun getLatteConfigs(): LinkedHashMap<LatteConfigKeys, Any> {
        return LATTE_CONFIG
    }

    /**
     * 返回某一项配置
     */
    fun <T> getConfigurator(key: LatteConfigKeys): T {
        val o = LATTE_CONFIG[key] ?: throw NullPointerException(key.toString() + "is NULL")
        return o as T
    }

    /**
     * 返回某一项配置,可能会为 null
     */
    fun <T> getConfiguratorNull(key: LatteConfigKeys): T? {
        val o = LATTE_CONFIG[key] ?: throw NullPointerException(key.toString() + "is NULL")
        return o as T
    }

}