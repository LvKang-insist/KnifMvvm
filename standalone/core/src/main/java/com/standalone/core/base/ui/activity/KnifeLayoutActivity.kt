package com.standalone.core.base.ui.activity

import android.view.View

/**
 * @name BaseLayoutActivity
 * @package com.lv.library_core.base.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/14 23:16
 * @description
 */

abstract class KnifeLayoutActivity : KnifeSkinActivity() {

    override fun initView() {
        when {
            layout() != View.NO_ID -> {
                setContentView(layout())
            }
            else -> {
                throw NullPointerException("布局初始化异常")
            }
        }
    }

    abstract fun layout(): Int

}