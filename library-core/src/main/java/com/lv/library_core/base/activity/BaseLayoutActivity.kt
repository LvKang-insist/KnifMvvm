package com.lv.library_core.base.activity

import android.widget.Toast
import androidx.lifecycle.Observer
import com.lv.library_core.model.BaseViewModel

/**
 * @name BaseLayoutActivity
 * @package com.lv.library_core.base.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/14 23:16
 * @description
 */

abstract class BaseLayoutActivity<VM : BaseViewModel> : BaseSkinActivity<VM>() {

    override fun initView() {
        super.initView()

        val id = immersion()
        if (id != -1) {
            //执行沉浸式的逻辑
            TODO()
        }

        viewModel.run {
            getFinally().observe(this@BaseLayoutActivity, Observer {
                Toast.makeText(this@BaseLayoutActivity, it, Toast.LENGTH_LONG).show()
            })
        }
    }

    /**
     * 沉浸式状态栏的适配
     */
    open fun immersion(): Int = -1

}