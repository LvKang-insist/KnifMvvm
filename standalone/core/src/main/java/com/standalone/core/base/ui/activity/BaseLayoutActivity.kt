package com.standalone.core.base.ui.activity

import android.widget.Toast
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

abstract class BaseLayoutActivity<VM : BaseViewModel> : BaseSkinActivity<VM>() {

    override fun initView() {
        super.initView()

        viewModel.run {
            //默认实现 Toast
            getFinally().observe(this@BaseLayoutActivity, Observer {
                ToastUtils.show(it)
            })
        }
    }

}