package com.standalone.core.base.ui.frag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @name BaseLayoutFragment
 * @package com.lv.library_core.base.ui.frag
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:52
 * @description 以普通的形式加载 fragment，拒绝使用 dataBinding
 */

abstract class KnifeLayoutFragment : KnifeFragment() {

    abstract fun layout(): Int

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View {
        when {
            layout() != View.NO_ID -> {
                return inflater.inflate(layout(), container, false)
            }
            else -> {
                throw NullPointerException("布局初始化异常")
            }
        }
    }

}