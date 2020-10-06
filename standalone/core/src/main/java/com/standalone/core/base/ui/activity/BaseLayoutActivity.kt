package com.standalone.core.base.ui.activity

import android.view.View
import androidx.lifecycle.Observer
import com.hjq.toast.ToastUtils
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name BaseLayoutActivity
 * @package com.lv.library_core.base.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/14 23:16
 * @description
 */

abstract class BaseLayoutActivity : BaseSkinActivity() {

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