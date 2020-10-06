package com.standalone.core.ui.bar

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.standalone.core.latte.Latte

/**
 * @author 345 QQ:1831712732
 * @package : com.standalone.core.ui.bar
 * @time : 2020/10/6  14:34
 * @description :
 */
interface IBarExpand {

    fun Activity.upDataBar() {
        immersionBar {
            if (isImmersionBar()) immersionBar { initBar() }
            else Latte.getImmersionBar()?.apply {
                expand()
                invoke(this@immersionBar)
            }?:immersionBar { initBar()}
        }
    }

    fun Fragment.upDataBar() {
        immersionBar {
            if (isImmersionBar()) immersionBar { initBar() }
        }
    }


    fun ImmersionBar.initBar() {
        transparentBar()
        fullScreen(false)
        expand()
        statusBarDarkFont(isBarDark())
    }


    /**
     * 通过此方法可进行扩展
     */
    fun ImmersionBar.expand() = Unit

    /**
     * 是否自定义状态栏
     * 默认使用全局配置
     */
    fun isImmersionBar() = false

    /**
     * 设置状态栏颜色，false 表示 白色，true 为黑色
     *
     * @return
     */
    fun isBarDark(): Boolean = true

}